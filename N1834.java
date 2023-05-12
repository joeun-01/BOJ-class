package BOJ;

/*
N으로 나누었을 때 나머지와 몫이 같은 모든 자연수의 합을 구하는 프로그램을 작성하시오. 
예를 들어 N=3일 때, 나머지와 몫이 모두 같은 자연수는 4와 8 두 개가 있으므로, 그 합은 12이다.

첫째 줄에 2,000,000 이하의 자연수 N이 주어진다.

첫 줄에 구하고자 하는 수를 출력한다.

3

12
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1834 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(read.readLine());

        long sum = (N - 1) * ((N + 1) + (N - 1) * (N + 1)) / 2;
        
        System.out.println(sum);
    }
}
