class LCSUtility {

    static class TwoArrays{
        public final int[][] A;
        public final String[][] B;

        public TwoArrays(int[][] A, String [][] B){
            this.A = A;
            this.B = B;
        }
    }

    public TwoArrays LCSLength(String [] X, String [] Y){
        int m = X.length;
        int n = Y.length;

        int[][] c = new int[m+1][n+1];
        String[][] b = new String[m+1][n+1];

        // Initialize c array
        for (int i = 0; i < m+1; i++) {
            c[i][0]=0;
        }
        for (int i = 0; i < n+1; i++) {
            c[0][i] = 0;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (X[i-1] == Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = "@";
                }
                else if (c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j] = "^";
                }
                else {
                    c[i][j]=c[i][j-1];
                    b[i][j] = "<";
                }
            }
        }
        return new TwoArrays(c, b);
    }

    public void printLCS(String[][] b, String[] X, int i, int j){
        if(i==0 || j==0)
            return;
        if (b[i][j]=="@"){
            printLCS(b, X, i-1,j-1);
            System.out.print(X[i-1]);
        }
        else if (b[i][j]=="^")
            printLCS(b, X, i-1, j);
        else printLCS(b, X, i, j-1);
    }
}

public class LCS{
    public static void main(String[] args) {

        String[] X = new String[]{"A", "B", "C", "B", "D", "A", "B"};
        String[] Y = new String[]{"B", "D", "C", "A", "B", "A"};

        LCSUtility LCS = new LCSUtility();
        LCSUtility.TwoArrays returnVals = LCS.LCSLength(X, Y);

        System.out.println("Longest common subsequence: ");
        LCS.printLCS(returnVals.B, X, X.length, Y.length);

    }
}

