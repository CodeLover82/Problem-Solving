package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2470 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n;
    static int[] arr;
    static int sum;
    static int ret1, ret2;

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

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        sum = Integer.MAX_VALUE;
    }

    static void solve() throws IOException {
        arr = Arrays.stream(arr, 0, n)
                .boxed()
                .sorted()
                .mapToInt(i -> i)
                .toArray();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int targetNum = -num;

            int idx = lower_bound(targetNum);

            if (idx != n && idx != i) {
                int tmp_sum = num + arr[idx];
                if (Math.abs(tmp_sum) < Math.abs(sum)) {
                    sum = tmp_sum;
                    ret1 = num;
                    ret2 = arr[idx];
                }
            }
            if (idx != 0 && idx - 1 != i) {
                int tmp_sum = num + arr[idx - 1];
                if (Math.abs(tmp_sum) < Math.abs(sum)) {
                    sum = tmp_sum;
                    ret1 = num;
                    ret2 = arr[idx - 1];
                }
            }
        }

        sb.append(Math.min(ret1, ret2) + " " + Math.max(ret1, ret2));
    }


    static int lower_bound(int x) {
        int s = 0, e = n;

        while (s < e) {
            int mid = (s + e) / 2;
            if (arr[mid] < x) s = mid + 1;
            else e = mid;
        }

        return s;
    }

}
