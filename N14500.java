package BOJ;

/*
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.

아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 
종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. 
i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 
입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

19
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N14500 {
    static int row;
    static int column;

    static int[][] table;
    static boolean[][] visited;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(read.readLine());
        row = Integer.parseInt(input.nextToken());
        column = Integer.parseInt(input.nextToken());

        table = new int[row][column];
        visited = new boolean[row][column];

        for(int i = 0; i < row; i++) {
            StringTokenizer rowStr = new StringTokenizer(read.readLine());
            for(int j = 0; j < column; j++) {
                table[i][j] = Integer.parseInt(rowStr.nextToken());
            }
        }

        // DFS로 모든 모양을 만들 수 있음
        // 어디로 가도 문제에서 원하는 모양들이 나옴
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                visited[i][j] = true;
                DFS(i, j, table[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

	static void DFS(int r, int c, int sum, int count) {
		if(count == 4) {  // 테트로미노 완성 시 합을 리턴
			max = Math.max(max, sum);
			return;
		}

        int[] dr = {-1, 1, 0, 0};  // 상하좌우
        int[] dc = {0, 0, -1, 1};  // 상하좌우

		for(int i = 0; i < 4; i++) {
			int nr = r+ dr[i];
			int nc = c + dc[i];

			// 범위 벗어나면 예외 처리
			if(nr < 0 || nr >= row || nc < 0 || nc >= column) {
				continue;
			}

			// 아직 방문하지 않은 곳이라면
			if(!visited[nr][nc]) {

				// 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
				if(count == 2) {
					visited[nr][nc] = true;
					DFS(r, c, sum + table[nr][nc], count + 1);
					visited[nr][nc] = false;
				}

				visited[nr][nc] = true;
				DFS(nr, nc, sum + table[nr][nc], count + 1);
				visited[nr][nc] = false;
			}
		}
	}
}

