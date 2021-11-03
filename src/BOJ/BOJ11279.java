package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11279 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static PriorityQueue<Integer> pq;
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
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)return 1;
                else return -1;
            }
        });
        n = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        while (n-- > 0) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    int x = pq.peek();
                    pq.poll();
                    sb.append(x + "\n");
                }
            } else {
                pq.offer(cmd);
            }
        }
    }

}
