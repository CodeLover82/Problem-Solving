package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1463 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int[] dp = new int[2000000];

    public static void main(String[] args) throws IOException {
        init();

        sb.append(func(n));

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        Arrays.fill(dp, -1);
    }

    static int func(int x) {
        if(x == 1) return 0;

        int ret = dp[x];
        if(ret != -1)return ret;

        ret = 1 + Math.min(
                x % 3 == 0 ? func(x / 3) : 1000000000,
                Math.min(
                        x % 2 == 0 ? func(x / 2) : 1000000000,
                        func(x - 1)
                )
        );

        return dp[x] = ret;
    }

}
