import java.util.ArrayList;

public class AdjacencyListGraphGenerator {

    // Add edge
    static void addEdge(ArrayList<ArrayList<Vertex>> am, Vertex s, Vertex d){
        am.get(s.identity).add(d);
        am.get(d.identity).add(s);
    }

    public static void main(String[] args) {

        // Create the graph
        int V = 5;
        ArrayList<ArrayList<Vertex>> am = new ArrayList<ArrayList<Vertex>>(V);

        for (int i = 0; i < V; i++) {
            am.add(new ArrayList<Vertex>());
        }

        // Create vertices
        Vertex zero = new Vertex(0);
        Vertex one = new Vertex(1);
        Vertex two = new Vertex(2);
        Vertex three = new Vertex(3);
        Vertex four = new Vertex(4);

        // Add edges
        addEdge(am, zero, one);
        addEdge(am, zero, two);
        addEdge(am, zero, three);
        addEdge(am, one, two);
        addEdge(am, one, four);

        printGraph(am);

        System.out.print("\nBreadth First Search: ");
        BFS.BreadthFirstSearch(am, 1);

        System.out.print("\nDepth First Search: ");
        DFS.DepthFirstSearch(am);

        System.out.print("\nDepth First Search With Stack: ");
        DFS.DFSStack(am);
    }

    // Print the graph
    static void printGraph(ArrayList<ArrayList<Vertex>> am){
        for (int i = 0; i < am.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < am.get(i).size(); j++) {
                System.out.print(" ->" + am.get(i).get(j).identity);
            }
            System.out.println();
        }
    }
}

class Vertex{
    public Vertex parent;
    public color color;
    public int discoveredTime;
    public int finishedTime;
    public int identity;

    public Vertex(int id){identity = id;}
}

enum color{
    black,
    white,
    gray
}
