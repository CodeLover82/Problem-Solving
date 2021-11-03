package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9252 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static String s1 = null;
    static String s2 = null;
    static int[][] dp = new int[1005][1005];
    static int[][] track = new int[1005][1005];

    public static void main(String[] args) throws IOException {
        init();

        sb.append(func(s1.length() - 1, s2.length() - 1) + "\n");

        StringBuilder tmp_sb = new StringBuilder();

        int a = s1.length() - 1, b = s2.length() - 1;
        while (a >= 0 && b >= 0) {
            if (s1.charAt(a) == s2.charAt(b)) tmp_sb.append(s1.charAt(a));


            if(track[a][b] == 0)a--;
            else if (track[a][b] == 2)b--;
            else {
                a--;
                b--;
            }
        }

        sb.append(tmp_sb.reverse());
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
            track[x][y] = 1;

            if(s1.charAt(x) == s2.charAt(y))return 1;
            else return 0;
        }

        if (x < 0 || y < 0) return 0;

        int ret = dp[x][y];
        if(ret != -1)return ret;

        if (s1.charAt(x) == s2.charAt(y)) {
            ret = 1 + func(x - 1, y - 1);
            track[x][y] = 1;
        } else {
            int a = func(x - 1, y);
            int b = func(x, y - 1);

            if (a >= b) {
                ret = a;
                track[x][y] = 0;
            } else {
                ret = b;
                track[x][y] = 2;
            }
        }

        return dp[x][y] = ret;
    }

}