package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1629 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int A, B, C;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        sb.append(solve(A, B, C));

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static int solve(int a, int b, int c) throws IOException {
        if (b == 1) {
            return a % c;
        }

        if (map.get(b) != null) {
            return map.get(b);
        }

        if (b % 2 == 0) {
            int x = (int)(((long)solve(a, b / 2, c) * solve(a, b / 2, c)) % c);
            map.put(b, x);
            return x;
        } else {
            int x = (int)(((long)solve(a, b - 1, c) * a) % c);
            map.put(b, x);
            return x;
        }
    }

}

