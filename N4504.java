package BOJ;

/*
정수 n(0 < n < 1000)과 수의 목록이 주어졌을 때, 목록에 들어있는 수가 n의 배수인지 아닌지를 구하는 프로그램을 작성하시오.

첫째 줄에 n이 주어진다. 
다음 줄부터 한 줄에 한 개씩 목록에 들어있는 수가 주어진다. 
이 수는 0보다 크고, 10,000보다 작다. 목록은 0으로 끝난다.

목록에 있는 수가 n의 배수인지 아닌지를 구한 뒤 예제 출력처럼 출력한다.

3
1
7
99
321
777
0

1 is NOT a multiple of 3.
7 is NOT a multiple of 3.
99 is a multiple of 3.
321 is a multiple of 3.
777 is a multiple of 3.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N4504 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        while(true) {
            int cnt = Integer.parseInt(read.readLine());

            if(cnt == 0) break;

            if(cnt % N == 0) build.append(cnt + " is a multiple of " + N + ".\n");
            else build.append(cnt + " is NOT a multiple of " + N + ".\n");
        }

        System.out.println(build);
    }
}