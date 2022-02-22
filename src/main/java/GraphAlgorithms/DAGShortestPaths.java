package GraphAlgorithms;

import java.util.LinkedList;

public class DAGShortestPaths {

    public static void DAGShortestPaths(WeightedGraph graph, int source){
        System.out.println("\n ======= DAG Shortest Paths ======= ");
        LinkedList<Vertex> topologicalSort = DFS.DepthFirstSearchRecursive(graph, true);
        graph.InitializeSingleSource(source);
        for (Vertex v : topologicalSort){
            for(Edge e : graph.AdjacencyList.get(v.identity)){
                graph.relax(e);
            }
        }

        printResults(topologicalSort, source);
    }

    static void printResults(LinkedList<Vertex> topologicalSort, int source){
        System.out.println("\n Source -> Destination: Minimum Distance");

        for(Vertex v : topologicalSort){
            System.out.println(source + " -> " + v.identity + ": " + v.distance);
        }
    }

}
