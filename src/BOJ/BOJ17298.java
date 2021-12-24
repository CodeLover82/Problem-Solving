package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {

    static class Pair {
        int pos, value;

        public Pair(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int[] arr = new int[1000005];
    static int[] result = new int[1000005];
    static Stack<Pair> stack = new Stack<>();

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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) result[i] = -1;
    }

    static void solve() {
        stack.push(new Pair(0, arr[0]));

        for (int i = 1; i < n; i++) {
            while (!stack.empty() && stack.peek().value < arr[i]) {
                Pair pair = stack.peek();
                stack.pop();

                result[pair.pos] = arr[i];
            }

            stack.push(new Pair(i, arr[i]));
        }
        for (int i = 0; i < n; i++) sb.append(result[i] + " ");

    }

}

