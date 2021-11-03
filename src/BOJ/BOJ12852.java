package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12852 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;
    static int n;
    static int[] dp, prev;
    static final int INF = 1000000000;

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

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 1; i <= n; i++) dp[i] = -1;

        prev = new int[n + 1];
        prev[1] = -1;
    }

    static void solve() throws IOException {
        dfs(n);
        sb.append(dp[n] + "\n");
        int x = n;
        while (x != -1) {
            sb.append(x + " ");
            x = prev[x];
        }
    }

    static int dfs(int x) {
        if(x == 1) return dp[x] = 0;

        int ret = dp[x];
        if(ret != -1)return ret;

        ret = INF;

        if (x % 3 == 0) {
            int k = dfs(x / 3) + 1;

            if (k < ret) {
                ret = k;
                prev[x] = x / 3;
            }
        }

        if (x % 2 == 0) {
            int k = dfs(x / 2) + 1;

            if (k < ret) {
                ret = k;
                prev[x] = x / 2;
            }
        }

        int k = dfs(x - 1) + 1;

        if (k < ret) {
            ret = k;
            prev[x] = x - 1;
        }

        return dp[x] = ret;
    }

}

