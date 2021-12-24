package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {

    static BufferedReader br; static BufferedWriter bw;
    static StringBuilder sb; static StringTokenizer st;
    static Node[] tree;
    static int n;

    // 변수, 배열, 내부 클래스 컬렉션 들을 전역 static 으로 빼라. (스택 영역은 메모리 사용 가능량이 적으므로)

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
        tree = new Node[n + 1];
        for (int i = 0; i <= n; i++) tree[i] = new Node();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].adj.add(b);
            tree[b].adj.add(a);
        }
    }

    static void solve() throws IOException {
        tree[1].parent = -1;


        for (int child : tree[1].adj) {
            makeTree(1, child);
        }

        for (int i = 2; i <= n; i++) {
            sb.append(tree[i].parent + "\n");
        }
    }

    static void makeTree(int parent, int now) {
        tree[now].parent = parent;

        for (int child : tree[now].adj) {
            if(child == parent)continue;
            makeTree(now, child);
        }

    }

    static class Node {
        int parent;
        ArrayList<Integer> adj = new ArrayList<>();
    }

}

