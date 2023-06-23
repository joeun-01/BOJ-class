package BOJ;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)

첫째 줄에 A+B를 출력한다.

9223372036854775807 9223372036854775808

18446744073709551615
 */

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        BigInteger A = new BigInteger(stoi.nextToken());
        BigInteger B = new BigInteger(stoi.nextToken());

        System.out.println(A.add(B));
    }
}