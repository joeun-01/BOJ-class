package BOJ;

/*
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 
예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.
N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

첫째 줄에 정수 N, r, c가 주어진다.

r행 c열을 몇 번째로 방문했는지 출력한다.

2 3 1

11
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class N1074 {
    static int r;
    static int c; 

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer token = new StringTokenizer(read.readLine());

        int n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        find(n, 0, 0, 0);
    }

    public static void find(int n, int start, int row, int column) {
        if(n == 0) {
            if(row == r && column == c) {
                System.out.println(start);
            }
        } else {
            int half = (int) Math.pow(2, n - 1);
            
            // System.out.println("r : " + r + ", half + row : " + (half + row));
            // System.out.println("c : " + c + ", half + column : " + (half + column));

            if(r < half + row && c < half + column) {
                find(n - 1, start, row, column);
            } else if(r < half + row && c >= half + column) {
                find(n - 1, start + (int) Math.pow(2, 2 * n - 2), row, column + (int) Math.pow(2, n - 1));
            } else if(r >= half + row && c < half + column) {
                find(n - 1, start + 2 * ((int) Math.pow(2, 2 * n - 2)), row + (int) Math.pow(2, n - 1), column);
            } else if(r >= half + row && c >= half + column) {
                find(n - 1, start + 3 * ((int) Math.pow(2, 2 * n - 2)), row + (int) Math.pow(2, n - 1), column + (int) Math.pow(2, n - 1));
            }
        }        
    }
}
