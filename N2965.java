package BOJ;

/*
캥거루 세 마리가 사막에서 놀고 있다. 
사막에는 수직선이 하나 있고, 캥거루는 서로 다른 한 좌표 위에 있다.

한 번 움직일 때, 바깥쪽의 두 캥거루 중 한 마리가 다른 두 캥거루 사이의 정수 좌표로 점프한다. 
한 좌표 위에 있는 캥거루가 두 마리 이상일 수는 없다.

캥거루는 최대 몇 번 움직일 수 있을까?

첫째 줄에 세 캥거루의 초기 위치 A, B, C가 주어진다. (0 < A < B < C < 100)

캥거루가 최대 몇 번 움직일 수 있는지 출력한다.

2 3 5

1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2965 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        int A = Integer.parseInt(stoi.nextToken());
        int B = Integer.parseInt(stoi.nextToken());
        int C = Integer.parseInt(stoi.nextToken());

        System.out.println(Math.max(B - A, C - B) - 1);
    }
}