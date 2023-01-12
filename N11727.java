package BOJ;

/*
2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
아래 그림은 2×17 직사각형을 채운 한가지 예이다.

첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

2

3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(read.readLine());
        int[] dp = new int[n + 1];

        if(n == 1) System.out.println("1");
        else if(n == 2) System.out.println("3");
        else {
            dp[1] = 1;
            dp[2] = 3;

            for(int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
            }

            System.out.println(dp[n]);
        }
    }
}
