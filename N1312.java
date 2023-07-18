package BOJ;

/*
피제수(분자) A와 제수(분모) B가 있다. 
두 수를 나누었을 때, 소숫점 아래 N번째 자리수를 구하려고 한다. 
예를 들어, A=3, B=4, N=1이라면, A÷B=0.75 이므로 출력 값은 7이 된다.

첫 번째 줄에 A와 B(1 ≤ A, B ≤ 100,000), N(1 ≤ N ≤ 1,000,000)이 공백을 경계로 주어진다.

A÷B를 했을 때, 소숫점 아래 N번째 수를 출력한다.

25 7 5

2
 */

import java.io.*;
import java.util.StringTokenizer;

public class N1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int A = Integer.parseInt(stoi.nextToken());
        int B = Integer.parseInt(stoi.nextToken());
        int N = Integer.parseInt(stoi.nextToken());

        int result = A % B;

        for(int i = 0; i < N - 1; i++) {
            result *= 10;
            result %= B;
        }

        result *= 10;

        System.out.println(result / B);
    }
}
