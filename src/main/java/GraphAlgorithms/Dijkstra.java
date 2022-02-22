package GraphAlgorithms;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;


public class Dijkstra{

        public static void Dijkstra(WeightedGraph graph, int source) {
            System.out.println("\n ======= Dijkstra ======= ");
            List<Vertex> S = new ArrayList<>();
            graph.InitializeSingleSource(source);

            try {
                minPriorityVertexQueue minQueue = new minPriorityVertexQueue(graph.m_Vertices.size());
                for(Vertex v : graph.m_Vertices){
                    minQueue.insert(v);
                }

                while(!minQueue.isEmpty()){
                    Vertex u = minQueue.extractMin();
                    S.add(u);
                    for(Edge e : graph.AdjacencyList.get(u.identity))
                        graph.relax(e);
                }
                printResults(graph, source);
            }
            catch (Exception e){
                // Do nothing for now
            }
        }

        static void printResults(WeightedGraph graph, int source){
            System.out.println("\n Source -> Destination: Minimum Distance");

            for(Vertex v : graph.m_Vertices){
                System.out.println(source + " -> " + v.identity + ": " + v.distance);
            }
        }

}

class minPriorityVertexQueue {

    //Note this data structure was based on the code found here and is not my own creation:
    //https://www.gyanblog.com/coding-interview/min-priority-queue-with-heap/#:~:text=Min%20Priority%20Queue%20is%20a,Gives%20the%20minimum%20priority%20element.

    private Vertex[] heap;
    private int maxSize;
    private int heapSize;

    public minPriorityVertexQueue(int maxSize){
        this.maxSize = maxSize;
        this.heap = new Vertex[maxSize];
        this.heapSize = 0;
    }

    public int getParent(int i){
        return (int)floor(i/2);
    }

    public int getLeftChild(int i){
        return i*2;
    }

    public int getRightChild(int i){
        return i*2+1;
    }

    public void minHeapify(int i){
        int l = getLeftChild(i);
        int r = getRightChild(i);
        int smallest = i;

        if (l <= heapSize && heap[l].distance < heap[i].distance){
            smallest = l;
        }

        if (r <= heapSize && heap[r].distance < heap[l].distance){
            smallest = r;
        }
        if (smallest != i){
            Vertex temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public Vertex getMin() throws Exception{
        if(this.heapSize == 0){
            throw new Exception("Heap underflow");
        }
        return this.heap[0];
    }

    public Vertex extractMin() throws Exception{
        if(this.heapSize == 0){
            throw new Exception("Heap underflow");
        }

        Vertex min = this.heap[0];
        heap[0] = heap[--heapSize];
        minHeapify(0);
        return min;
    }

    public void decrement(int index, Vertex newVertex) throws Exception{
        if(index > heapSize-1){
            throw new Exception("Overflow");
        }

        this.heap[index] = newVertex;
        while(index > 0 && this.heap[index].distance < heap[this.getParent(index)].distance){
            Vertex temp = heap[index];
            heap[index] = heap[getParent(index)];
            heap[getParent(index)] = temp;
            index = getParent(index);
        }
    }

    public void insert(Vertex val) throws Exception{
        if(this.heapSize >= maxSize){
            throw new Exception("Overflow");
        }
        heapSize++;
        heap[heapSize-1] = val;
        decrement(heapSize-1, val);
    }

    public boolean isEmpty(){
        if(heapSize == 0)
            return true;
        return false;
    }
}
