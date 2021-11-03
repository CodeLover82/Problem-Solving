package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2156 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int[] arr = new int[10005];
    static int[][] dp = new int[10005][3]; // dp[i][0]: i번째에서 i번재 포도주를 마시지 않았을 때 최댓값.

    public static void main(String[] args) throws IOException {
        init();

        sb.append(Math.max(Math.max(func(n - 1, 0),func(n - 1, 1)), func(n - 1, 2)));

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
        if (x == 0) {
            if(y == 0)return 0;
            if(y == 1)return arr[x];
            if(y == 2)return arr[x];
        }

        int ret = dp[x][y];
        if(ret != -1)return ret;

        if(y == 0) ret = Math.max(func(x - 1, 0), Math.max(func(x - 1, 1), func(x - 1, 2)));
        else if(y == 1) ret = arr[x] + func(x - 1, 0);
        else if(y == 2) ret = arr[x] + func(x - 1, 1);

        return dp[x][y] = ret;
    }

}
