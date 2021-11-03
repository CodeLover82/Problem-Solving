package BOJ;

import java.io.*;
import java.util.*;

public class BOJ13305 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static long result;
    static int[] distance = new int[100005];
    static int[] price = new int[100005];

    public static void main(String[] args) throws IOException {
        init();

        func();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        result = 0L;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) distance[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) price[i] = Integer.parseInt(st.nextToken());
    }

    static void func() {
        int min_price = price[0];
        result += (long)min_price * distance[0];

        for (int i = 1; i < n - 1; i++) {
            min_price = Math.min(min_price, price[i]);
            result += (long)min_price * distance[i];
        }

        sb.append(result);
    }

}

