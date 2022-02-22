package Algorithms;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class myQuickSort {


    public static void myQuickSort(List<Integer> A, int p, int r){
        int q;
        if (p<r){
            q = partition(A, p, r);
            myQuickSort(A, p, q-1);
            myQuickSort(A, q+1, r);
        }
    }

    private Stack<Integer> inbox = new Stack<Integer>();

    public static int partition(List<Integer> A, int p, int r){
        int x = A.get(r);
        int i = p-1;
        for (int j = p; j<=r-1; j++){
            if (A.get(j) <= x){
                ++i;
                Collections.swap(A, i, j);
            }
        }
        Collections.swap(A, r, i+1);
        return i+1;
    }
}
