package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9252 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static String str1, str2;
    static int[][] dp;
    static int[][] dir;
    static int m, n;

    static Stack<Character> stack;

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

        str1 = br.readLine();
        str2 = br.readLine();

        m = str1.length();
        n = str2.length();

        dp = new int[m + 1][n + 1];
        dir = new int[m + 1][n + 1];

        stack = new Stack<>();
    }

    static void solve() throws IOException {
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        dir[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;

        for (int i = 1; i < m; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
                dir[i][0] = 1;
            }
            else {
                dp[i][0] = dp[i - 1][0];
                dir[i][0] = 2;
            }
        }

        for (int j = 1; j < n; j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j] = 1;
                dir[0][j] = 1;
            }
            else {
                dp[0][j] = dp[0][j - 1];
                dir[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dir[i][j] = 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if(dp[i][j] == dp[i - 1][j])dir[i][j] = 2;
                    else dir[i][j] = 0;
                }
            }
        }

        sb.append(dp[m - 1][n - 1] + "\n");

        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (dir[i][j] == 1) {
                stack.push(str1.charAt(i));
                i--;
                j--;
            }
            else if (dir[i][j] == 0) j--;
            else i--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }

    }

}