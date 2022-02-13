package GraphAlgorithms;

import GraphAlgorithms.Vertex;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    public static void BreadthFirstSearch(AdjacencyListGraph graph, Vertex source){
        System.out.println("\n ======= BFS ======= ");

        for (Vertex v : graph.m_Vertices) {
            v.color = color.white;
            v.distance = Integer.MAX_VALUE;
            v.parent = null;
        }

        System.out.print(source.identity + "->");
        source.color = color.gray;
        source.distance = 0;
        source. parent = null;

        PriorityQueue<Vertex> queue = new PriorityQueue();
        queue.add(source);

        while(!queue.isEmpty()){

            Vertex u = queue.remove();

            for(Vertex v : graph.m_AdjacencyList.get(u.identity)){
                 if(v.color == color.white){
                     v.distance = u.distance+1;
                     v.parent = u;
                     v.color = color.gray;
                     queue.add(v);
                     System.out.print(v.identity + "->");
                 }
            }
            u.color = color.black;
        }

        System.out.println();
    }
}
