package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1753 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, start;
    static ArrayList<Info>[] adj;
    static int[] dp;
    static int INF = 2000000000;

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
        int k = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[s].add(new Info(e, dist));
        }

        dp = new int[n + 1];
        Arrays.fill(dp, INF);
    }

    static void solve() throws IOException {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.dist <= o2.dist) return -1;
                else return 1;
            }
        });

        dp[start] = 0;
        pq.offer(new Info(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i).node;
                int dist = adj[now].get(i).dist;

                if (dp[now] + dist < dp[next]) {
                    dp[next] = dp[now] + dist;
                    pq.offer(new Info(next, dp[now] + dist));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(dp[i] == INF) sb.append("INF\n");
            else sb.append(dp[i] + "\n");
        }
    }

    static class Info {
        int node;
        int dist;

        public Info(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}




