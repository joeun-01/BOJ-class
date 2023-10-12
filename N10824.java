package BOJ;

/*
네 자연수 A, B, C, D가 주어진다. 
이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.

두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 
즉, 20과 30을 붙이면 2030이 된다.

첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)

A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.

10 20 30 40

4060
 */

import java.io.*;
import java.util.StringTokenizer;

public class N10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        long AB = Long.parseLong(stoi.nextToken() + stoi.nextToken());
        long CD = Long.parseLong(stoi.nextToken() + stoi.nextToken());

        System.out.println(AB + CD);
    }
}
