package GraphAlgorithms;

import java.util.ArrayList;

public class BellmanFord {

    public static boolean BellmanFord(WeightedGraph graph, int source){
        System.out.println("\n ======= Bellman-Ford ======= ");
        graph.initializeSingleSource(source);
        for (int i = 0; i < graph.m_Vertices.size()-1; i++) {
            for (ArrayList<Edge> edgeList : graph.AdjacencyList) {
                for(Edge e : edgeList){
                    graph.relax(e.source, e.destination, e.weight);
                }
            }
        }
        for (ArrayList<Edge> edgeList : graph.AdjacencyList) {
            for(Edge e : edgeList){
                if(e.destination.distance > e.source.distance + e.weight){
                    System.out.println("\n Negative weighted cycle detected. Solution impossible.");
                    return false;
                }
            }
        }
        printResults(graph, source);
        return true;
    }

    static void printResults(WeightedGraph graph, int source){
        System.out.println("\n Source -> Destination: Minimum Distance");

        for(Vertex v : graph.m_Vertices){
            System.out.println(source + " -> " + v.identity + ": " + v.distance);
        }
    }
}
