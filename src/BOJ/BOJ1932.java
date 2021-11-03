package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1932 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int[][] arr = new int[505][505];
    static int[][] dp = new int[505][505];
    static int n;

    public static void main(String[] args) throws IOException {
        init();

        sb.append(func(0, 0));
        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    static int func(int x, int y) {
        if (x == n - 1) {
            return arr[x][y];
        }

        int ret = dp[x][y];
        if(ret != -1)return ret;

        ret = arr[x][y] + Math.max(func(x + 1, y), func(x + 1, y + 1));

        return dp[x][y] = ret;
    }

}
