package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1514 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int result;
    static boolean visitMinus;


    public static void main(String[] args) throws IOException {
        init();

        func();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), "+-", true);
        result = 0;
        visitMinus = false;
    }

    static void func() {
        while (st.hasMoreTokens()) {
            String value = st.nextToken();

            if (value.equals("-")) {
                visitMinus = true;

                int x = Integer.parseInt(st.nextToken());
                result -= x;
            }
            else if (value.equals("+")) {
                int x = Integer.parseInt(st.nextToken());

                if(visitMinus)result -= x;
                else result += x;
            }
            else {
                result += Integer.parseInt(value);
            }

        }

        sb.append(result);
    }

}
