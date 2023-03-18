package BOJ;

/*
영문 문장을 입력받아 모음의 개수를 세는 프로그램을 작성하시오. 
모음은 'a', 'e', 'i', 'o', 'u'이며 대문자 또는 소문자이다.

입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 영어 대소문자, ',', '.', '!', '?', 공백으로 이루어진 문장이 주어진다. 
각 줄은 최대 255글자로 이루어져 있다.
입력의 끝에는 한 줄에 '#' 한 글자만이 주어진다.

각 줄마다 모음의 개수를 세서 출력한다.

How are you today?
Quite well, thank you, how about yourself?
I live at number twenty four.
#

7
14
9
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            String sentence = read.readLine();

            if(sentence.equals("#")) break;

            int num = 0;

            for(int i = 0; i < sentence.length(); i++) {
                if(sentence.charAt(i) == 'a' || sentence.charAt(i) == 'A') num++;
                else if(sentence.charAt(i) == 'e' || sentence.charAt(i) == 'E') num++;
                else if(sentence.charAt(i) == 'i' || sentence.charAt(i) == 'I') num++;
                else if(sentence.charAt(i) == 'o' || sentence.charAt(i) == 'O') num++;
                else if(sentence.charAt(i) == 'u' || sentence.charAt(i) == 'U') num++;
            }

            build.append(num + "\n");
        }

        System.out.println(build);
    }
}
