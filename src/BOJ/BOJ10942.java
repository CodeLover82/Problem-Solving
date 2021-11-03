package BOJ;

import java.io.*;
import java.util.*;

public class BOJ10942 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int[][] dp;
    static int[] arr;
    static int[][] cmd;
    static int n, m;

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

        st = new StringTokenizer(br.readLine());

        arr = new int[2005];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        cmd = new int[1000005][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmd[i][0] = Integer.parseInt(st.nextToken());
            cmd[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[2005][2005];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dp[i][j] = -1;
    }

    static void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            int s = cmd[i][0];
            int e = cmd[i][1];

            sb.append(getDP(s - 1, e - 1) + "\n");
        }

    }

    static int getDP(int s, int e) {
        if(s == e)return 1;
        if (s + 1 == e) {
            if(arr[s] == arr[e])return 1;
            else return 0;
        }

        int ret = dp[s][e];
        if(ret != -1)return ret;

        if(arr[s] == arr[e]) ret = getDP(s + 1, e - 1);
        else ret = 0;

        return dp[s][e] = ret;
    }

}

