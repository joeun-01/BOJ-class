package BOJ;

/*
n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

1부터 n까지 합을 출력한다.

3

6
 */

import java.io.*;

public class N8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}