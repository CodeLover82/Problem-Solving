package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11866 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static Deque<Integer> dq = new LinkedList<>();
    static int n, k;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    static void solve() throws IOException {
        for (int i = 1; i <= n; i++) dq.offerLast(i);

        sb.append("<");

        int cnt = 0;
        while (!dq.isEmpty()) {
            cnt++;
            if (cnt == k) {
                sb.append(dq.pollFirst() + ", ");
                cnt = 0;
                continue;
            }
            dq.offerLast(dq.pollFirst());
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
    }

}





