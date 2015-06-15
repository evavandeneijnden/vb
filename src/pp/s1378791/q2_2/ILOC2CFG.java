package pp.s1378791.q2_2;

import pp.iloc.Assembler;
import pp.iloc.model.Label;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class ILOC2CFG {
    /**
     * The singleton instance of this class.
     */
    private static final ILOC2CFG instance = new ILOC2CFG();

    private final Map<Label, Node> labelNodeMap = new HashMap<>();
    private final LinkedList<Label> to_process = new LinkedList<>();

    /**
     * Returns the singleton instance of this class.
     */
    public static ILOC2CFG instance() {
        return instance;
    }

    /**
     * Converts an ILOC file given as parameter and prints out the
     * resulting CFG.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: filename");
        } else {
            try {
                for (String arg : args) {
                    System.out.println("Processing: " + arg);
                    Program prog = Assembler.instance().assemble(new File(arg));
                    System.out.println(new ILOC2CFG().convert(prog));
                }
            } catch (FormatException | IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    /**
     * Private constructor for the singleton instance.
     */
//    private ILOC2CFG() {
        // empty by design
//    }

    private void makeEdge(Label label_from, Label label_to, Graph result){
        makeNode(label_to, result);
        labelNodeMap.get(label_from).addEdge(labelNodeMap.get(label_to));
    }

    private void makeNode(Label label, Graph result) {
        if (!labelNodeMap.containsKey(label)) {
            to_process.add(label);
            labelNodeMap.put(label, result.addNode(label.getValue()));
        }
    }

    public Graph convert(Program prog) {
        Graph result = new Graph();

        HashSet<Label> processed = new HashSet<>();

        to_process.push(prog.getOpAt(0).getLabel());

        while (!to_process.isEmpty()) {
            Label label = to_process.pop();
            if (!processed.contains(label)) {
                makeNode(label, result);

                boolean found_end = false;
                for (int line = prog.labelMap.get(label); !found_end && line < prog.size(); line++) {
                    Op op = prog.getOpAt(line);
                    if (op.getOpCode() == OpCode.jumpI) {
                        found_end = true;
                        makeEdge(label, (Label) op.getArgs().get(0), result);
                    } else if (op.getOpCode() == OpCode.cbr) {
                        found_end = true;
                        makeEdge(label, (Label) op.getArgs().get(1), result);
                        makeEdge(label, (Label) op.getArgs().get(2), result);
                    }
                }
                processed.add(label);
            }
        }
        return result;
    }
}
