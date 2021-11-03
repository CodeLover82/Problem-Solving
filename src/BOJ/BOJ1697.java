package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1697 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int[] visit = new int[200005];
    static int n, k;

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
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visit, 500000);
    }

    static void solve() throws IOException {
        bfs();
        sb.append(visit[k]);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        visit[n] = 0;

        while (!q.isEmpty()) {
            int now = q.peek();
            q.poll();

            int next = now + 1;
            if (next >= 0 && next <= 200000 && visit[next] > visit[now] + 1) {
                q.offer(next);
                visit[next] = visit[now] + 1;
            }

            next = now - 1;
            if (next >= 0 && next <= 200000 && visit[next] > visit[now] + 1) {
                q.offer(next);
                visit[next] = visit[now] + 1;
            }

            next = now * 2;
            if (next >= 0 && next <= 200000 && visit[next] > visit[now] + 1) {
                q.offer(next);
                visit[next] = visit[now] + 1;
            }
        }
    }

}
