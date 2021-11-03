package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9370 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, t, s, g, h;
    static ArrayList<Info>[] adj;
    static int[] dp1, dp2, dp3;
    static int[] arrival;
    static int INF = 5000000;

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
        int m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Info(b, c));
            adj[b].add(new Info(a, c));
        }

        dp1 = new int[n + 1];
        Arrays.fill(dp1, INF);

        dp2 = new int[n + 1];
        Arrays.fill(dp2, INF);

        dp3 = new int[n + 1];
        Arrays.fill(dp3, INF);

        arrival = new int[t];

        for (int i = 0; i < t; i++) arrival[i] = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.dist <= o2.dist) return -1;
                else return 1;
            }
        });

        dp1[s] = 0;
        pq.offer(new Info(s, 0));

        while (!pq.isEmpty()) {
            int now = pq.peek().node;
            pq.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i).node;
                int dist = adj[now].get(i).dist;

                if (dp1[now] + dist < dp1[next]) {
                    dp1[next] = dp1[now] + dist;

                    pq.offer(new Info(next, dp1[now] + dist));
                }
            }
        }

        dp2[g] = 0;
        pq.offer(new Info(g, 0));

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

        dp3[h] = 0;
        pq.offer(new Info(h, 0));

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

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            if (dp1[arrival[i]] == dp1[g] + dp2[h] + dp3[arrival[i]] || dp1[arrival[i]] == dp1[h] + dp3[g] + dp2[arrival[i]]) {
                list.add(arrival[i]);
            }
        }

        Collections.sort(list);

        list.stream().forEach(num -> sb.append(num + " "));
        sb.append("\n");

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

