package algorithm;

public class PrimEdge implements Comparable<PrimEdge> {
    public int weight;
    public String node1;
    public String node2;

    public PrimEdge(int weight, String node1, String node2) {
        this.weight = weight;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node1 + ", " + this.node2 + ")";
    }

    @Override
    public int compareTo(PrimEdge edge) {
        return this.weight - edge.weight;
    }
}
