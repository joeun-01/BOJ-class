package BOJ;

/*
창영이가 드디어 취직을 했다!! 
그가 30세까지 취직을 안하던 이유는 바로 마음에 다니는 직장을 찾지 못해서였다. 
이번에 창영이가 취직한 곳은 사탕 공장이다. 
사탕 공장에 다니면 사탕 처럼 달콤한 직장생활을 할 줄 알았지만, 8시간동안 사탕 품질을 검사해야 하는 작업은 너무나 지루했다.

사탕의 품질은 다음과 같이 검사한다. 
가장 먼저 사탕으로 가득 찬 박스를 연다. 
그 다음 사탕의 개수와 사탕이 없는 곳의 개수를 센다.

지루함을 견디지 못한 창영이는 결국 품질을 검사하는 프로그램을 작성하기로 했다.

r행 c열 행렬이 주어진다. 
이 행렬은 박스를 위에서 바라본 것이다. 
행렬에는 다음과 같은 문자만 있다.

".": 빈 곳
"o": 사탕의 먹을 수 있는 부분
"<>v^": 캔디 껍질
사탕은 오직 2가지 모습만 있다.

>o<
v
o
^
위와 같은 연속된 3개의 문자만 사탕이다.
사탕은 >o.와 같이 사탕의 일부만 존재할 수 있지만, 이 것은 사탕으로 세지 않는다.
r행 c열 행렬이 주어졌을 때, 사탕의 개수를 출력하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 t가 주어진다. 
각 테스트 케이스는 빈 줄로 구분된다.

각 테스트 케이스의 첫째 줄에는 r과 c 가 주어진다. (1 ≤ r,c ≤ 400) 
그 다음 r개의 줄에는 행렬의 각 행이 순서대로 주어진다. 
행렬의 각 행은 c개의 문자이며, ".o<>v^"만 포함하고 있다. (각각의 아스키 값은 46, 111, 60, 62, 118, 94이다)

각각의 테스트 케이스에 대해 한 줄에 하나의 정수만 출력한다. 
이 값은 박스에 들어있는 사탕의 개수이다.

1

5 4
.>o<
v.^.
ooo.
^.^.
>o<<

3
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2508 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        while(T > 0) {
            read.readLine();

            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int r = Integer.parseInt(stoi.nextToken());
            int c = Integer.parseInt(stoi.nextToken());

            char[][] box = new char[r][c];
            for(int i = 0; i < r; i++) {
                String str = read.readLine();
                for(int j = 0; j < c; j++) {
                    box[i][j] = str.charAt(j);
                }
            }

            int cnt = 0;
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(box[i][j] == 'o') {
                        if(0 < i && i < r - 1) {
                            if(box[i - 1][j] == 'v' && box[i + 1][j] == '^') cnt++;
                        }
                        if(0 < j && j < c - 1) {
                            if(box[i][j - 1] == '>' && box[i][j + 1] == '<') cnt++;
                        }
                    }
                }
            }

            build.append(cnt + "\n");

            T--;
        }

        System.out.println(build);
    }
}
