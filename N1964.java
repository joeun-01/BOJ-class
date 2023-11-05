package BOJ;

/*
오각형의 각 변에 아래 그림과 같이 점을 찍어 나간다. N단계에서 점의 개수는 모두 몇 개일까?

첫째 줄에 N(1 ≤ N ≤ 10,000,000)이 주어진다.

첫째 줄에 N단계에서 점의 개수를 45678로 나눈 나머지를 출력한다.

3

22
 */

import java.io.*;

public class N1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        // 5
        // 12 // + 7
        // 22 // + 10
        // 35 // + 13
        
        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 5;

        for(int i = 2; i <= N; i++) {
            DP[i] = (DP[i - 1] + 7 + 3 * (i - 2)) % 45678;
        }

        System.out.println(DP[N]);
    }
}