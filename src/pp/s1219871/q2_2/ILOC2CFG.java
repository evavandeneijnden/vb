package pp.s1219871.q2_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pp.iloc.Assembler;
import pp.iloc.model.Label;
import pp.iloc.model.Op;
import pp.iloc.model.OpCode;
import pp.iloc.model.Program;
import pp.iloc.parse.FormatException;

public class ILOC2CFG {
	/** The singleton instance of this class. */
	private static final ILOC2CFG instance = new ILOC2CFG();

	/** Returns the singleton instance of this class. */
	public static ILOC2CFG instance() {
		return instance;
	}

	/** Converts an ILOC file given as parameter and prints out the
	 * resulting CFG. 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: filename");
		}
		try {
			Program prog = Assembler.instance().assemble(new File(args[0]));
			System.out.println(instance().convert(prog));
		} catch (FormatException | IOException exc) {
			exc.printStackTrace();
		}
	}

	/** Private constructor for the singleton instance. */
	private ILOC2CFG() {
		// empty by design
	}

	public Graph convert(Program prog) {
		Graph result = new Graph();
		Set<Label> labels = prog.labelMap.keySet();
		for (Label label:labels){
			Node node = result.getNode(label.getValue());


			if (node == null) {
				node = result.addNode(label.getValue());
			}
			boolean routine_end = false;
			for (int line = prog.getLine(label); !routine_end && line < prog.getInstr().size(); line++){
				Op op = prog.getOpAt(line);
				if (op.getOpCode() == OpCode.cbr){
					routine_end = true;
					if (result.getNode(op.getArgs().get(1).toString()) == null){
						result.addNode(op.getArgs().get(1).toString());
					}
					node.addEdge(result.getNode(op.getArgs().get(1).toString()));

					if (result.getNode(op.getArgs().get(2).toString()) == null){
						result.addNode(op.getArgs().get(2).toString());
					}
					node.addEdge(result.getNode(op.getArgs().get(2).toString()));

				}
				else if (op.getOpCode() == OpCode.jumpI){
					routine_end = true;

					if (result.getNode(op.getArgs().get(0).toString()) == null){
						result.addNode(op.getArgs().get(0).toString());
					}
					node.addEdge(result.getNode(op.getArgs().get(0).toString()));
				}

			}

		}
		// Removes nodes if they have no edges, i.e. they are unreachable
		List<Node> to_remove = new ArrayList<>();
		for (Node checkNode : result.getNodes()){
			if (checkNode.getEdges().size() == 0){
				to_remove.add(checkNode);
			}
		}
		for (Node removeNode : to_remove){
			result.getNodes().remove(removeNode);
		}
		return result;
	}
}
