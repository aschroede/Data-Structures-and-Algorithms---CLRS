import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class DFS {
    static int time = 0;

    // Method 1 - Recursive
    public static void DepthFirstSearch(ArrayList<ArrayList<Vertex>> am){
        for (int i = 0; i < am.size(); i++) {
            for (int j = 0; j < am.get(i).size(); j++) {
                am.get(i).get(j).color = color.white;
                am.get(i).get(j).parent = null;
            }
        }

        for (int i = 0; i < am.size(); i++) {
            for (int j = 0; j < (am.get(i)).size(); j++) {
                if(am.get(i).get(j).color == color.white)
                    DepthFirstSearchVisit(am, am.get(i).get(j));
            }
        }
    }

    private static void DepthFirstSearchVisit(ArrayList<ArrayList<Vertex>> am, Vertex u) {
        u.discoveredTime = ++time;
        u.color = color.gray;
        System.out.print(u.identity + "->");
        for (int i = 0; i < (am.get(u.identity)).size(); i++) {
            if (am.get(u.identity).get(i).color == color.white){
                am.get(u.identity).get(i).parent = u;
                DepthFirstSearchVisit(am, am.get(u.identity).get(i));
            }

        }
        u.color = color.black;
        u.finishedTime = ++time;
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
        System.out.print(u.identity + "->");
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
                System.out.print(w.identity + "->");
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
