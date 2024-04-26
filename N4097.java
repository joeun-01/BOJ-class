package BOJ;

/*
연종이는 창업했다. 
오늘은 창업한지 N일이 되었고, 매일 매일 수익을 적어놓았다.

어느 날 연종이는 가장 많이 돈을 번 구간이 언제인지 궁금해졌다.
오늘이 창업한지 6일 되었고, 수익이 다음과 같다고 하자.

1일: -3
2일: 4
3일: 9
4일: -2
5일: -5
6일: 8
이때, 가장 많은 돈을 번 구간은 2~6까지이고 총 수입은 14이다.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 N이 주어져 있다. (1 ≤ N ≤ 250,000) 
둘째 줄부터 N개의 줄에는 매일 매일의 수익 P가 주어진다. (-10,000 ≤ P ≤ 10,000)
수익은 첫 날부터 순서대로 주어진다. 
입력의 마지막 줄에는 0이 주어진다.

각 테스트 케이스에 대해서 가장 많은 수익을 올린 구간의 수익을 출력한다. 
단, 구간이 비어있으면 안 된다.

6
-3
4
9
-2
-5
8
2
-1000
-19
0

14
-19
 */

import java.io.*;

public class N4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(read.readLine());
            if(N == 0) break;
            
            int[] profits = new int[N + 1];
            for(int i = 1; i <= N; i++) {
                profits[i] = Integer.parseInt(read.readLine());
            }

            int[] dp = new int[N + 1];
            dp[1] = profits[1];

            int max = -10001;
            for(int i = 2; i <= N; i++) {
                dp[i] = Math.max(profits[i], dp[i - 1] + profits[i]);
                max = Math.max(max, dp[i]);
            }
    
            build.append(max).append("\n");
        }

        System.out.println(build);
    }
}