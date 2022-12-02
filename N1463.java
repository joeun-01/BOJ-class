package BOJ;
/*
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

2

1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        int[] count = new int[n + 1];
        
        count[1] = 0;
        for(int i = 2; i <= n; i++) {
            // 그냥 모든 경우의 수를 다 해봐야 함 괜히.. 머리 쓴다고 나대지 말기
            if(i % 6 == 0) count[i] = Math.min(count[i / 3], Math.min(count[i / 2], count[i - 1])) + 1;
            else if(i % 3 == 0) count[i] = Math.min(count[i / 3], count[i - 1]) + 1;
            else if(i % 2 == 0) count[i] = Math.min(count[i / 2], count[i - 1]) + 1;
            else count[i] = count[i - 1] + 1;
        }
        
        System.out.println(count[n]);
    }
}
