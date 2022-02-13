package GraphAlgorithms;

public class Vertex implements Comparable<Vertex> {
    public Vertex parent;
    public color color;
    public int discoveredTime;
    public int finishedTime;
    public int identity;
    public int distance;

    public Vertex(int id){identity = id;}

    @Override
    public int compareTo(Vertex o) {
        return 0;
    }
}
