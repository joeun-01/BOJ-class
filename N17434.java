package BOJ;

/*
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

첫째 줄에 정수 N(0 ≤ N ≤ 100,000)이 주어진다.

첫째 줄에 N!을 출력한다.

10

3628800
 */

import java.io.*;
import java.math.BigInteger;

public class N17434 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        BigInteger num = BigInteger.ONE;
        for(int i = 2; i <= N; i++) {
            num = num.multiply(new BigInteger(Integer.toString(i)));
        }

        System.out.println(num);
    }
}