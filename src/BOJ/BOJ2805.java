package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2805 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, k;
    static int[] arr = new int[1000005];

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
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void solve() throws IOException {
        int s = 0, e = 1000000001;

        while (s < e) {
            int mid = (s + e) / 2;

            long cnt = getCount(mid);
            if(cnt > k)s = mid + 1;
            else if(cnt < k) e = mid;
            else s = mid + 1;
        }
        sb.append(s - 1);
    }

    static long getCount(int x) {
        long ret = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > x) ret += arr[i] - x;
        }
        return ret;
    }

}
