package BOJ;

import java.io.*;
import java.util.*;

public class BOJ11053 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int[] arr = new int[1005];
    static ArrayList<Integer> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {

        init();

        func(n - 1);
        sb.append(list.size());

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void func(int x) {
        if (x == 0) {
            list.add(arr[x]);
            return;
        }

        func(x - 1);

        int pos = lower_bound(arr[x]);
        if(pos == list.size())list.add(arr[x]);
        else list.set(pos, arr[x]);
    }

    static int lower_bound(int x) {
        int s = 0, e = list.size();

        while (s < e) {
            int mid = (s + e) / 2;

            if (list.get(mid) < x) s = mid + 1;
            else if (list.get(mid) > x) e = mid;
            else e = mid;
        }

        return s;
    }
}






