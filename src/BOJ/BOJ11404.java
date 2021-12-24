package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, m;
    static long[][] dist;
    static long[][] dp;
    static long INF = 10000000000L;

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
        m = Integer.parseInt(br.readLine());

        dist = new long[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int i = 0; i <= n; i++) dist[i][i] = 0;

        dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dist[i][j];
            }
        }
    }

    static void solve() throws IOException {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(dp[i][j] == INF) sb.append("0 ");
                else sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }
    }

}
