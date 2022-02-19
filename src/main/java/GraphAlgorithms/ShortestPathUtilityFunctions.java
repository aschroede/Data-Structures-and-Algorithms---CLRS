package GraphAlgorithms;

public class ShortestPathUtilityFunctions {

    private static void initializeSingleSource(UnweightedGraph graph, Vertex source){
        for(Vertex v : graph.m_Vertices){
            v.distance = Integer.MAX_VALUE;
            v.parent = null;
        }
        source.distance = 0;
    }

}
