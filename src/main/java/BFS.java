import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

    public static void BreadthFirstSearch(ArrayList<ArrayList<Vertex>> G, int s){

        Queue<Integer> myQueue = new PriorityQueue();
        myQueue.add(s);
        System.out.print(s + "->");
        int[] discovered = new int[G.size()];
        discovered[s]=1;
        while (!myQueue.isEmpty()){
            int u = myQueue.remove();
            for (Vertex vertex: G.get(u)) {
                if(discovered[vertex.identity]==0){
                    myQueue.add(vertex.identity);
                    System.out.print(vertex.identity + "->");
                    discovered[vertex.identity]=1;
                }
            }

        }
    }
}
