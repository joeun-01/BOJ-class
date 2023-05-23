package BOJ;

/*
M줄 N칸으로 되어 있는 표 위에, 달팽이 모양으로 선을 그리려고 한다.

위의 그림은 M=5, N=3의 예이다. 
이제 표의 왼쪽 위 칸(ㅇ)에서 시작하여, 오른쪽으로 선을 그려 나간다. 
표의 바깥 또는 이미 그려진 칸에 닿아서 더 이상 이동할 수 없게 되면, 시계방향으로 선을 꺾어서 그려나간다.

ㅇ	→	↘
↗	↘	↓
↑	↓	↓
↑	끝	↓
↖	←	↙
위의 표는 선을 그려 나간 모양을 나타낸 것이다. 
선이 꺾어진 부분은 대각선으로 나타내었다. 
표의 모든 칸이 채워질 때까지, 선을 몇 번 꺾게 될까?

첫째 줄에 M과 N이 빈 칸을 사이에 두고 주어진다. (2 ≤ M, N ≤ 100)

첫째 줄에 표의 모든 칸이 채워질 때까지 선이 꺾어지는 횟수를 출력한다.

5 3

5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int M = Integer.parseInt(stoi.nextToken());
        int N = Integer.parseInt(stoi.nextToken());

        boolean[][] table = new boolean[M][N];
        
        int r = 0, c = 0;  // row, column
        int dir = 0;  // 0 : 오른쪽, 1 : 아래, 2 : 왼쪽, 3 : 위

        int cnt = 0;
        while(true) {
            table[r][c] = true;

            if(dir == 0) {
                if(c + 1 >= N || table[r][c + 1]) {
                    dir = 1;
                    r++;

                    if(r >= M || table[r][c]) break;

                    cnt++;
                } else {
                    c++;
                }
            } else if(dir == 1) {
                if(r + 1 >= M || table[r + 1][c]) {
                    dir = 2;
                    c--;

                    if(c < 0 || table[r][c]) break;

                    cnt++;
                } else {
                    r++;
                }
            } else if(dir == 2) {
                if(c - 1 < 0 || table[r][c - 1]) {
                    dir = 3;
                    r--;

                    if(r < 0 || table[r][c]) break;

                    cnt++;
                } else {
                    c--;
                }
            } else if(dir == 3) {
                if(r - 1 < 0 || table[r - 1][c]) {
                    dir = 0;
                    c++;

                    if(c >= N || table[r][c]) break;

                    cnt++;
                } else {
                    r--;
                }
            }
        }

        System.out.println(cnt);
    }
}