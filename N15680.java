package BOJ;

/*
연세대학교의 영문명은 YONSEI, 슬로건은 Leading the Way to the Future이다.

이를 출력하는 프로그램을 작성해보도록 하자.

첫째 줄에 N이 주어진다. (N = 0 또는 1)

N = 0일 경우: 연세대학교의 영문명을 출력한다.
N = 1일 경우: 연세대학교의 슬로건을 출력한다.
대소문자 구별에 주의하도록 하자.

0

YONSEI
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N15680 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        if(N == 0) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}