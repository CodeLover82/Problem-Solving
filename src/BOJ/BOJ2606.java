package BOJ;

import java.io.*;
import java.util.*;

// BFS 버전 ( 아래에 DFS 버전 있다. )
public class BOJ2606 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n;
    static ArrayList<Integer>[] adj;
    static int[] dp;

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
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dp = new int[n + 1];
        Arrays.fill(dp, 0);
    }

    static void solve() throws IOException {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        dp[1] = 1;

        while (!q.isEmpty()) {
            int now = q.peek();
            q.poll();

            for (int i = 0; i < adj[now].size(); i++) {
                int next = adj[now].get(i);

                if(dp[next] == 1) continue;

                q.offer(next);
                dp[next] = 1;
            }
        }

        int cnt = -1;
        for(int i = 0;i<=n;i++)if(dp[i] == 1) cnt++;
        sb.append(cnt);
    }

}

//package BOJ;
//
//import java.io.*;
//import java.util.*;
//
//public class BOJ2606 {
//
//    static BufferedReader br; static BufferedWriter bw;
//    static StringBuilder sb; static StringTokenizer st;
//
//    static int n;
//    static ArrayList<Integer>[] adj;
//    static boolean[] visited;
//
//    public static void main(String[] args) throws IOException {
//        init();
//
//        solve();
//
//        bw.write(sb.toString());
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    static void init() throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        sb = new StringBuilder(); st = null;
//
//        n = Integer.parseInt(br.readLine());
//        int m = Integer.parseInt(br.readLine());
//
//        adj = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
//
//        while (m-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            adj[a].add(b);
//            adj[b].add(a);
//        }
//
//        visited = new boolean[n + 1];
//        Arrays.fill(visited, false);
//    }
//
//    static void solve() throws IOException {
//        visited[1] = true;
//        dfs(1);
//
//        int cnt = -1;
//        for (int i = 0; i <= n; i++) if (visited[i]) cnt++;
//        sb.append(cnt);
//    }
//
//    static void dfs(int now) {
//        for (int i = 0; i < adj[now].size(); i++) {
//            int next = adj[now].get(i);
//
//            if(visited[next]) continue;
//
//            visited[next] = true;
//            dfs(next);
//        }
//    }
//
//}
