package BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10844 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static long[][] dp = new long[105][15];
    static int n;
    // 변수, 배열, 컬렉션 들을 전역으로 빼라. (스택 영역은 메모리 사용 가능량이 적으므로)
    // 예시 : static Integer[] arr = new Integer[30005];

    public static void main(String[] args) throws IOException {
        init();

        long ret = 0;
        for(int i = 0;i < 10;i++)ret = (ret + func(n, i)) % 1000000000;

        sb.append(ret);

        bw.write(sb.toString());

        bw.flush();

        bw.close();
        br.close();
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1L);
    }

    static long func(int x, int y) {
        if (x == 1) {
            if(y == 0)return 0;
            return 1;
        }

        long ret = dp[x][y];
        if(ret != -1)return ret;

        if(y == 0) ret = func(x - 1, 1);
        else if(y == 9) ret = func(x - 1, 8);
        else ret = (func(x - 1, y - 1) + func(x - 1, y + 1)) % 1000000000;

        return dp[x][y] = ret;
    }

}
