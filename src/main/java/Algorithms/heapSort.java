package Algorithms;

import static java.lang.Math.floor;
import java.util.Collections;
import java.util.List;


public class heapSort {

    public static int heapsize = 0;

    public static int parent(int i){
        return (int)floor(i/2);
    }

    public static int left(int i){
        return i*2;
    }

    public static int right(int i){
        return i*2+1;
    }

    public static void maxHeapify(List<Integer> A, int i){
        int l = left(i);
        int r = right(i);
        int largest =0;

        if (l <= heapsize && A.get(l-1) > A.get(i-1)){
            largest = l;
        }
        else
            largest = i;
        if (r<= heapsize && A.get(r-1) > A.get(largest-1)){
            largest = r;
        }
        if (largest != i){
            Collections.swap(A, i-1, largest-1);
            maxHeapify(A, largest);
        }
    }

    public static void buildMaxHeap(List<Integer> A){
        heapsize = A.size();
        for (int i=(int)floor((A.size())/2); i>=1; i--){
            maxHeapify(A, i);
        }
    }

    public static void heapSort(List<Integer> A){
        buildMaxHeap(A);
        for(int i= A.size()-1; i>0; i--){
            Collections.swap(A, 0, i);
            heapsize -= 1;
            maxHeapify(A, 1);
        }
    }

}


