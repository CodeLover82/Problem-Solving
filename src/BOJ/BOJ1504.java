package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1504 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n;
    static int m1, m2;
    static ArrayList<Info>[] adj;
    static int[] dp, dp2, dp3;
    static int INF = 700000000;

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

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Info(b, c));
            adj[b].add(new Info(a, c));
        }

        dp = new int[n + 1];
        Arrays.fill(dp, INF);

        dp2 = new int[n + 1];
        Arrays.fill(dp2, INF);

        dp3 = new int[n + 1];
        Arrays.fill(dp3, INF);

        st = new StringTokenizer(br.readLine());
        m1 = Integer.parseInt(st.nextToken());
        m2 = Integer.parseInt(st.nextToken());
    }

    static void solve() throws IOException {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.dist <= o2.dist)return -1;
                else return 1;
            }
        });

        // 1부터
        dp[1] = 0;
        pq.offer(new Info(1, 0));

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

        // m1부터

        dp2[m1] = 0;
        pq.offer(new Info(m1, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i).node;
                int dist = adj[now].get(i).dist;

                if (dp2[now] + dist < dp2[next]) {
                    dp2[next] = dp2[now] + dist;
                    pq.offer(new Info(next, dp2[now] + dist));
                }
            }
        }

        // m2부터

        dp3[m2] = 0;
        pq.offer(new Info(m2, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i).node;
                int dist = adj[now].get(i).dist;

                if (dp3[now] + dist < dp3[next]) {
                    dp3[next] = dp3[now] + dist;
                    pq.offer(new Info(next, dp3[now] + dist));
                }
            }
        }

        int result = Math.min(dp[m1] + dp2[m2] + dp3[n], dp[m2] + dp3[m1] + dp2[n]);
        if(result >= INF) sb.append("-1");
        else sb.append(result);
    }



    static class Info {
        int node, dist;

        public Info(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}
