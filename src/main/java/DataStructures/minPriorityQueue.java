package DataStructures;

import java.util.Collections;
import java.util.List;

import static java.lang.Math.floor;

public class minPriorityQueue {

    //Note this data structure was based on the code found here and is not my own creation:
    //https://www.gyanblog.com/coding-interview/min-priority-queue-with-heap/#:~:text=Min%20Priority%20Queue%20is%20a,Gives%20the%20minimum%20priority%20element.

    private int[] heap;
    private int maxSize;
    private int heapSize;

    public minPriorityQueue(int maxSize){
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
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

        if (l <= heapSize && heap[l] < heap[i]){
            smallest = l;
        }

        if (r <= heapSize && heap[r] < heap[smallest]){
            smallest = r;
        }
        if (smallest != i){
            int temp = heap[i];
            heap[i] = smallest;
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public int getMin() throws Exception{
        if(this.heapSize == 0){
            throw new Exception("Heap underflow");
        }
        return this.heap[0];
    }

    public int extractMin() throws Exception{
        if(this.heapSize == 0){
            throw new Exception("Heap underflow");
        }

        int min = this.heap[0];
        heap[0] = heap[--heapSize];
        minHeapify(0);
        return min;
    }

    public void decrement(int index, int newValue) throws Exception{
        if(index > heapSize-1){
            throw new Exception("Overflow");
        }

        this.heap[index] = newValue;
        while(index > 0 && this.heap[index] < heap[this.getParent(index)]){
            int temp = heap[index];
            heap[index] = getParent(index);
            heap[getParent(index)] = temp;
            index = getParent(index);
        }
    }

    public void insert(int val) throws Exception{
        if(this.heapSize >= maxSize){
            throw new Exception("Overflow");
        }
        heapSize++;
        heap[heapSize-1] = Integer.MAX_VALUE;
        decrement(heapSize-1, val);
    }
}
