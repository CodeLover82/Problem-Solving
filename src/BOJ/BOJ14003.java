package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14003 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;

    static int n;
    static int[] arr;
    static ArrayList<Integer> list;
    static int[] index; // index[i] : arr의 i번째 요소가 list에서 몇번째 위치에 있는지.

    public static void main(String[] args) throws IOException {
        init();
        solve();

        bw.write(sb.toString());

        bw.flush();
    }

    static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder(); st = null;

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        index = new int[n + 1];
    }

    static void solve() throws IOException {
        list.add(arr[0]);
        index[0] = 0;

        for (int i = 1; i < n; i++) {
            int pos = lower_bound(arr[i]);

            if(pos == list.size()) list.add(arr[i]);
            else list.set(pos, arr[i]);

            index[i] = pos;
        }

        Stack<Integer> stack = new Stack<>();

        // 뒤에서부터 특정 위치에 해당하는 처음 위치를 찾으면, 그 값은 리스트 상에서 더이상 이 뒤쪽에서 갱신이 된 것이 없음을 보장하므로, 정당성이 있다.
        int pos = list.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == pos) {
                stack.push(arr[i]);
                pos--;
            }
        }

        sb.append(list.size() + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
    }

    static int lower_bound(int x) {
        int s = 0, e = list.size();

        while (s < e) {
            int mid = (s + e) / 2;

            if(list.get(mid) < x) s = mid + 1;
            else if(list.get(mid) > x) e = mid;
            else e = mid;
        }

        return s;
    }

}




