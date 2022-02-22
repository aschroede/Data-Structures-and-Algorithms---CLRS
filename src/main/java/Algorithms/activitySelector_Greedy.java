package Algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class activitySelector_Greedy {

    public static int[] recursiveActivitySelector(int[] s, int[] f, int k, int n, int[] results, int resultIndex){
        int m = k+1;
        while (m<n && s[m]<f[k])
            m += 1;

        if(m<n){
            results[resultIndex++] = m;
            return recursiveActivitySelector(s, f, m, n, results, resultIndex);
        }
        else return results;
    }

    public static int[] greedyAcitivitySelector(int [] s, int[] f){
        int n = s.length;
        int[] A = new int[s.length];
        int k=0;
        int i=0;
        for (int m = 1; m < n; m++) {
            if (s[m] >= f[k]){
                A[i++] = m;
                k=m;
            }
        }
        return A;
    }

}
