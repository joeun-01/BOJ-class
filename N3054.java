package BOJ;

/*
"피터팬 프레임"은 단어를 다이아몬드 형태로 장식하는 것이다.
알파벳 X를 피터팬 프레임으로 장식하면 다음과 같다.

..#..
.#.#.
#.X.#
.#.#.
..#..

"웬디 프레임"은 피터팬 프레임과 유사하지만, 다이아몬드를 '*'로 만드는 것이다. 
알파벳 X를 웬디 프레임으로 장식하면 다음과 같다.

..*..
.*.*.
*.X.*
.*.*.
..*..

단어가 주어졌을 때, 3의 배수 위치(세 번째, 여섯 번째, 아홉번째, ...)에 있는 알파벳은 웬디 프레임으로, 나머지 알파벳은 피터팬 프레임으로 장식하는 프로그램을 작성하시오.
웬디 프레임과 피터팬 프레임이 겹칠 경우에는, 웬디 프레임이 위에 있다.

첫째 줄에 알파벳 대문자로 이루어진 최대 15글자 단어가 주어진다.

다섯 줄에 걸쳐, 입력으로 주어진 단어를 피터팬 프레임과 웬디 프레임으로 장식한 결과를 출력한다.

A

..#..
.#.#.
#.A.#
.#.#.
..#..
 */

import java.io.*;

public class N3054 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = " " + read.readLine();

        String peter = "..#..\n.#.#.\n#.X.#\n.#.#.\n..#..";  // 0-4, 7-11, 14-18, 21-25, 
        String wendy = "..*..\n.*.*.\n*.X.*\n.*.*.\n..*..";

        String[] result = {"", "", "", "", ""};
        for(int i = 1; i < str.length(); i++) {
            if(i % 3 == 0) {  // 웬디 프레임
                String replace = wendy.replace('X', str.charAt(i));
                
                for(int j = 0; j < 5; j++) {
                    result[j] += replace.substring(j * 6, j * 6 + 5);
                }
            } else {
                String replace = peter.replace('X', str.charAt(i));
                for(int j = 0; j < 5; j++) {
                    if(i == str.length() - 1) {
                        if(i != 1 && i % 3 == 1) {
                            result[j] += replace.substring(j * 6 + 1, j * 6 + 5);
                        } else {
                            result[j] += replace.substring(j * 6, j * 6 + 5);
                        }
                    } else {
                        if(i != 1 && i % 3 == 1) {
                            result[j] += replace.substring(j * 6 + 1, j * 6 + 4);
                        } else {
                            result[j] += replace.substring(j * 6, j * 6 + 4);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            System.out.println(result[i]);
        }
    }
}
