package Algorithms;

import java.util.Scanner;

class rodcutting {

    public static int recursiveRodCut(int [] p, int n){
        if (n==0)
            return 0;
        Integer q = Integer.MIN_VALUE;
        for (int i=1; i<=n; i++){
            q = Math.max(q, p[i]+recursiveRodCut(p, n-i));
        }
        return q;
    }

    public static int memoizedRodCut(int [] p, int n){
        int [] memo = new int[n+1];     // Create new int array to store solutions of sub-problems
        for (int i = 0; i <= n; i++) {      // Initialize array to minimum values
            memo[i] = Integer.MIN_VALUE;
        }
        return memoizedRodCutAux(p,n,memo);     // Solve problem and return result
    }

    private static int memoizedRodCutAux(int[] p, int n, int[] memo) {
        int q;
        if (memo[n]>=0)     // If we have a solution for n already then
            return memo[n];     // Retrieve it and return, instead of calling the function again.
        if (n==0)   // Base case
            q=0;
        else{
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {      // Find the best way to cut a rod of length n
                q = Math.max(q, p[i]+memoizedRodCutAux(p, n-i, memo)); // Best way is maximum of q and price of left cut (p[i]) plus price of remainder.
            }
        }
        memo[n] = q;    // Store solution to n
        return q;   // Return solution
    }

    public static int[][] bottomUpRodCut(int [] p, int n){
        int [] r = new int[n+1];    // Create new array to store revenues of sub-problems
        int [] s = new int[n+1];    // Create new array to store solutions of sub-problems
        int [][] returnVals = {r, s};
        r[0] = 0;   // Set the base solution for n=0
        for (int j=1; j<=n; j++){   // Foreach of the n sub-problems
            Integer q = Integer.MIN_VALUE;  // Initialize local variable q to help solve the jth sub-problem
            for(int i=1; i<=j; i++){    // Find the best way to cut a rod of length j
               if(q<p[i]+r[j-i]){
                   q = p[i]+r[j-i];     // Best way is maximum of q and price of left cut (p[i]) plus price of remainder (r[j-i]).
                   s[j] = i;
               }
            }
            r[j] = q;   // Store solution of the jth sub-problem
        }
        return returnVals;    // Return the last revenue and solution arrays
    }

    public static void printRodCutSolution(int[] p, int n){
        int [][] results = bottomUpRodCut(p, n);

        System.out.println("For a rod of length " + n + ":");
        System.out.println("Max Revenue is: " + results[0][n]);
        System.out.print("Locations to cut (from left side in inches): " );
        while (n>0){
            if(n - results[1][n] ==0)
                break;
            System.out.print(results[1][n] + ", ");
            n = n - results[1][n];
        }
        System.out.println("");
    }
}

public class rodCuttingProgram{
    public static void main(String[] args) {

        int [] rodPrices = {0, 1, 5, 8, 9, 10, 15, 17, 20, 24, 30,
                34, 36, 23, 40, 44, 46, 48, 50, 51, 56, 68, 69, 71,
                75, 76, 78, 80, 86, 73, 88, 91, 92, 93, 96, 100};

        Scanner sc = new Scanner(System.in);
        System.out.println("***** Rod Cutting Implementation *****");

        while (true) {
            System.out.println("Enter rod length (maximum 34) or press 0 to exit.");
            int length = sc.nextInt();
            if(length==0)
                break;
            else
                rodcutting.printRodCutSolution(rodPrices, length);
        }
        sc.close();
    }
}
