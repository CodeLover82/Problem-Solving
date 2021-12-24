package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int total;
    static int[] arr = new int[1005];

    public static void main(String[] args) throws IOException {
        init();

        func();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        total = 0;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void func() {
        arr = Arrays.stream(arr, 0, n).boxed().sorted().mapToInt(i -> i).toArray();

        int total = 0;
        for (int i = 0; i < n; i++) total += arr[i];

        int waiting = arr[0];
        for (int i = 1; i < n; i++) {
            total += waiting;
            waiting += arr[i];
        }

        sb.append(total);
    }

}

