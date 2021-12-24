package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11047 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n, k, cnt;
    static int[] arr = new int[15];

    public static void main(String[] args) throws IOException {
        init();

        func();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        cnt = 0;
    }

    static void func() {
        for (int i = n - 1; i >= 0; i--) {
            cnt += k / arr[i];
            k %= arr[i];
        }
        sb.append(cnt);
    }

}
