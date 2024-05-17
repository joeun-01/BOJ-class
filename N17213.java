/*
민건이네 과일 농장은 N가지 종류의 과일을 재배하는 중이다. 
평소 민건이에게 앙심을 품고 있던 지환이는 민건이를 골탕 먹이기 위하여 민건이네 과일 농장에서 과일들을 훔치기로 다짐했다. 
지환이는 완벽한 범죄를 위하여 처음 생각한 개수 만큼만 훔치려고 한다. 
이때 지환이가 훔칠 수 있는 경우의 수가 몇가지나 될 지 알아보자. 
단, 모든 종류의 과일을 적어도 1개는 훔친다.

첫째 줄에 과일의 종류 수 N(1 ≤ N ≤ 10)이 주어진다.
둘째 줄에 훔치려 하는 과일의 개수 M(N ≤ M ≤ 30)이 주어진다.

첫째 줄에 훔칠 수 있는 경우의 수를 출력한다.

3
10

36
 */

import java.io.*;

public class N17213 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        int M = Integer.parseInt(read.readLine());

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= M; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }

        System.out.println(dp[N][M]);
    }
}