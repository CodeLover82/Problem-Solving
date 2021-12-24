package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1912 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int[] arr = new int[100005];
    static int[] dp = new int[100005];
    static int n;

    public static void main(String[] args) throws IOException {
        init();

        int result = -1000000000;
        for (int i = 0; i < n; i++) result = Math.max(result, func(i));
        sb.append(result);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1000000000;
        }
    }

    static int func(int x) {
        if(x == 0)return arr[x];

        int ret = dp[x];
        if(ret != -1000000000)return ret;

        ret = func(x - 1) < 0 ? arr[x] : func(x - 1) + arr[x];

        return dp[x] = ret;
    }

}
