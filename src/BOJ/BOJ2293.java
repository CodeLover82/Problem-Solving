package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2293 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, k;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[105];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());

        dp = new int[105][10005];
        for (int i = 0; i < 105; i++) Arrays.fill(dp[i], 0);
    }

    static void solve() throws IOException {
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10000; j++) {
                dp[i][j] = dp[i - 1][j] + (j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0);

            }
        }

        sb.append(dp[n][k]);



    }

}
