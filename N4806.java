package BOJ;

/*
줄의 개수를 세는 프로그램을 작성하시오.

한 줄에 최대 100글자씩 주어진다. 
빈 줄이 주어질 수도 있다.

입력으로 몇 줄이 주어졌는지를 출력한다.

one
and two
three

3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N4806 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String str = "";
        while((str = read.readLine()) != null) {
            System.out.print(str);
            cnt++;
        }

        System.out.println(cnt);
    }
}