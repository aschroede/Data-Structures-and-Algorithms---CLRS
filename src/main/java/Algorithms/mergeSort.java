package Algorithms;

public class mergeSort {

    public static int[] mergeSort(int[] A, int p, int r){
        if(p<r){
            int q = (int)Math.floor((p+r)/2);
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
        return A;
    }

    public static void merge(int[] A, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int[] Left = new int[n1+1];
        int[] Right = new int[n2+1];

        for (int i = 0; i < n1; i++) {
            Left[i] = A[p+i];
        }
        for (int j = 0; j < n2; j++) {
            Right[j] = A[q+1+j];
        }
        Left[n1] = Integer.MAX_VALUE;
        Right[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        for (int k = p; k < r+1; k++) {
            if (Left[i] <= Right[j]){
                A[k] = Left[i];
                i += 1;
            }
            else{
                A[k] = Right[j];
                j += 1;
            }
        }
    }
}
