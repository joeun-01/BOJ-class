package BOJ;

/*
정수 두개가 입력으로 들어오면 큰수 - 작은수의 값을 출력하시오.

두 정수가 입력된다.

큰수 - 작은 수의 값이 출력된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1154 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(read.readLine());

        int a = Integer.parseInt(input.nextToken());
        int b = Integer.parseInt(input.nextToken());

        System.out.println(Math.max(a, b) - Math.min(a, b));
    }
}
