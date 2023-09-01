package BOJ;

/*
두 정수 A와 B가 주어졌을 때, 두 수의 곱을 출력하는 프로그램을 작성하시오.

첫째 줄에 정수 A와 B가 주어진다. 
두 정수는 0보다 크거나 같은 정수이며, 0을 제외한 정수는 0으로 시작하지 않으며, 수의 앞에 불필요한 0이 있는 경우도 없다. 
또한, 수의 길이는 300,000자리를 넘지 않는다.

두 수의 곱을 출력한다.

1 2

2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class N13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        BigInteger A = new BigInteger(stoi.nextToken());
        BigInteger B = new BigInteger(stoi.nextToken());

        System.out.println(A.multiply(B));
    }   
}