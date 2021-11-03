package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int m, n;
    static Integer[] arr = new Integer[100005];

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void solve() throws IOException {
        Arrays.sort(arr, 0, n);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (m-- > 0) {
            int a = Integer.parseInt(st.nextToken());
            int pos = lower_bound(a);

            if(pos == n || arr[pos] != a) sb.append("0\n");
            else sb.append("1\n");

        }
    }

    static int lower_bound(int x) {
        int s = 0, e = n;

        while (s < e) {
            int mid = (s + e) / 2;

            if(arr[mid] < x) s = mid + 1;
            else if(arr[mid] > x) e = mid;
            else e = mid;
        }
        return s;
    }

}


