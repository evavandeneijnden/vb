package pp.s1219871.q2_3;

import java.io.File;
import java.io.IOException;
import java.util.*;

import pp.s1219871.q2.Graph;
import pp.s1219871.q2.Node;
import pp.iloc.Assembler;
import pp.iloc.model.*;
import pp.iloc.parse.FormatException;

public class ILOC2DDG {
	/** The singleton instance of this class. */
	private static final ILOC2DDG instance = new ILOC2DDG();

	/** Returns the singleton instance of this class. */
	public static ILOC2DDG instance() {
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
	private ILOC2DDG() {
		// empty by design
	}

	public Graph convert(Program prog) {
		// TODO: Fill in
        Map<Integer, ArrayList<Integer>> resultMap = new HashMap<>();
        List<Op> opList = prog.getOps();
//      Loop over opList backwards
        for (int i = opList.size() ; i>= 0; i--){
            Op line = null;
            String opCode = null;

            // If it is not the artifical end node
            if(i < opList.size()) {
                line = opList.get(i);
                opCode = line.getOpCode().toString();
            }

//          Handle "special" cases first
            if ( i == opList.size()){
//              Last line goes to artificial end-node. NOTE: label of artificial end-node is -1!
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(opList.get(opList.size() - 1).getLine());
                resultMap.put(-1, tempList);
                continue;
            }
            else if (opCode.equals("pop")){
                int fromLine = line.getLine();
                int toLine = -100;
                Stack<Integer> pushPopStack = new Stack<>();
                pushPopStack.push(1);
                // Only look at corresponding push which is coming
                // Be careful because other pops may be higher in the op list as wel
                // Therefore, model stack to find corresponding push
                for(int j = i - 1; j >= 0; j--) {
                    Op line2 = opList.get(j);

                    // Found a pop, skip next push
                    if(line2.getOpCode() == OpCode.pop) {
                        pushPopStack.push(1);
                    }

                    // Found a push, pop of the stack and see if it is our push
                    if(line2.getOpCode() == OpCode.push) {
                        pushPopStack.pop();
                        if(pushPopStack.empty()) {
                            toLine = line2.getLine();
                            break;
                        }
                    }
                }

                ArrayList<Integer> tempList = resultMap.get(fromLine);
                if (tempList != null){
                    tempList.add(toLine);
                }
                else {
                    tempList = new ArrayList<>();
                    tempList.add(toLine);
                    resultMap.put(fromLine, tempList);
                }

                continue;
            }
            else if (opCode.equals("storeAI") || opCode.equals("store") || opCode.equals("storeAO") || opCode.equals("cstoreAI") || opCode.equals("cstore") || opCode.equals("cstoreAO")){
                int toLine = line.getLine();
                ArrayList<Integer> tempList = resultMap.get(-1);
                if (tempList != null){
                    tempList.add(toLine);
                }
                else {
                    tempList = new ArrayList();
                    tempList.add(toLine);
                    resultMap.put(-1, tempList);
                }
            }


            boolean notFound = true;
            for (int j = 0; j < line.getOpCode().getSourceCount() && notFound; j++){
                Operand argument = line.getArgs().get(j);

                for (int k = i - 1; k >= 0 && notFound; k--){
                    Op innerLine = opList.get(k);
                    int targetCount = innerLine.getOpCode().getTargetCount();

                    for (int l = 0 ; l < targetCount && notFound; l++){
                        List<Operand> targetArgs = innerLine.getArgs();
                        Operand target = targetArgs.get(targetArgs.size() - 1 - l);

                        if (argument.equals(target)){
                            int fromLine = line.getLine();
                            int toLine = innerLine.getLine();

                            ArrayList<Integer> tempList = resultMap.get(fromLine);
                            if (tempList != null){
                                tempList.add(toLine);
                            }
                            else {
                                tempList = new ArrayList();
                                tempList.add(toLine);
                            }
                            resultMap.put(fromLine, tempList);
                            notFound = false;
                        }
                    }

                }
            }

        }
        Graph result = mapToGraph(resultMap);

        return result;
	}

    public Graph mapToGraph(Map<Integer, ArrayList<Integer>> map){
        Graph result = new Graph();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            Integer key = entry.getKey();
            List<Integer> values = entry.getValue();
            Node sourceNode = getNodebyID(result, key.toString());
//            System.out.println("entry: " + key + " " + values);

//            System.out.println("sourceNode: " + sourceNode);
            if(sourceNode == null) {
                sourceNode = result.addNode(key.toString());
            }

            for (int j = 0; j < values.size(); j++){
                Node targetNode = getNodebyID(result, values.get(j).toString());
//                    System.out.println("targetNode: " + targetNode);
                if (targetNode == null){
                    targetNode = result.addNode(values.get(j).toString());
                }

                sourceNode.addEdge(targetNode);
            }
        }
        return result;
    }

    public Node getNodebyID(Graph g, String id){
        List<Node> nodes = g.getNodes();
        for (int i = 0; i< nodes.size(); i++){
            Node node = nodes.get(i);
            if (node.getId().equals(id)){
                return node;
            }
        }
        return null;
    }
}
