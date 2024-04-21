package BOJ;

/*
어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다. 
예를 들어 11=32+12+12(3개 항)이다. 
이런 표현방법은 여러 가지가 될 수 있는데, 11의 경우 11=22+22+12+12+12(5개 항)도 가능하다. 
이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다. 
또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로, 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.

주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.

첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)

주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.

7

4
 */

import java.io.*;

public class N1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());

        int[] DP = new int[N + 1];
        DP[1] = 1;

        int temp = 1;
        for(int i = 2; i <= N; i++) {
            if((temp + 1) * (temp + 1) == i) {
                DP[i] = 1;

                temp++;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for(int j = temp; j > 0; j--) {
                min = Math.min(min, DP[i - j * j]);
            }
            
            DP[i] = min + 1;
        }

        System.out.println(DP[N]);
    }
}