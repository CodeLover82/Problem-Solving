package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1021 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static Deque<Integer> dq = new LinkedList<>();
    static int n, m;
    static int[] arr = new int[60];
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
        result = 0;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arr[i] = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < n; i++) dq.offerLast(i);
    }

    static void solve() throws IOException {
        int pos = 0;

        while (pos < m) {
            int cnt = 0;
            while (dq.peekFirst() != arr[pos]) {
                dq.offerLast(dq.pollFirst());
                cnt++;
            }

            result += Math.min(cnt, dq.size() - cnt);
            dq.pollFirst();
            pos++;
        }

        sb.append(result);
    }

}
