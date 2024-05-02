package BOJ;

/*
상근이는 2863번에서 표를 너무 열심히 돌린 나머지 5와 6을 헷갈리기 시작했다.
상근이가 숫자 5를 볼 때, 5로 볼 때도 있지만, 6으로 잘못 볼 수도 있고, 6을 볼 때는, 6으로 볼 때도 있지만, 5로 잘못 볼 수도 있다.
두 수 A와 B가 주어졌을 때, 상근이는 이 두 수를 더하려고 한다. 
이때, 상근이가 구할 수 있는 두 수의 가능한 합 중, 최솟값과 최댓값을 구해 출력하는 프로그램을 작성하시오.

첫째 줄에 두 정수 A와 B가 주어진다. (1 <= A,B <= 1,000,000)

첫째 줄에 상근이가 구할 수 있는 두 수의 합 중 최솟값과 최댓값을 출력한다.

11 25

36 37
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2864 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        String A = stoi.nextToken();
        String B = stoi.nextToken();

        // 최대 : 다 6으로 변경
        // 최소 : 다 5로 변경
        
        int maxA = Integer.parseInt(A.replaceAll("5", "6"));
        int maxB = Integer.parseInt(B.replaceAll("5", "6"));
        int max = maxA + maxB;
                
        int minA = Integer.parseInt(A.replaceAll("6", "5"));
        int minB = Integer.parseInt(B.replaceAll("6", "5"));
        int min = minA + minB;

        System.out.println(min + " " + max);
    }
}