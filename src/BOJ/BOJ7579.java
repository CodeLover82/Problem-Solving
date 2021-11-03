package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7579 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, m;
    static int[] arr, cost;
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
        m = Integer.parseInt(st.nextToken());

        arr = new int[105];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        cost = new int[105];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cost[i] = Integer.parseInt(st.nextToken());

        dp = new int[105][10005];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -2);
    }

    static void solve() throws IOException {
        for (int i = 0; i <= 10000; i++) {
            if (getDP(n - 1, i) >= m) {
                sb.append(i);
                break;
            }
        }
    }

    static int getDP(int i, int j) {
        if (i == 0) {
            if(j == cost[0]) return arr[0];
            if(j == 0) return 0;
            return -1;
        }

        int ret = dp[i][j];
        if(ret != -2)return ret;

        ret = getDP(i - 1, j);
        if(j - cost[i] >= 0 && getDP(i - 1, j - cost[i]) != -1) ret = Math.max(ret, getDP(i - 1, j - cost[i]) + arr[i]);

        return dp[i][j] = ret;
    }

}
