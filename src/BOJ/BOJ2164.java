package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2164 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static Deque<Integer> dq = new LinkedList<>();
    static int n;

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
    }

    static void solve() throws IOException {
        for (int i = 1; i <= n; i++) dq.offerLast(i);

        while (dq.size() > 1) {
            dq.pollFirst();
            dq.offerLast(dq.pollFirst());
        }

        sb.append(dq.peekLast());
    }

}
