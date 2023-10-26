package BOJ;

/*
두 정수 A와 B가 주어졌을 때, 두 정수 사이에 있는 수의 합을 구하는 프로그램을 작성하시오. 
사이에 있는 수들은 A와 B도 포함한다.

첫째 줄에 두 정수 A, B가 주어진다. (-2,147,483,648 ≤ A, B ≤ 2,147,483,647)

첫째 줄에 답을 출력한다. (-2,147,483,648 ≤ 답 ≤ 2,147,483,647)

1 2

3
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2355 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        long M = Long.parseLong(stoi.nextToken());
        long N = Long.parseLong(stoi.nextToken());

        long A = Math.min(M, N);
        long B = Math.max(M, N);

        long sum = (((B + 1) * B) / 2) - (((A - 1) * A) / 2);

        System.out.println(sum);
    }
}