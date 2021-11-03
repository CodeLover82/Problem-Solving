package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2629 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int[][] dp;
    static int[] arr;
    static int[] cmd;
    static int n, m;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(sb.toString());
        bw.flush();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        cmd = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) cmd[i] = Integer.parseInt(st.nextToken());

        dp = new int[n][15005];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
    }

    static void solve() {
        for (int i = 0; i < n; i++) for (int j = 0; j <= 15000; j++) getDP(i, j);
        for (int i = 0; i < m; i++) {
            if(cmd[i] > 15000) sb.append("N ");
            else {
                int result = getDP(n - 1, cmd[i]);
                if(result == 0) sb.append("N ");
                else sb.append("Y ");
            }
        }
    }

    static int getDP(int idx, int weight) {
        if (idx == 0) {
            if(weight == 0 || arr[idx] == weight) return 1;
            else return 0;
        }

        int ret = dp[idx][weight];
        if (ret != -1) return ret;

        ret = 0;

        if (getDP(idx - 1, weight) == 1) ret = 1;
        if(getDP(idx - 1, Math.abs(weight - arr[idx])) == 1) ret = 1;
        if(weight + arr[idx] <= 15000 && getDP(idx - 1, Math.abs(weight + arr[idx])) == 1) ret = 1;

        return dp[idx][weight] = ret;
    }

}




