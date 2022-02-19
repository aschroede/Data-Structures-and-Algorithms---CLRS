package GraphAlgorithms;

public class SimplePaths {

    public static int SimplePaths(UnweightedGraph graph, Vertex u, Vertex v){

        if(u == v){
            return 1;
        }
        else if (u.numPaths != 0)
            return u.numPaths;

        else{
            for(Vertex w : graph.AdjacencyList.get(u.identity)){
                u.numPaths += SimplePaths(graph, w, v);
            }
            return u.numPaths;
        }

    }

}
