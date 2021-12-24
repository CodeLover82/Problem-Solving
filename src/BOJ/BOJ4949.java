package BOJ;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ4949 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        solve();

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void solve() throws IOException {
        while (true) {
            String str = br.readLine();

            if(str.equals(".")) break;

            func(str);
        }
    }

    static void func(String str) {
        boolean sync = true;

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if(ch.equals('(') || ch.equals('[')) stack.push(ch);
            else if (ch.equals(')')) {
                if (stack.empty() || !stack.peek().equals('(')) {
                    sync = false;
                    break;
                }
                stack.pop();
            } else if(ch.equals(']')){
                if (stack.empty() || !stack.peek().equals('[')) {
                    sync = false;
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.empty())sync = false;

        if(sync == true) sb.append("yes\n");
        else sb.append("no\n");

        stack.clear();
    }

}






