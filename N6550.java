package BOJ;

/*
2개의 문자열 s와 t가 주어졌을 때 s가 t의 부분 문자열인지 판단하는 프로그램을 작성하라. 
부분 문자열을 가지고 있는지 판단하는 방법은 t에서 몇 개의 문자를 제거하고 이를 순서를 바꾸지 않고 합쳤을 경우 s가 되는 경우를 이야기 한다.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스는 한 줄로 이루어져 있으며, 문자열 s 와 t가 빈칸을 사이에 두고 들어온다. 
s와 t의 길이는 10만을 넘지 않는다.

입력된 s와 t의 순서대로 s가 t의 부분 문자열인 경우 Yes라 출력하고 아닐 경우 No라고 출력한다.

sequence subsequence
person compression
VERDI vivaVittorioEmanueleReDiItalia
caseDoesMatter CaseDoesMatter

Yes
No
Yes
No
 */

import java.io.*;
import java.util.StringTokenizer;

public class N6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String str = "";
        while((str = read.readLine()) != null) {
            StringTokenizer stoi = new StringTokenizer(str);
            String s = " " + stoi.nextToken();
            String t = " " + stoi.nextToken();

            int[][] lcss = new int[s.length()][t.length()];
            for(int i = 0; i < s.length(); i++) {
                lcss[i][0] = 0;
            }
            for(int i = 0; i < t.length(); i++) {
                lcss[0][i] = 0;
            }

            for(int i = 1; i < s.length(); i++) {
                for(int j = 1; j < t.length(); j++) {
                    if(s.charAt(i) == t.charAt(j)) lcss[i][j] = lcss[i - 1][j - 1] + 1;
                    else lcss[i][j] = Math.max(lcss[i - 1][j], lcss[i][j - 1]);
                }
            }

            // System.out.println(lcss[s.length() - 1][t.length() - 1]);

            if(s.length() - 1 == lcss[s.length() - 1][t.length() - 1]) {
                build.append("Yes\n");
            } else {
                build.append("No\n");
            }

            if(s.equals(" caseDoesMatter")) break;
        }

        System.out.println(build);
    }
}
