package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11657 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, m;
    static Info[] road;
    static long[] dp;
    static long INF = 20000000L;

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

        road = new Info[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[i] = new Info(a, b, c);
        }

        dp = new long[n + 1];
        Arrays.fill(dp, INF);
    }

    static void solve() throws IOException {
        dp[1] = 0;

        boolean cycle = false;

        for (int cnt = 1; cnt <= n; cnt++) {
            for (int i = 0; i < m; i++) {
                int s = road[i].s;
                int e = road[i].e;
                int dist = road[i].dist;

                if (dp[s] != INF && dp[s] + dist < dp[e]) {
                    dp[e] = dp[s] + dist;

                    if(cnt == n)cycle = true;
                }
            }
        }

        if (cycle) {
            sb.append("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if(dp[i] == INF) sb.append("-1\n");
                else sb.append(dp[i] + "\n");
            }
        }

    }

    static class Info {
        int s, e, dist;

        public Info(int s, int e, int dist) {
            this.s = s;
            this.e = e;
            this.dist = dist;
        }
    }

}
