package BOJ;

/*
자연수 A를 B번 곱한 수를 알고 싶다. 
단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

10 11 12

4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class N1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        int A = Integer.parseInt(stoi.nextToken());
        int B = Integer.parseInt(stoi.nextToken());
        int C = Integer.parseInt(stoi.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(int A, int B, int C) {
        if(B == 0) return 1;

        long answer = pow(A, B / 2, C);

        if(B % 2 == 0) return (answer * answer) % C;
        else return ((answer * answer) % C * A) % C;
    }
}