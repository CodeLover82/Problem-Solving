package BOJ;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int[] arr;
    static int n, k;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(sb.toString());

        bw.flush();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        arr = Arrays.stream(arr, 0, n)
                .boxed()
                .sorted()
                .mapToInt(i -> i)
                .toArray();


        int x = upper_bound();
        sb.append(x - 1);
    }

    static int getCount(int x) {
        int cnt = 1, pos = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[pos] >= x) {
                cnt++;
                pos = i;
            }
        }

        return cnt;
    }

    static int upper_bound() {
        int s = 0, e = 1000000001;

        while (s < e) {
            int mid = (s + e) / 2;

            int cnt = getCount(mid);
            if(cnt > k) s = mid + 1;
            else if(cnt < k) e = mid;
            else s = mid + 1;
        }

        return s;
    }


}




