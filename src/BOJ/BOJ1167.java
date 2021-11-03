package BOJ;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1167 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static ArrayList<Edge>[] adj;
    static int[] distance;
    static int n;

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

        distance = new int[n + 1];
        Arrays.fill(distance, 0);

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            while (true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                int d = Integer.parseInt(st.nextToken());

                adj[s].add(new Edge(e, d));
            }
        }
    }

    static void solve() throws IOException {
        dfs(0, 1, 0);

        int node = -1, len = -1;
        for (int i = 1; i <= n; i++){
            if (len < distance[i]) {
                len = distance[i];
                node = i;
            }
        }

        Arrays.fill(distance, 0);

        dfs(0, node, 0);

        int result = 0;
        for (int i = 1; i <= n; i++) result = Math.max(result, distance[i]);

        sb.append(result);
    }

    static void dfs(int parent, int now, int dist) {
        distance[now] = dist;

        for (Edge edge : adj[now]) {
            if(edge.node == parent) continue;

            dfs(now, edge.node, dist + edge.dist);
        }
    }

    static class Edge {
        int node, dist;

        public Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

}
