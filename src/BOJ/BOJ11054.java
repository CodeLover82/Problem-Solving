package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11054 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int[] arr;
    static int[] left, right;
    static int n;

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(sb.toString());
        bw.flush();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        st = null;

        n = Integer.parseInt(br.readLine());
        left = new int[n + 1];
        right = new int[n + 1];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left[i] = right[i] = -1;
        }
    }

    static void solve() {
        for (int i = 0; i < n; i++) getLeft(i);
        for (int i = 0; i < n; i++) getRight(i);

        int ret = -1;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, left[i] + right[i] - 1);
        }

        sb.append(ret);
    }

    static int getLeft(int pos) {
        int ret = left[pos];
        if(ret != -1)return ret;

        ret = 1;
        for (int i = 0; i < pos; i++) {
            if(arr[i] < arr[pos]) ret = Math.max(ret, getLeft(i) + 1);
        }

        return left[pos] = ret;
    }

    static int getRight(int pos) {
        int ret = right[pos];
        if(ret != -1)return ret;

        ret = 1;
        for (int i = pos + 1; i < n; i++) {
            if(arr[pos] > arr[i]) ret = Math.max(ret, getRight(i) + 1);
        }

        return right[pos] = ret;
    }

}




