package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11401 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static long[] facto = new long[4000005];
    static int n, k;
    static int M = 1000000007;

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

        facto[0] = 1;
        for (int i = 1; i <= n; i++) facto[i] = (facto[i - 1] * i) % M;
    }

    static void solve() throws IOException {
        long a = facto[n];
        long b = (facto[k] * facto[n - k]) % M;
        b = multiple(b, M - 2);

        sb.append((a * b) % M);
    }

    static long multiple(long b, int i) {
        if(i == 1)return b % M;

        if(i % 2 == 0){
            long tmp = multiple(b, i / 2);
            return (tmp * tmp) % M;
        }
        else{ return (multiple(b, i - 1) * b) % M;}
    }

}

