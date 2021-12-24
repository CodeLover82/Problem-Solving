package BOJ;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static String cmd;
    static int n;
    static int dir;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            init();
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        dir = 0;
        dq.clear();

        cmd = br.readLine();
        n = Integer.parseInt(br.readLine());

        String tmp_str = br.readLine();
        String str = tmp_str.substring(1, tmp_str.length() - 1);

        st = new StringTokenizer(str, ",");
        for (int i = 0; i < n; i++) dq.offerLast(Integer.parseInt(st.nextToken()));

    }

    static void solve() throws IOException {
        for (int i = 0; i < cmd.length(); i++) {
            if (cmd.charAt(i) == 'R') {
                dir = (dir + 1) % 2;
            } else {
                if (dq.size() == 0) {
                    sb.append("error\n");
                    return;
                }
                if (dir == 0) {
                    dq.pollFirst();
                } else {
                    dq.pollLast();
                }
            }
        }

        sb.append("[");
        while (!dq.isEmpty()) {
            if(dir == 0) sb.append(dq.pollFirst());
            else sb.append(dq.pollLast());

            if(dq.size() > 0)sb.append(",");
        }
        sb.append("]\n");

    }

}
