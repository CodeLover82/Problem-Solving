package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static class Pair {

        int s, e;

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

    }

    static int n;
    static int cnt;
    static Pair[] arr = new Pair[100005];

    public static void main(String[] args) throws IOException {
        init();

        func();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(a, b);
        }
        cnt = 0;
    }

    static void func() {
        Arrays.sort(arr, 0, n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.e < o2.e)return -1;
                else if(o1.e > o2.e)return 1;
                else {
                    if(o1.s > o2.s)return 1;
                    else return -1;
                }
            }
        });

        int end = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].s >= end) {
                cnt++;
                end = arr[i].e;
            }
        }

        sb.append(cnt);
    }

}

