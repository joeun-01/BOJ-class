package BOJ;

/*
피보나치 수는 0과 1로 시작한다. 
0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.

n=17일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

첫째 줄에 n이 주어진다. 
n은 1,000,000보다 작거나 같은 자연수 또는 0이다.

첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.

10

55
 */

import java.io.*;

public class N15624 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        long[] DP = new long[N + 1];
        DP[0] = 0;
        if(N == 0) {
            System.out.println(DP[N]);
            System.exit(0);
        }

        DP[1] = 1;
        for(int i = 2; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 1000000007;
        }

        System.out.println(DP[N]);
    }
}