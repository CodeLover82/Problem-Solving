package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1966 {

    static class Pair {
        int value, pos;

        public Pair(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int T;
    static int n, k;
    static Deque<Pair> dq = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dq.clear();
        pq.clear();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            dq.offerLast(new Pair(value, i));
            pq.offer(value);
        }
    }

    static void solve() throws IOException {
        int cnt = 0;

        while (true) {
            Pair pair = dq.peekFirst();

            int pos = pair.pos;
            int value = pair.value;

            if (pq.peek() == value) {
                pq.poll();
                dq.pollFirst();
                cnt++;
                if (pos == k) {
                    sb.append(cnt + "\n");
                    break;
                }
            } else {
                dq.offerLast(dq.pollFirst());
            }
        }


    }

}





