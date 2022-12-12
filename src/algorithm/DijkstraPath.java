package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge2>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<>();
        Edge2 edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        ArrayList<Edge2> nodeList;

        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge2> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge2(distances.get(start), start));

        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertax;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertax;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge2(distance, adjacent));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge2>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge2>(Arrays.asList(new Edge2(8, "B"), new Edge2(1, "C"), new Edge2(2, "D"))));
        graph.put("B", new ArrayList<Edge2>());
        graph.put("C", new ArrayList<Edge2>(Arrays.asList(new Edge2(5, "B"), new Edge2(2, "D"))));
        graph.put("D", new ArrayList<Edge2>(Arrays.asList(new Edge2(3, "E"), new Edge2(5, "F"))));
        graph.put("E", new ArrayList<Edge2>(Arrays.asList(new Edge2(1, "F"))));
        graph.put("F", new ArrayList<Edge2>(Arrays.asList(new Edge2(5, "A"))));

        DijkstraPath dijkstraPath = new DijkstraPath();


        System.out.println(dijkstraPath.dijkstraFunc(graph, "A"));

    }
}
