package pp.block4.cc.cfg;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pp.block4.cc.ErrorListener;
import pp.block4.cc.cfg.FragmentParser.ProgramContext;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/** Template top-down CFG builder. */
public class TopDownCFGBuilder extends FragmentBaseListener {
	/** The CFG being built. */
	private Graph graph;

    private Map<ParseTree, Node> beginMap;
    private Map<ParseTree, Set<Node>> exitMap;

	/** Builds the CFG for a program contained in a given file. */
	public Graph build(File file) {
		Graph result = null;
		ErrorListener listener = new ErrorListener();
		try {
			CharStream chars = new ANTLRInputStream(new FileReader(file));
			Lexer lexer = new FragmentLexer(chars);
			lexer.removeErrorListeners();
			lexer.addErrorListener(listener);
			TokenStream tokens = new CommonTokenStream(lexer);
			FragmentParser parser = new FragmentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(listener);
			ProgramContext tree = parser.program();
			if (listener.hasErrors()) {
				System.out.printf("Parse errors in %s:%n", file.getPath());
				for (String error : listener.getErrors()) {
					System.err.println(error);
				}
			} else {
				result = build(tree);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/** Builds the CFG for a program given as an ANTLR parse tree. */
	public Graph build(ProgramContext tree) {
		this.graph = new Graph();
        this.beginMap = new HashMap<>();
        this.exitMap = new HashMap<>();
        new ParseTreeWalker().walk(new MyListener(), tree);
        return graph;
	}

	/** Adds a node to he CGF, based on a given parse tree node.
	 * Gives the CFG node a meaningful ID, consisting of line number and 
	 * a further indicator.
	 */
	private Node addNode(ParserRuleContext node, String text) {
		return this.graph.addNode(node.getStart().getLine() + ": " + text);
	}

    private Node addLonelyNode(ParserRuleContext node, String text) {
        Node result = addNode(node, text);

        beginMap.put(node, result);

        Set<Node> temp = new HashSet<>();
        temp.add(result);
        exitMap.put(node, temp);

        return result;
    }

	/** Main method to build and print the CFG of a simple Java program. */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Usage: [filename]+");
			return;
		}
		TopDownCFGBuilder builder = new TopDownCFGBuilder();
		for (String filename : args) {
			File file = new File(filename);
			System.out.println(filename);
			System.out.println(builder.build(file));
		}
	}

    private class MyListener extends FragmentBaseListener {
        @Override
        public void enterProgram(@NotNull FragmentParser.ProgramContext ctx) {
            exitMap.put(ctx,new HashSet<Node>());
        }

        @Override
        public void enterDecl(@NotNull FragmentParser.DeclContext ctx) {
            enterAssignStat(ctx, "Declare");
        }

        @Override
        public void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
            enterAssignStat(ctx, "Stat");
        }

        private Node enterAssignStat(ParserRuleContext ctx, String text){
            Node node = addLonelyNode(ctx, text);
            ParseTree parent = ctx.getParent();

            if (!beginMap.containsKey(parent)) {
                beginMap.put(parent,node);
            }

            if (exitMap.containsKey(parent)) {
                for (Node exit : exitMap.get(parent)) {
                    exit.addEdge(node);
                }
            }

            Set<Node> temp = new HashSet<>();
            temp.add(node);
            exitMap.put(parent,temp);
            return node;
        }

        // ####################################
        @Override
        public void enterIfStat(@NotNull FragmentParser.IfStatContext ctx) {
            Node node = addNode(ctx, "If");

            beginMap.put(ctx, node);

            FragmentParser.StatContext ifStat = ctx.stat(0);
            node.addEdge(beginMap.get(ifStat));
            Set<Node> temp = new HashSet<>(exitMap.get(ifStat));

            if (ctx.stat().size() > 1) {
                FragmentParser.StatContext elseStat = ctx.stat(1);
                node.addEdge(beginMap.get(elseStat));
                temp.addAll(exitMap.get(elseStat));
            } else {
                temp.add(node);
            }
            exitMap.put(ctx, temp);
        }

        @Override
        public void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
            Node node = addLonelyNode(ctx, "While");
            node.addEdge(beginMap.get(ctx.stat()));
            for (Node exit : exitMap.get(ctx.stat())) {
                exit.addEdge(node);
            }
        }

        @Override
        public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
            if (ctx.stat().size() > 0) {
                linkStatements(ctx, (new LinkedList<ParseTree>(ctx.stat())).iterator());
            } else {
                addLonelyNode(ctx, "NOP");
            }
        }

        @Override
        public void enterPrintStat(@NotNull FragmentParser.PrintStatContext ctx) {
            addLonelyNode(ctx, "Print");
        }

        @Override
        public void enterBreakStat(@NotNull FragmentParser.BreakStatContext ctx) {
            ParserRuleContext nodeAt = ctx.getParent();

            while (!(nodeAt instanceof FragmentParser.WhileStatContext)) {
                nodeAt = nodeAt.getParent();
            }

            exitMap.get(nodeAt).add(addLonelyNode(ctx, "Break"));
        }

        @Override
        public void enterContStat(@NotNull FragmentParser.ContStatContext ctx) {
            ParserRuleContext nodeAt = ctx.getParent();
            ParserRuleContext last = nodeAt;

            while (!(nodeAt instanceof FragmentParser.WhileStatContext)) {
                last = nodeAt;
                nodeAt = nodeAt.getParent();
            }

            exitMap.get(last).add(addLonelyNode(ctx, "Continue"));
        }

        private void linkStatements(ParserRuleContext ctx, Iterator<ParseTree> iterator){
            ParseTree next = iterator.next();
            ParseTree last;
            beginMap.put(ctx, beginMap.get(next));
            while (iterator.hasNext()) {
                last = next;
                next = iterator.next();
                for (Node exit : exitMap.get(last))
                    exit.addEdge(beginMap.get(next));
            }
            exitMap.put(ctx, exitMap.get(next));
        }
    }
}
