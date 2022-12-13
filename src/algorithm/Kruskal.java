package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public ArrayList<KruskalEdge> kruskal(ArrayList<String> veties, ArrayList<KruskalEdge> edges) {
        ArrayList<KruskalEdge> mst = new ArrayList<>();
        KruskalEdge currentEdge;

        // 1. 초기화
        for(int index = 0; index < veties.size(); index++) {
            makeSet(veties.get(index));
        }

        // 2. 간선 weight 기반 sort
        Collections.sort(edges);

        for(int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (this.find(currentEdge.nodeV) != this.find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public String find(String node) {
        // path compression
        if (this.parent.get(node) != node) {
            this.parent.put(node, this.find(parent.get(node)));
        }
        return this.parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = this.find(nodeV);
        String root2 = this.find(nodeU);

        // union-by-rank
        if (this.rank.get(root1) > this.rank.get(root2)) {
            this.parent.put(root2, root1);
        } else {
            this.parent.put(root1, root2);
            if (this.rank.get(root1) == this.rank.get(root2)) {
                this.rank.put(root2, this.rank.get(root2) + 1);
            }

        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }

    public static void main(String[] args) {
        ArrayList<String> vetices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<KruskalEdge> edges = new ArrayList<>();
        edges.add(new KruskalEdge(7, "A", "B"));
        edges.add(new KruskalEdge(5, "A", "D"));
        edges.add(new KruskalEdge(7, "B", "A"));
        edges.add(new KruskalEdge(8, "B", "C"));
        edges.add(new KruskalEdge(9, "B", "D"));
        edges.add(new KruskalEdge(7, "B", "E"));
        edges.add(new KruskalEdge(8, "C", "B"));
        edges.add(new KruskalEdge(5, "C", "E"));
        edges.add(new KruskalEdge(5, "D", "A"));
        edges.add(new KruskalEdge(9, "D", "B"));
        edges.add(new KruskalEdge(7, "D", "E"));
        edges.add(new KruskalEdge(6, "D", "F"));
        edges.add(new KruskalEdge(7, "E", "B"));
        edges.add(new KruskalEdge(5, "E", "C"));
        edges.add(new KruskalEdge(7, "E", "D"));
        edges.add(new KruskalEdge(8, "E", "F"));
        edges.add(new KruskalEdge(9, "E", "G"));
        edges.add(new KruskalEdge(6, "F", "D"));
        edges.add(new KruskalEdge(8, "F", "E"));
        edges.add(new KruskalEdge(11, "F", "G"));
        edges.add(new KruskalEdge(9, "G", "E"));
        edges.add(new KruskalEdge(11, "G", "F"));

        Kruskal kruskal = new Kruskal();
        System.out.println(kruskal.kruskal(vetices, edges));

    }
}
