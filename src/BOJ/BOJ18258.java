package BOJ;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ18258 {

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
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                dq.offer(value);
            } else if (cmd.equals("pop")) {
                if (dq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(dq.peekFirst() + "\n");
                    dq.pollFirst();
                }
            } else if (cmd.equals("size")) {
                sb.append(dq.size() + "\n");
            } else if (cmd.equals("empty")) {
                sb.append((dq.isEmpty() ? 1 : 0) + "\n");
            } else if (cmd.equals("front")) {
                if (dq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(dq.peekFirst() + "\n");
                }
            } else if (cmd.equals("back")) {
                if (dq.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(dq.peekLast() + "\n");
                }
            }

        }
    }

}
