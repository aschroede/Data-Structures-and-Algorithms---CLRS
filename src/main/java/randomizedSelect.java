import java.util.Collections;
import java.util.List;
import java.util.Random;

public class randomizedSelect {

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

    public static int randomizedPartition(List<Integer> A, int p, int r){
        Random randomGen = new Random();
        int i = randomGen.nextInt(r-p) + p;
        Collections.swap(A, i, r);
        return partition(A, p, r);
    }

    public static int randomizedSelect(List<Integer> A, int p, int r, int i){
        if (p == r)
            return A.get(p);
        int q = randomizedPartition(A, p, r);
        int k = q - p +1;
        if (i==k)
            return A.get(q);
        else if (i <k)
            return randomizedSelect(A, p, q-1, i);
        else
            return randomizedSelect(A, q+1, r, i-k);
    }


}
