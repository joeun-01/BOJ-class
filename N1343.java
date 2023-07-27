package BOJ;

/*
민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. (AAAA와 BB)
이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 
이때, '.'는 폴리오미노로 덮으면 안 된다.

폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.

첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.

첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 
만약 덮을 수 없으면 -1을 출력한다.

XXXXXX

AAAABB
 */

import java.io.*;

public class N1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String board = read.readLine();

        String result = "";
        int Xcnt = 0;
        for(int i = 0; i < board.length(); i++) {
            if(board.charAt(i) == '.') {
                String X = board.substring(i - Xcnt, i);

                if(X.length() % 2 == 1) {
                    System.out.println(-1);
                    System.exit(0);
                }

                int A = X.length() / 4;
                for(int j = 0; j < A; j++) {
                    result += "AAAA";
                }

                int B = (X.length() - A * 4) / 2;
                for(int j = 0; j < B; j++) {
                    result += "BB";
                }

                Xcnt = 0;
                result += ".";
            } else if(board.charAt(i) == 'X') {
                Xcnt++;
            }
        }

        String X = board.substring(board.lastIndexOf(".") + 1, board.length());
        if(X.length() % 2 == 1) {
            System.out.println(-1);
            System.exit(0);
        }

        int A = X.length() / 4;
        for(int j = 0; j < A; j++) {
            result += "AAAA";
        }

        int B = (X.length() - A * 4) / 2;
        for(int j = 0; j < B; j++) {
            result += "BB";
        }

        System.out.println(result.substring(0, board.length()));
    }
}