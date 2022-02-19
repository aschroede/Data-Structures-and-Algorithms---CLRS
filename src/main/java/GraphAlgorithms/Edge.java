package GraphAlgorithms;

public class Edge {
    Vertex destination;
    Vertex source;
    int weight;

    public Edge(Vertex source, Vertex destination, int weight){
        this.destination = destination;
        this.source = source;
        this.weight = weight;
    }
}
