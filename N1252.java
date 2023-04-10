package BOJ;

/*
두 개의 이진수를 입력받아 이를 더하는 프로그램을 작성하시오.

첫째 줄에 두 개의 이진수가 빈 칸을 사이에 두고 주어진다. 각 이진수는 1 또는 0으로만 이루어져 있으며, 0으로 시작할 수도 있다. 또한 각 이진수의 길이는 80을 넘지 않는다.

첫째 줄에 이진수 덧셈 결과를 출력한다. 결과가 0인 경우를 제외하고는 출력되는 이진수는 항상 1로 시작해야 한다.

1001101 10010

1011111
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        BigInteger A = new BigInteger(stoi.nextToken(), 2);
        BigInteger B = new BigInteger(stoi.nextToken(), 2);

        BigInteger result = A.add(B);

        System.out.println(result.toString(2));
    }
}