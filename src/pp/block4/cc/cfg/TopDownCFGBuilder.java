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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Template top-down CFG builder.
 */
public class TopDownCFGBuilder extends FragmentBaseListener {
    /**
     * The CFG being built.
     */
    private Graph graph;

    private Map<ParseTree, Set<ParseTree>> lastTrees;
    private Map<ParseTree, ParseTree> beginMap;
    private Map<ParseTree, Node> nodeMap;
    private Map<ParseTree, Set<Node>> exitMap;
    private Map<ParseTree, Node> entryMap;

    /**
     * Main method to build and print the CFG of a simple Java program.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: [filename]+");
            return;
        }
        TopDownCFGBuilder builder1 = new TopDownCFGBuilder();
        BottomUpCFGBuilder builder2 = new BottomUpCFGBuilder();
        for (String filename : args) {
            System.out.println(filename);
//            try {
//                int i = 1;
//                for (String line : Files.readAllLines(Paths.get(filename))) {
//                    System.out.println((i++) + "\t" + line);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Graph graph1 = builder1.build(new File(filename));
            Graph graph2 = builder2.build(new File(filename));
            System.out.println(graph1);
            System.out.println(graph2);
            System.out.println();
        }
    }

    /**
     * Builds the CFG for a program contained in a given file.
     */
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

    /**
     * Builds the CFG for a program given as an ANTLR parse tree.
     */
    public Graph build(ProgramContext tree) {
        this.graph = new Graph();
        this.beginMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.exitMap = new HashMap<>();
        this.lastTrees = new HashMap<>();
        this.entryMap = new HashMap<>();
        new ParseTreeWalker().walk(new MyListener(), tree);
        return graph;
    }

    /**
     * Adds a node to he CGF, based on a given parse tree node.
     * Gives the CFG node a meaningful ID, consisting of line number and
     * a further indicator.
     */
    private Node addNode(ParserRuleContext node, String text) {
        return this.graph.addNode(node.getStart().getLine() + ": " + text);
    }

    private Node addLonelyNode(ParserRuleContext node, String text) {
        Node result = addNode(node, text);
        nodeMap.put(node, result);

        ParseTree parent = beginMap.get(node);

        if (parent != null) {
            if (lastTrees.containsKey(parent)) {
                followLastTrees(parent, result);
            } else {
                for (Node entry : exitMap.get(parent)) {
                    entry.addEdge(result);
                }
            }
        } else {
            parent = node.getParent();
            while (!nodeMap.containsKey(parent)) {
                parent = parent.getParent();
            }
            nodeMap.get(parent).addEdge(result);
        }

        Set<Node> temp = new HashSet<>();
        temp.add(result);
        exitMap.put(node, temp);

        if (entryMap.containsKey(node)) {
            result.addEdge(entryMap.get(node));
        }

        return result;
    }

    public void followLastTrees(ParseTree parent, Node node) {
        for (ParseTree tree : lastTrees.get(parent)) {
            if (parent != tree && lastTrees.containsKey(tree)) {
                followLastTrees(tree, node);
            } else {
                for (Node exit : exitMap.get(tree)) {
                    exit.addEdge(node);
                }
            }
        }
    }

    private class MyListener extends FragmentBaseListener {
        @Override
        public void enterProgram(@NotNull FragmentParser.ProgramContext ctx) {
            exitMap.put(ctx, new HashSet<Node>());
            linkStatements(ctx, ctx.children);
        }

        @Override
        public void enterDecl(@NotNull FragmentParser.DeclContext ctx) {
            addLonelyNode(ctx, "Declare");
        }

        @Override
        public void enterAssignStat(@NotNull FragmentParser.AssignStatContext ctx) {
            addLonelyNode(ctx, "Stat");
        }

        @Override
        public void enterIfStat(@NotNull FragmentParser.IfStatContext ctx) {
            addLonelyNode(ctx, "If");

            Set<ParseTree> temp = new HashSet<>();

//            beginMap.put(ctx.stat(0),ctx);
            temp.add(ctx.stat(0));

            if (ctx.stat().size() > 1) {
//                beginMap.put(ctx.stat(1),ctx);
                temp.add(ctx.stat(1));
            } else {
                temp.add(ctx);
            }

            lastTrees.put(ctx, temp);

            if (entryMap.containsKey(ctx)) {
                for (ParseTree last : temp) {
                    entryMap.put(last, entryMap.get(ctx));
                }
            }
        }

        @Override
        public void enterWhileStat(@NotNull FragmentParser.WhileStatContext ctx) {
            Node node = addLonelyNode(ctx, "While");

//            beginMap.put(ctx.stat(),ctx);

            entryMap.put(ctx.stat(), node);
        }

        @Override
        public void enterBlockStat(@NotNull FragmentParser.BlockStatContext ctx) {
            if (ctx.stat().size() > 0) {
                linkStatements(ctx, new LinkedList<ParseTree>(ctx.stat()));
                beginMap.put(ctx.stat(0), beginMap.get(ctx));

                ParseTree last = ctx.stat(ctx.stat().size() - 1);

                Set<ParseTree> temp = new HashSet<>();
                temp.add(last);
                lastTrees.put(ctx, temp);

                if (entryMap.containsKey(ctx)) {
                    entryMap.put(last, entryMap.get(ctx));
                }
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
            exitMap.put(ctx, new HashSet<Node>());
        }

        @Override
        public void enterContStat(@NotNull FragmentParser.ContStatContext ctx) {
            ParserRuleContext nodeAt = ctx.getParent();

            while (!(nodeAt instanceof FragmentParser.WhileStatContext)) {
                nodeAt = nodeAt.getParent();
            }

            addLonelyNode(ctx, "Continue").addEdge(nodeMap.get(nodeAt));
            exitMap.put(ctx, new HashSet<Node>());
        }

        private void linkStatements(ParserRuleContext ctx, Collection<ParseTree> collection) {
            Iterator<ParseTree> iterator = collection.iterator();
            ParseTree last = ctx;
            while (iterator.hasNext()) {
                ParseTree next = iterator.next();
                beginMap.put(next, last);
                last = next;
            }
        }
    }
}
