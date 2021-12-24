package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

    static class Edge {

        int left, right;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int[] dp = new int[105];
    static Edge[] arr = new Edge[105];
    static int n;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(arr, 0, n, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                if(o1.left < o2.left)return -1;
                else if (o1.left > o2.left) return 1;
                else {
                    if(o1.right <= o2.right)return -1;
                    else return 1;
                }
            }
        });

        int ret = -1;
        for (int i = 0; i < n; i++) ret = Math.max(ret, func(i));

        sb.append(n - ret);

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = new Edge();
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i].left = a;
            arr[i].right = b;
        }

        Arrays.fill(dp, -1);
    }

    static int func(int i) {
        int ret = dp[i];
        if(ret != -1)return ret;

        ret = 1;
        for (int k = 0; k < i; k++) {
            if (arr[k].left < arr[i].left && arr[k].right < arr[i].right) {
                ret = Math.max(ret, func(k) + 1);
            }
        }

        return dp[i] = ret;
    }

}

