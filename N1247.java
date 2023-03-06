package BOJ;

/*
N개의 정수가 주어지면, 이 정수들의 합 S의 부호를 구하는 프로그램을 작성하시오.

총 3개의 테스트 셋이 주어진다. 각 테스트 셋의 첫째 줄에는 N(1 ≤ N ≤ 100,000)이 주어지고, 둘째 줄부터 N개의 줄에 걸쳐 각 정수가 주어진다. 주어지는 정수의 절댓값은 9223372036854775807보다 작거나 같다.

총 3개의 줄에 걸쳐 각 테스트 셋에 대해 N개의 정수들의 합 S의 부호를 출력한다. S=0이면 "0"을, S>0이면 "+"를, S<0이면 "-"를 출력하면 된다.

3
0
0
0
10
1
2
4
8
16
32
64
128
256
-512
6
9223372036854775807
9223372036854775806
9223372036854775805
-9223372036854775807
-9223372036854775806
-9223372036854775804

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class N1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            int N = Integer.parseInt(read.readLine());

            BigInteger sum = BigInteger.ZERO;
            for(int j = 0; j < N; j++) {
                BigInteger num = new BigInteger(read.readLine());

                sum = sum.add(num);
            }

            if(sum == BigInteger.ZERO) build.append("0\n");
            else if(sum.compareTo(BigInteger.ZERO) == -1) build.append("-\n");
            else build.append("+\n");
        }

        System.out.println(build);
    }
}
