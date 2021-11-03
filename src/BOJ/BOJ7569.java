package BOJ;

import java.io.*;
import java.util.*;

public class BOJ7569 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int m, n, h;
    static int[][][] map, dp;
    static int[] dx, dy, dz;
    static int result;
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
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][m][n];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dp = new int[h][m][n];
        for (int i = 0; i < h; i++) for (int j = 0; j < m; j++) Arrays.fill(dp[i][j], INF);

        dx = new int[]{-1, 0, 1, 0, 0, 0};
        dy = new int[]{0, 1, 0, -1, 0, 0};
        dz = new int[]{0, 0, 0, 0, -1, 1};

        result = 0;
    }

    static void solve() throws IOException {
        Queue<Info> q = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[k][i][j] == 1) {
                        dp[k][i][j] = 0;
                        q.offer(new Info(k, i, j));
                    }
                }
            }
        }

        bfs(q);

        boolean clear = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[k][i][j] == 0) {
                        clear = false;
                    }
                }
            }
        }

        if (clear == false) {
            sb.append("-1");
        } else {
            int max = -1;
            for (int k = 0; k < h; k++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[k][i][j] == 1) {
                            max = Math.max(max, dp[k][i][j]);
                        }
                    }
                }
            }
            sb.append(max);
        }

    }

    static void bfs(Queue<Info> q) {
        while (!q.isEmpty()) {
            int z = q.peek().z;
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int i = 0; i < 6; i++) {
                int Z = z + dz[i];
                int X = x + dx[i];
                int Y = y + dy[i];

                if (X < 0 || X >= m || Y < 0 || Y >= n || Z < 0 || Z >= h || dp[z][x][y] + 1 >= dp[Z][X][Y] || map[Z][X][Y] == -1) continue;

                q.offer(new Info(Z, X, Y));
                dp[Z][X][Y] = dp[z][x][y] + 1;
                map[Z][X][Y] = 1;
            }

        }
    }

    static class Info {
        int x, y, z;

        public Info(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}

