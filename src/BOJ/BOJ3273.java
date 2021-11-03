package BOJ;

import java.io.*;
import java.util.*;

public class BOJ3273 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n, x;
    static Map<Integer, Boolean> map;
    static int result;

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

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, true);
        }

        result = 0;
        x = Integer.parseInt(br.readLine());
    }

    static void solve() throws IOException {
        Iterator<Integer> iter = map.keySet().iterator();

        while (iter.hasNext()) {
            int num = iter.next();
            int targetNum = x - num;

            if(!map.containsKey(targetNum))continue;
            else result++;


        }
        sb.append(result / 2);


    }

}

