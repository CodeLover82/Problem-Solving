package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2206 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, m;
    static int[][] map;
    static int[][][] dp, visit;
    static int[] dx, dy;

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
        sb = new StringBuilder();
        st = null;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) map[i][j] = str.charAt(j) - '0';
        }

        dp = new int[m][n][2];
        visit = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], 10000000);
                Arrays.fill(visit[i][j], 0);
            }
        }

        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
    }

    static void solve() throws IOException {
        bfs();

        int ret = Math.min(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]);
        if(ret == 10000000) sb.append(-1);
        else sb.append(ret);
    }

    static void bfs() {
        Queue<Info> q = new LinkedList<>();

        q.offer(new Info(0, 0, 0));
        visit[0][0][0] = 0;
        dp[0][0][0] = 1;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int visited = q.peek().visited;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X < 0 || X >= m || Y < 0 || Y >= n || visit[X][Y][visited] == 1) continue;

                if (map[X][Y] == 0) {
                    q.offer(new Info(X, Y, visited));
                    dp[X][Y][visited] = dp[x][y][visited] + 1;
                    visit[X][Y][visited] = 1;
                }
                else {
                    if (visited == 1) continue;

                    q.offer(new Info(X, Y, 1));
                    dp[X][Y][1] = dp[x][y][visited] + 1;
                    visit[X][Y][1] = 1;
                }
            }


        }
    }

    static class Info {

        int x, y, visited;

        public Info(int x, int y, int visited) {
            this.x = x;
            this.y = y;
            this.visited = visited;
        }

    }
}

