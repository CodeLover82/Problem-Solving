package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1780 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static int n;
    static int[][] arr = new int[3000][3000];
    static int a, b, c;

    // 변수, 배열, 내부 클래스 컬렉션 들을 전역으로 빼라. (스택 영역은 메모리 사용 가능량이 적으므로)
    // 예시 : static class Pair { .. }
    // 예시 : static Integer[] arr = new Integer[30005];

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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void solve() throws IOException {

        func(0, 0, n);
        sb.append(a + "\n");
        sb.append(b + "\n");
        sb.append(c + "\n");
    }

    private static void func(int x, int y, int size) {
        if (size == 1) {
            if(arr[x][y] == -1)a++;
            if(arr[x][y] == 0)b++;
            if(arr[x][y] == 1)c++;
            return;
        }

        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != num) {
                    num = -2;
                    break;
                }
            }
        }

        if (num == -1) a++;
        else if(num == 0) b++;
        else if (num == 1) c++;
        else {
            func(x, y, size / 3);
            func(x, y + size / 3, size / 3);
            func(x, y + size * 2 / 3, size / 3);
            func(x + size / 3, y, size / 3);
            func(x + size / 3, y + size / 3, size / 3);
            func(x + size / 3, y + size * 2 / 3, size / 3);
            func(x + size * 2 / 3, y, size / 3);
            func(x + size * 2 / 3, y + size / 3, size / 3);
            func(x + size * 2 / 3, y + size * 2 / 3, size / 3);
        }

    }


}
