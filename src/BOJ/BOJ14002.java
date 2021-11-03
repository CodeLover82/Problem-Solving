package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14002 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;
    static int n;
    static int[] arr, pos;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pos = new int[n];

        list = new ArrayList<>();
    }

    static void solve() throws IOException {
        list.add(arr[0]);
        pos[0] = 0;

        for (int i = 1; i < n; i++) {
            int idx = lower_bound(arr[i]);
            pos[i] = idx;

            if(idx == list.size()) list.add(arr[i]);
            else list.set(idx, arr[i]);
        }

        sb.append(list.size() + "\n");

        Stack<Integer> st = new Stack<>();

        int tmp_pos = list.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (pos[i] == tmp_pos) {
                st.push(arr[i]);
                tmp_pos--;
            }
        }

        while (!st.empty()) {
            sb.append(st.peek() + " ");
            st.pop();
        }

    }

    static int lower_bound(int x) {
        int s = 0, e = list.size();
        while (s < e) {
            int mid = (s + e) / 2;
            if(list.get(mid) < x) s = mid + 1;
            else e = mid;
        }
        return s;
    }

}

