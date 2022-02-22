package Algorithms;

import java.util.Random;

//region Utility Classes

// Utility Class for returning the m and s matrices later
class TwoArrays{
    public final int[][] A;
    public final int[][] B;

    public TwoArrays(int[][] A, int [][] B){
        this.A = A;
        this.B = B;
    }
}

// Utility class for generating matrices to test with
class matrixUtilities {
    public static int[][][] generateMatrices(int[] p){

        int upperBound = 25;
        Random randomGen = new Random(10);
        int numMatrices = p.length-1;
        int[][][] matrices = new int[numMatrices][][];

        for (int i = 0; i < numMatrices; i++) {
            int [][] randomMatrix = new int[p[i]][p[i+1]];
            for (int j = 0; j < randomMatrix.length; j++) {
                for (int k = 0; k < randomMatrix[0].length; k++) {
                    randomMatrix[j][k] = randomGen.nextInt(upperBound);
                }
            }
            matrices[i] = randomMatrix;
        }
        return matrices;
    }

    public static void printMatrix(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
//endregion

class matrixChainMultiplicationClass {

    /**
     * @param p list of dimensions for the matrices to be multiplied.
     *          For example, for the set of matrices of size 5x4, 4x6, 6x2, 2x7,
     *          p would be an integer array of length 4 and contain the following values: [5,4,6,2,7]
     * @return Returns two matrices inside a struct object:
     * 1) matrix m: stores the minimum number of scalar multiplications needed to compute the matrix A_(i...j).
     * 2) matrix s: s[i, j] records a value k such that an optimal parenthisization of A_i*A_(i+1)*...*A_j splits the
     *    product between A_k and A_(k+1)
     */
    public TwoArrays generateOptimalParenthesization(int[] p){
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

    public int[][] matrixMultiplyRecursive(int [][][] A, int [][] s, int i, int j){
        if (i==j)
            return A[i];

        if(i+1 == j)
            return multiplyTwoMatrices(A[i], A[j]);

        return multiplyTwoMatrices(matrixMultiplyRecursive(A, s, i, s[i][j]), matrixMultiplyRecursive(A, s, s[i][j]+1, j));
    }

    public int [][] multiplyTwoMatrices(int [][] A, int [][] B){
        if(A[0].length != B.length)
            System.out.println("Incompatible dimensions");

        int [][] C = new int [A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] = C[i][j] + A[i][k]*B[k][j];
                }
            }
        }
        return C;
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

        // [5, 4], [4, 6], [6, 2], [2, 7]
        // 1. Generate list of dimensions and store in p
        int[] dims = {5,4,6,2,7, 9, 23, 435, 112};

        // 2. Generate some test matrices from p
        int [][][] randomMatrices = matrixUtilities.generateMatrices(dims);

        // 3. Find optimum way to multiply matrices and store solution in results
        matrixChainMultiplicationClass algo = new matrixChainMultiplicationClass();
        TwoArrays results = algo.generateOptimalParenthesization(dims);

        // 4. Multiply the matrices and print the final solution
        int[][] multipliedMatrices = algo.matrixMultiplyRecursive(randomMatrices, results.B, 0, dims.length-2);

        // 5. Print results
        algo.printOptimalParens(results.B, 0, dims.length-2);
        System.out.println();
        System.out.println("Total multiplications: " + results.A[0][dims.length-2]);
        System.out.println("Final Matrix:");
        matrixUtilities.printMatrix(multipliedMatrices);
    }
}
