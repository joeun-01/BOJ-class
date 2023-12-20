package BOJ;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

첫째 줄에 A, 둘째 줄에 B가 주어진다. (0 < A, B < 10)

첫째 줄에 A+B를 출력한다.

1
2

3
 */

import java.io.*;

public class N2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(read.readLine());
        int B = Integer.parseInt(read.readLine());

        int result = A + B;
        System.out.println(result);
    }
}