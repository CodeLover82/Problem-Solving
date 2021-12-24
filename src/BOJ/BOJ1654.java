package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1654 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int k, n;
    static int[] arr = new int[10005];

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
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[i] = x;
        }
    }

    static void solve() throws IOException {

        long s = 0, e = 3000000000L;

        while (s < e) {
            long mid = (s + e) / 2;

            long x = getCount(mid);
            if(x > n)s = mid + 1;
            else if(x < n)e = mid;
            else s = mid + 1;
        }

        sb.append(s - 1);





    }

    static long getCount(long x) {
        long ret = 0;
        for (int i = 0; i < k; i++) ret += arr[i] / x;
        return ret;
    }

}






