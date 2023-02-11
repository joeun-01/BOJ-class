package BOJ;

/*
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

첫째 줄에 행렬의 크기 N 과 M이 주어진다. 
둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 
이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. 
N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 
행렬의 각 원소는 공백으로 구분한다.

3 3
1 1 1
2 2 2
0 1 0
3 3 3
4 4 4
5 5 100

4 4 4
6 6 6
5 6 100
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[][] A = new int[N][M];

        // 행렬 A
        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());

            for(int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        // 행렬 B를 더함
        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());

            for(int j = 0; j < M; j++) {
                A[i][j] += Integer.parseInt(stoi.nextToken());
                build.append(A[i][j] + " ");
            }
            build.append("\n");
        }

        System.out.println(build);
    }
}
