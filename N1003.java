package BOJ;

/*
 * fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
 * 
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
 * fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
 * 
 * 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
 * fibonacci(0)은 0을 출력하고, 0을 리턴한다.
 * fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
 * 
 * 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
 * fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
 * 1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. 
 * N은 40보다 작거나 같은 자연수 또는 0이다.
 * 
 * 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
 * 
 * 3
 * 0
 * 1
 * 3
 * 
 * 1 0
 * 0 1
 * 1 2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());

        int i, j;
        for(i = 0; i < num; i++) {
            int n = Integer.parseInt(read.readLine());

            if(n == 0) {
                build.append("1 0\n");
            } else if(n == 1) {
                build.append("0 1\n");
            } else {
                int[][] fibonacci = new int[n + 1][3];

                fibonacci[0][0] = 0;
                fibonacci[0][1] = 1;
                fibonacci[0][2] = 0;

                fibonacci[1][0] = 1;
                fibonacci[1][1] = 0;
                fibonacci[1][2] = 1;

                for(j = 2; j <= n; j++) {    
                    fibonacci[j][0] = fibonacci[j - 1][0] + fibonacci[j - 2][0];
                    fibonacci[j][1] = fibonacci[j - 1][1] + fibonacci[j - 2][1];
                    fibonacci[j][2] = fibonacci[j - 1][2] + fibonacci[j - 2][2];
                }
    
                build.append(fibonacci[n][1] + " " + fibonacci[n][2] + "\n");
            }
        }

        System.out.println(build);
    }
}
