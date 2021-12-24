package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10217 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static long INF = 3000000000L;

    static int n, m, k;
    static ArrayList<Info>[] adj;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        baseInit();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            init();

            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void baseInit() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Info(b, c, d));
        }

        dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) for (int j = 0; j <= m; j++) dp[i][j] = INF;
    }

    static void solve() throws IOException {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.dist <= o2.dist) return -1;
                return 1;
            }
        });

        dp[1][0] = 0;
        pq.offer(new Info(1, 0, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().node;
            int nowCost = pq.peek().cost;
            pq.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i).node;
                int addCost = adj[now].get(i).cost;
                long dist = adj[now].get(i).dist;

                if (nowCost + addCost <= m && dp[now][nowCost] + dist < dp[next][nowCost + addCost]) {
                    dp[next][nowCost + addCost] = dp[now][nowCost] + dist;
                    pq.offer(new Info(next, nowCost + addCost, dp[now][nowCost] + dist));
                }
            }
        }

        long ret = INF;
        for (int i = 0; i <= m; i++) ret = Math.min(ret, dp[n][i]);

        if(ret == INF) sb.append("Poor KCM\n");
        else sb.append(ret + "\n");
    }

    static class Info {

        int node, cost;
        long dist;

        public Info(int node, int cost, long dist) {
            this.node = node;
            this.cost = cost;
            this.dist = dist;
        }

    }

}

