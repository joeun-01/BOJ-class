package BOJ;

/*
피보나치 비스무리한 수열은 f(n) = f(n-1) + f(n-3)인 수열이다. 
f(1) = f(2) = f(3) = 1이며 피보나치 비스무리한 수열을 나열하면 다음과 같다.

1, 1, 1, 2, 3, 4, 6, 9, 13, 19, ...
자연수 n을 입력받아 n번째 피보나치 비스무리한 수열을 구해보자!

자연수 n(1 ≤ n ≤ 116)이 주어진다.

n번째 피보나치 비스무리한 수를 출력한다.

10

19
 */

import java.io.*;

public class N14495 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        long[] DP = new long[N + 1];
        DP[1] = 1;
        if(N == 1) {
            System.out.println(DP[N]);
            System.exit(0);
        }

        DP[2] = 1;
        if(N == 2) {
            System.out.println(DP[N]);
            System.exit(0);
        }

        DP[3] = 1;
        if(N == 3) {
            System.out.println(DP[N]);
            System.exit(0);
        }

        for(int i = 4; i <= N; i++) {
            DP[i] = DP[i - 1] + DP[i - 3];
        }

        System.out.println(DP[N]);
    }
}