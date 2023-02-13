package BOJ;

/*
영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

첫째 줄에 입력으로 주어진 단어에서 대문자는 소문자로, 소문자는 대문자로 바꾼 단어를 출력한다.

WrongAnswer

wRONGaNSWER
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String text = read.readLine();
        String result = "";

        for(int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            int ascii = (int) letter;

            if(65 <= ascii && ascii <= 90) {
                char newLetter = (char) (ascii + 32);
                result += newLetter;
            } else if(97 <= ascii && ascii <= 122) {
                char newLetter = (char) (ascii - 32);
                result += newLetter;
            }
        }

        System.out.println(result);
    }
}
