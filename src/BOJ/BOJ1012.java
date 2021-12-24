package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1012 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int m, n;
    static int[][] map;
    static int[][] dp;
    static int[] dx, dy;
    static int result;

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
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(map[i], 0);

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], 0);

        result = 0;

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
    }

    static void solve() throws IOException {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && dp[i][j] == 0) {
                    result++;
                    bfs(i, j);
                }
            }
        }
        sb.append(result + "\n");
    }

    static void bfs(int start_x, int start_y) {
        Deque<Pair> q = new LinkedList<>();

        q.offerLast(new Pair(start_x, start_y));
        dp[start_x][start_y] = 1;

        while (!q.isEmpty()) {
            int x = q.peekFirst().x;
            int y = q.peekFirst().y;
            q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if(X < 0 || X >= m || Y < 0 || Y >= n || map[X][Y] == 0 || dp[X][Y] == 1) continue;

                q.offerLast(new Pair(X, Y));
                dp[X][Y] = 1;
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

