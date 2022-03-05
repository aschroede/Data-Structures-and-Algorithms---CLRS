package Algorithms;

public class rabinKarpMatcher {

    public static void rabinKarp(String T, String P, int d, int q){
        int n = T.length();
        int m = P.length();
        int h = (int)(Math.pow(d, m-1) % q);
        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (d*p + P.charAt(i)-'0');
            t = (d*t + T.charAt(i)-'0');
        }

        p = p % 13;
        t= t % 13;

        for (int s = 0; s < n - m; s++) {
            if (p == t) {
                String pattern = P.substring(0, m);
                String text = T.substring(s, s+m);
                if (pattern.equals(text)) {
                    System.out.println("Pattern occurs with shift " + s);
                }
            }
            if (s < n - m) {
                int temp = 0;
                temp = T.charAt(s) - '0';
                temp = temp * (q-h);
                temp = t + temp;
                temp = d * temp;
                temp = temp + (T.charAt(s + m) - '0');
                temp = temp % q;
                t = temp;
            }
        }
    }
}
