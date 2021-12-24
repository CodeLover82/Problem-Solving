package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1956 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int V, E;
    static long[][] dist, dp;
    static long INF = 4000000000L;

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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new long[V + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if(i == j)dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }


        dp = new long[V + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            for (int j = 0; j <= V; j++) {
                if(i == j)dp[i][j] = 0;
                else dp[i][j] = INF;
            }
        }
    }

    static void solve() throws IOException {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if(dp[i][k] + dist[k][j] < dp[i][j]) dp[i][j] = dp[i][k] + dist[k][j];
                }
            }
        }

        long ret = INF;

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if(i == j)continue;

                ret = Math.min(ret, dp[i][j] + dp[j][i]);
            }
        }

        if(ret == INF) sb.append("-1");
        else sb.append(ret);
    }

}
