package BOJ;

/*
2차원 좌표 상의 여러 점의 좌표 (x,y)가 주어졌을 때, 각 사분면과 축에 점이 몇 개 있는지 구하는 프로그램을 작성하시오.

첫째 줄에 점의 개수 n (1 ≤ n ≤ 1000)이 주어진다. 다음 n개 줄에는 점의 좌표 (xi, yi)가 주어진다. (-106 ≤ xi, yi ≤ 106)

각 사분면과 축에 점이 몇 개 있는지를 예제 출력과 같은 형식으로 출력한다.

5
0 0
0 1
1 1
3 -3
2 2

Q1: 2
Q2: 0
Q3: 0
Q4: 1
AXIS: 2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int fisrt = 0, second = 0, third = 0, fourth = 0, axis = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int x = Integer.parseInt(stoi.nextToken());
            int y = Integer.parseInt(stoi.nextToken());

            if(x == 0 || y == 0) axis++;
            else if(x > 0 && y > 0) fisrt++;
            else if(x < 0 && y > 0) second++;
            else if(x < 0 && y < 0) third++;
            else if(x > 0 && y < 0) fourth++;
        }

        System.out.println("Q1: " + fisrt);
        System.out.println("Q2: " + second);
        System.out.println("Q3: " + third);
        System.out.println("Q4: " + fourth);
        System.out.println("AXIS: " + axis);
    }
}
