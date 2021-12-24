package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6549 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int[] tree = new int[300005];
    static int[] arr = new int[100005];
    static int n;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n == 0)break;

            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            init(1, 0, n - 1);

            sb.append(solve(0, n - 1) + "\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int init(int idx, int start, int end) {
        if (start == end) {
            return tree[idx] = start;
        }

        int mid = (start + end) / 2;

        int l_idx = init(idx * 2, start, mid);
        int r_idx = init(idx * 2 + 1, mid + 1, end);

        int min_idx = arr[l_idx] < arr[r_idx] ? l_idx : r_idx;
        return tree[idx] = min_idx;
    }

    static long solve(int left, int right) throws IOException {
        int min_idx = query(1, 0, n - 1, left, right);

        long ret = (long)arr[min_idx] * (right - left + 1);

        if(left < min_idx) ret = Math.max(ret, solve(left, min_idx - 1));
        if(min_idx < right) ret = Math.max(ret, solve(min_idx + 1, right));

        return ret;
    }

    static int query(int idx, int start, int end, int left, int right) {
        if(right < start || end < left)return -1;
        if (left <= start && end <= right) return tree[idx];

        int mid = (start + end) / 2;

        int left_min_idx = query(idx * 2, start, mid, left, right);
        int right_min_idx = query(idx * 2 + 1, mid + 1, end, left, right);

        if(left_min_idx == -1) return right_min_idx;
        if(right_min_idx == -1) return left_min_idx;
        return arr[left_min_idx] > arr[right_min_idx] ? right_min_idx : left_min_idx;
    }

}
