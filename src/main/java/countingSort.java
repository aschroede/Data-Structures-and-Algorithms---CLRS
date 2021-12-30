import java.util.ArrayList;
import java.util.List;

public class countingSort {

    public static List<Integer> countingSort(List<Integer> A, List<Integer> B, int k){
        List<Integer> C = new ArrayList<Integer>(k);

        // Populate the C list
        for(int i = 0; i<=k; i++)
            C.add(i,0);

        // Populate the B list
        for(int i = 0; i<=A.size()-1; i++)
            B.add(i,0);

        // Count the number of each value in the A array
        for(int j = 0; j<=A.size()-1; j++)
            C.set(A.get(j), C.get(A.get(j))+1);

        // Cumulative sum of the values in the C array
        for(int i = 1; i<=k; i++)
            C.set(i, C.get(i)+C.get(i-1));

        // Using C array, position original elements A correctly in the B array
        for(int j=A.size()-1; j>=0; j--){
            B.set(C.get(A.get(j))-1, A.get(j));
            C.set(C.get(A.get(j)), C.get(A.get(j))-1);
        }

        return  B;

    }
}
