package GraphAlgorithms;

import java.util.Comparator;

public class Vertex implements Comparable<Vertex> {
    public Vertex parent;
    public color color;
    public int discoveredTime;
    public int finishedTime;
    public int identity;
    public int distance;
    public int connectedComponent;
    public int numPaths;

    public Vertex(int id){identity = id;}


    @Override
    public int compareTo(Vertex vertex) {
        return vertex.finishedTime - this.finishedTime;
    }
}