package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1806 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, s;
    static int[] arr, sum;
    static int result;

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
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sum = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = arr[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] + arr[i];

        result = Integer.MAX_VALUE;
    }

    static void solve() throws IOException {

        // 처음부터 시작할 경우
        for (int i = 0; i < n; i++) {
            if (sum[i] >= s) {
                result = i + 1;
            }
        }

        // 두번째 부터
        for (int i = 1; i < n; i++) {
            int targetNum = s + sum[i - 1];

            int idx = lower_bound(targetNum);
            if (idx == n) continue;

            result = Math.min(result, idx - i + 1);
        }

        if(result == Integer.MAX_VALUE) sb.append(0);
        else sb.append(result);
    }

    static int lower_bound(int x) {
        int s = 0, e = n;

        while (s < e) {
            int mid = (s + e) / 2;
            if (sum[mid] < x) s = mid + 1;
            else e = mid;
        }

        return s;
    }
}

