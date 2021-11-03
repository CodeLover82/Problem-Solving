package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2579 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int[] arr = new int[10005];
    static int[][] dp = new int[10005][3];

    public static void main(String[] args) throws IOException {
        init();

        sb.append(Math.max(func(n - 1, 1), func(n - 1, 2)));

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            Arrays.fill(dp[i], -1);
        }
    }

    static int func(int x, int y) {
        if(x < 0)return 0;
        if(y == 0)return 0;

        int ret = dp[x][y];
        if(ret != -1)return ret;

        ret = arr[x] + Math.max(func(x - 1, y - 1), Math.max(func(x - 2, 1), func(x - 2, 2)));
        return dp[x][y] = ret;
    }

}
