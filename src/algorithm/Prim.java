package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {
    public ArrayList<PrimEdge> prim(String startNode, ArrayList<PrimEdge> edges) {
        PrimEdge currentEdge, poppedEdge, adjacentEdgesNode;
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<PrimEdge> currentEdgeList, candidateEdgeList, adjacentEdgesNodes;
        ArrayList<PrimEdge> mst = new ArrayList<>();
        HashMap<String, ArrayList<PrimEdge>> adjacentEdges = new HashMap<>();
        PriorityQueue<PrimEdge> priorityQueue;

        for(int index = 0; index < edges.size(); index++) {
            currentEdge= edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<PrimEdge>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<PrimEdge>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new PrimEdge(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new PrimEdge(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<PrimEdge>());

        priorityQueue = new PriorityQueue<>();

        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                connectedNodes.add(poppedEdge.node2);
                mst.add(new PrimEdge(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgesNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<PrimEdge>());
                for (int index = 0; index < adjacentEdgesNodes.size(); index++) {
                    adjacentEdgesNode = adjacentEdgesNodes.get(index);
                    if (!connectedNodes.contains(adjacentEdgesNode.node2)) {
                        priorityQueue.add(adjacentEdgesNode);
                    }
                }
            }
        }

        return mst;
    }


    public static void main(String[] args) {
        ArrayList<PrimEdge> edges = new ArrayList<>();
        edges.add(new PrimEdge(7, "A", "B"));
        edges.add(new PrimEdge(5, "A", "D"));
        edges.add(new PrimEdge(8, "B", "C"));
        edges.add(new PrimEdge(9, "B", "D"));
        edges.add(new PrimEdge(7, "D", "E"));
        edges.add(new PrimEdge(5, "C", "E"));
        edges.add(new PrimEdge(7, "B", "E"));
        edges.add(new PrimEdge(6, "D", "F"));
        edges.add(new PrimEdge(8, "E", "F"));
        edges.add(new PrimEdge(9, "E", "G"));
        edges.add(new PrimEdge(11, "F", "G"));

        Prim prim = new Prim();

        System.out.println(prim.prim("A", edges));
    }
}
