package BOJ;

/*
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 
각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

1번 집의 색은 2번 집의 색과 같지 않아야 한다.
N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 
집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

3
26 40 83
49 60 57
13 89 99

96
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // 집의 개수
        int H = Integer.parseInt(read.readLine());

        int[][] dp = new int[H][3];

        for(int i = 0; i < H; i++) {
            StringTokenizer color = new StringTokenizer(read.readLine());

            int red = Integer.parseInt(color.nextToken());
            int green = Integer.parseInt(color.nextToken());
            int blue = Integer.parseInt(color.nextToken());

            if(i == 0) {
                dp[i][0] = red; 
                dp[i][1] = green;
                dp[i][2] = blue;
            } else {
                // 전 색에서 가장 작은 값과 현재 자기 색을 더함
                // 단계 별로 각 색을 더할 수 있는 경우의 최솟값을 구하는 것
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
            }
        }

        System.out.println(Math.min(dp[H - 1][0], Math.min(dp[H - 1][1], dp[H - 1][2])));
    }
}
