package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1644 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static boolean[] prime;

    static int[] arr;
    static long[] sum;
    static int n;
    static int x;
    static int result;

    public static void main(String[] args) throws IOException {
        init();
        if(sb.length() == 0)solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        x = Integer.parseInt(br.readLine());
        if (x == 1) {
            sb.append(0);
            return;
        }
        prime = new boolean[x + 1];

        prime[0] = prime[1] = false;
        for(int i = 2; i <= x; i++)prime[i] = true;

        for (int i = 2; i <= x; i++) {
            if(prime[i] == false)continue;
            for (int j = i + i; j <= x; j += i) {
                prime[j] = false;
            }
        }

        for(int i = 0;i <= x;i++)if(prime[i] == true) n++;

        arr = new int[n + 1];

        arr[0] = 0;

        int pos = 1;
        for(int i = 0;i <= x;i++)if(prime[i] == true)arr[pos++] = i;

        result = 0;

        sum = new long[n + 1];
        sum[0] = arr[0];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + arr[i];
    }

    static void solve() throws IOException {
        for (int i = 0; i <= n; i++) {
            long total = sum[i];
            long target = sum[i] - x;

            if(target < 0) {
                continue;
            }

            if (target == 0) {
                result++;
                continue;
            }

            int idx = upper_bound(target) - 1;
            if(sum[idx] == target)result++;
        }

        sb.append(result);
    }

    static int upper_bound(long x) {
        int s = 0, e = n;

        while (s < e) {
            int mid = (s + e) / 2;
            if (sum[mid] <= x) s = mid + 1;
            else e = mid;
        }

        return s;
    }

}
