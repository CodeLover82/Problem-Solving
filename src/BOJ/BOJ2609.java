package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2609{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int a, b;

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
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    static void solve() {
        int x = GCD(a, b);
        sb.append(x + "\n");

        sb.append(a * b / x);
    }

    static int GCD(int a, int b) {
        if(b == 0)return a;

        return GCD(b, a % b);
    }

}
