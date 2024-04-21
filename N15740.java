package BOJ;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

첫째 줄에 A와 B (-10^10000 ≤ A, B ≤ 10^10000)가 주어진다.

첫째 줄에 A+B를 출력한다.

1 2

3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        BigInteger A = new BigInteger(stoi.nextToken());
        BigInteger B = new BigInteger(stoi.nextToken());

        System.out.println(A.add(B));
    }
}