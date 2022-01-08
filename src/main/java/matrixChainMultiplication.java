import java.util.Scanner;


class TwoArrays{
    public final int[][] A;
    public final int[][] B;

    public TwoArrays(int[][] A, int [][] B){
        this.A = A;
        this.B = B;
    }
}

class matrixChainMultiplicationAlgo {

    public TwoArrays matrixChainOrder(int[] p){
        int n = p.length-1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        // Initialize m array on diagonal
        for (int i = 0; i < n; i++) {
            m[i][i]=0;
        }
        int j = 0;
        int q = 0;
        for (int l = 2; l <= n; l++) {   // l is the chain length
            for (int i = 0; i < n-l+1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j ; k++) {
                    q = m[i][k] + m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(q < m[i][j]){
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }
            }
        }
        return new TwoArrays(m, s);
    }

    public void printOptimalParens(int[][] s, int i, int j){
        if(i==j)
            System.out.print("A"+i);
        else {
            System.out.print("(");
            printOptimalParens(s,i, s[i][j]);
            printOptimalParens(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }
}

public class matrixChainMultiplication{

    public static void main(String[] args)
    {
        int[] p = {30,35,15,5,10,20,25};
        matrixChainMultiplicationAlgo algo = new matrixChainMultiplicationAlgo();
        TwoArrays results = algo.matrixChainOrder(p);
        algo.printOptimalParens(results.B, 0, 5);
        System.out.println();
        System.out.println("Total multiplications: " + results.A[0][5]);
    }
}
