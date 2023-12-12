package BOJ;

/*
엑셀 프로그램은 각 열의 순서를 알파벳 조합으로 구분한다. 
예를 들어, 열의 순서와 각 열을 나타내는 문자열은 다음과 같다.

열 문자열	A	B	C	…	X	Y	Z	AA	AB	AC	…	AZ	BA	…
열 순서	    1	2	3	…	24	25	26	27	28	29	…	52	53	…
열 문자열이 주어졌을 때 이에 대한 열 순서를 반환하는 코드를 작성하라.

첫째 줄에 1개 이상의 알파벳 대문자로 이루어진 열 문자열이 주어진다. 
입력 문자열의 길이는 10을 넘지 않는다.

첫째 줄에 열 순서를 출력한다.

X

24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N16495 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = read.readLine();
        int length = str.length();

        long totalCode = 0;
        for(int i = 0; i < length; i++) {
            char letter = str.charAt(i);

            int code = (int) letter - 64;
            totalCode += code * Math.pow(26, length - i - 1);
        }

        System.out.println(totalCode);
    }
}