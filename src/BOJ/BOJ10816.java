package BOJ;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        init();

        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            Integer findNum = map.get(x);
            if(findNum == null) map.put(x, 1);
            else map.put(x, findNum + 1);
        }
    }

    static void solve() throws IOException {
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while (m-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            Integer findNum = map.get(x);
            if(findNum == null) sb.append("0 ");
            else sb.append(findNum + " ");
        }
    }

}
