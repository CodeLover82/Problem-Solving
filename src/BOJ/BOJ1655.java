package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1655 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static PriorityQueue<Integer> left_pq, right_pq;
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

        left_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) return 1;
                else return -1;
            }
        });

        right_pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return 1;
                else return -1;
            }
        });

        n = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            int mid = left_pq.isEmpty() ? 50000 : left_pq.peek();

            if (x <= mid) {
                left_pq.offer(x);
                if (left_pq.size() == right_pq.size() + 2) {
                    right_pq.offer(left_pq.poll());
                }
            } else {
                right_pq.offer(x);
                if (left_pq.size() == right_pq.size() - 1) {
                    left_pq.offer(right_pq.poll());
                }
            }

            sb.append(left_pq.peek() + "\n");

        }
    }

}
