package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1707 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, k;
    static int[] dir, visited;
    static ArrayList<Integer>[] adj;

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

    static void baseInit() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dir = new int[n + 1];
        visited = new int[n + 1];
        Arrays.fill(visited, 0);

        adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void solve() throws IOException {
        for (int i = 1; i <= n; i++) if (visited[i] == 0) {
            int ret = bfs(i);
            if(ret == 0) {
                sb.append("NO\n");
                return;
            }
        }
        sb.append("YES\n");
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = 1;
        dir[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.peek();
            q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if (visited[next] == 0) {
                    visited[next] = 1;
                    dir[next] = (dir[now] + 1) % 2;
                    q.offer(next);
                }
                else {
                    if(dir[next] == dir[now])return 0;
                }

            }
        }
        return 1;
    }

}
