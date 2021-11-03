package BOJ;

import java.io.*;
import java.util.*;

public class BOJ12865 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, k;
    static int[] weight, value;
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

        weight = new int[105];
        value = new int[105];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[105][100005];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -2);
    }

    static void solve() throws IOException {
        int ret = 0;
        for (int i = 0; i <= k; i++) {
            ret = Math.max(ret, getDP(n - 1, i));
        }

        sb.append(ret);
    }

    static int getDP(int i, int j) {
        if (i == 0) {
            if(weight[i] == j)return value[i];
            if(j == 0)return 0;
            else return -1;
        }

        int ret = dp[i][j];
        if(ret != -2)return ret;

        ret = getDP(i - 1, j);
        if (j - weight[i] >= 0 && getDP(i - 1, j - weight[i]) != -1) ret = Math.max(ret, getDP(i - 1, j - weight[i]) + value[i]);

        return dp[i][j] = ret;
    }

}

