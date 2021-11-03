package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9251 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static String s1 = null;
    static String s2 = null;
    static int[][] dp = new int[1005][1005];

    public static void main(String[] args) throws IOException {
        init();

        sb.append(func(s1.length() - 1, s2.length() - 1));

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        s1 = br.readLine();
        s2 = br.readLine();

        for (int i = 0; i <= 1000; i++) Arrays.fill(dp[i], -1);
    }

    static int func(int x, int y) {
        if (x == 0 && y == 0) {
            if(s1.charAt(x) == s2.charAt(y))return 1;
            else return 0;
        }

        if (x < 0 || y < 0) return 0;

        int ret = dp[x][y];
        if(ret != -1)return ret;

        if (s1.charAt(x) == s2.charAt(y)) {
            ret = 1 + func(x - 1, y - 1);
        } else {
            ret = Math.max(func(x - 1, y), func(x, y - 1));
        }

        return dp[x][y] = ret;
    }

}
