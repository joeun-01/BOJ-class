package BOJ;

/*
알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.

첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.

첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.

pulljima

8
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String text = read.readLine();

        System.out.println(text.length());
    }
}