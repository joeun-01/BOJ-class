package BOJ;

/*
0보다 크거나 같은 정수 N이 주어진다. 
이때, N!을 출력하는 프로그램을 작성하시오.

첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.

첫째 줄에 N!을 출력한다.

10

3628800
 */

import java.io.*;

public class N27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        long fact = 1;
        for(int i = 2; i <= N; i++) {
            fact *= i;
        }

        System.out.println(fact);
    }
}