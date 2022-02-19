package GraphAlgorithms;
import java.util.*;

public class DFS {

    static int time = 0;

    // Method 1 - Recursive
    public static void DepthFirstSearchRecursive(WeightedGraph graph){

        System.out.println("\n======= DFS Recursive ======= ");

        LinkedList<Vertex> topologicalSorting = new LinkedList<>();

        for(Vertex u : graph.m_Vertices){
            u.color = color.white;
            u.parent = null;
        }

        int connectedComponentIndex = 0;

        for(Vertex u : graph.m_Vertices){
            if(u.color == color.white){
                DepthFirstSearchVisit(graph, u, connectedComponentIndex++, topologicalSorting);
            }
        }
    }

    private static void PrintTopologicalSortOrder(LinkedList<Vertex> topologicalSorting) {
        System.out.print("Topological sort order: ");
        for (Vertex v : topologicalSorting){
            System.out.print(v.identity + "->");
        }
    }

    private static void ClassifyAndPrintEdges(UnweightedGraph graph) {
        for(Vertex u : graph.m_Vertices){
            for(Vertex v : graph.AdjacencyList.get(u.identity)){

                System.out.print("Edge " + u.identity + "-" + v.identity + " is a ");

                if(graph.isDirected){
                    if(u.discoveredTime < v.discoveredTime && v.finishedTime < u.finishedTime && v.discoveredTime < v.finishedTime){
                        // Forward or tree edge
                        if(v.parent == u){
                            System.out.println("tree edge");
                        }
                        else
                            System.out.println("forward edge");
                    }
                    if(v.discoveredTime <= u.discoveredTime && u.finishedTime <= v.finishedTime && u.discoveredTime < u.finishedTime){
                        // Back edge
                        System.out.println("back edge");
                    }
                    if(v.discoveredTime < v.finishedTime && u.discoveredTime < u.finishedTime && v.finishedTime < u.discoveredTime){
                        // Cross edge
                        System.out.println("Cross edge");
                    }
                }
                else{
                    if(v.parent == u){
                        System.out.println("tree edge");
                    }
                    else
                        System.out.println("back edge");
                }

            }
        }
    }

    private static void DepthFirstSearchVisit(WeightedGraph graph, Vertex u, int connectedComponent, LinkedList<Vertex> topologicalSort) {

        u.discoveredTime = ++time;
        u.color = color.gray;
        System.out.print(u.identity + "->");
        for (Edge e : graph.AdjacencyList.get(u.identity)) {
            if (e.destination.color == color.white) {
                e.destination.parent = u;
                DepthFirstSearchVisit(graph, e.destination, connectedComponent, topologicalSort);
            }
        }
        u.color = color.black;
        u.finishedTime = ++time;
        u.connectedComponent = connectedComponent;
        topologicalSort.add(u);
    }

    // Method 2 - Stack
    public static void DFSStack(ArrayList<ArrayList<Vertex>> graph){
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).color = color.white;
                graph.get(i).get(j).parent = null;
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < (graph.get(i)).size(); j++) {
                if(graph.get(i).get(j).color == color.white)
                    DFSVisitStack(graph, graph.get(i).get(j));
            }
        }
    }

    private static void DFSVisitStack(ArrayList<ArrayList<Vertex>> graph, Vertex u) {
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.push(u);
        time+=1;
        System.out.println(u.identity + "->");
        u.discoveredTime = time;
        u.color = color.gray;

        while(!stack.isEmpty()){
            Vertex v = stack.peek();
            Vertex w = FirstWhiteNeighbor(graph, v);
            if(w == null){
                stack.pop();
                time+=1;
                v.finishedTime = time;
                v.color = color.black;
            }
            else{
                w.parent = v;
                w.discoveredTime += time;
                w.color = color.gray;
                System.out.println(w.identity + "->");
                stack.push(w);
            }
        }
    }

    private static Vertex FirstWhiteNeighbor(ArrayList<ArrayList<Vertex>> graph, Vertex v){
        for (Vertex x : graph.get(v.identity)) {
            if (x.color == color.white)
                return x;
        }
        return null;
    }
}
