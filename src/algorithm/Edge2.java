package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Edge2 implements Comparable<Edge2> {
    public int distance;
    public String vertax;

    public Edge2(int distance, String vertax) {
        this.distance = distance;
        this.vertax = vertax;
    }

    public String toString() {
        return "vertax: " + this.vertax + ", distance: " + this.distance;
    }


    @Override
    public int compareTo(Edge2 o) {
        return this.distance - o.distance;
    }

}
