package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BreadthFirstSearch {
    public ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<>(Arrays.asList("D")));
        graph.put("F", new ArrayList<>(Arrays.asList("D")));
        graph.put("G", new ArrayList<>(Arrays.asList("C")));
        graph.put("H", new ArrayList<>(Arrays.asList("C")));
        graph.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<>(Arrays.asList("I")));

        System.out.println(graph);

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        System.out.println(bfs.bfs(graph, "A"));


        /*
        // HashMap 생성
        HashMap<String, Integer> mapData = new HashMap<>();

        // HashMap 추가
        mapData.put("A", 1);
        mapData.put("B", 2);

        // HashMap 수정
        mapData.put("B", 3);

        // HashMap 삭제
        mapData.remove("A");

        // HashMap 읽기
        System.out.println(mapData);
        */
    }
}
