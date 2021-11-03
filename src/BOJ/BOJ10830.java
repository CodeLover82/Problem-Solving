package BOJ;

import java.util.*;
import java.io.*;

public class BOJ10830 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int[][] A = new int[10][10];
    static int n;
    static long k;

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
        k = Long.parseLong(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() throws IOException {
        int[][] B = func(k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(B[i][j] + " ");
            }
            sb.append("\n");
        }
    }

    static int[][] func(long k) {
        int[][] B = new int[10][10];

        if (k == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][j] = A[i][j] % 1000;
                }
            }
            return B;
        }




        if (k % 2 == 0) {
            int[][] tmp = func(k / 2);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int r = 0; r < n; r++) {
                        sum += tmp[i][r] * tmp[r][j];
                    }
                    B[i][j] = sum % 1000;
                }
            }

            return B;
        } else {
            int[][] tmp = func(k - 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int r = 0; r < n; r++) {
                        sum += tmp[i][r] * A[r][j];
                    }
                    B[i][j] = sum % 1000;
                }
            }
            return B;
        }
    }

}
