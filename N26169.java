package BOJ;

/*
5 x 5 크기의 보드가 주어진다. 
보드는 1 x 1 크기의 정사각형 격자로 이루어져 있다. 
보드의 격자는 사과가 1개 있는 격자, 장애물이 있는 격자, 빈칸으로 되어 있는 격자로 구분된다. 
격자의 위치는 (r, c)로 표시한다. r은 행 번호, c는 열 번호를 나타낸다. 
행 번호는 맨 위 위치가 0이고 아래 방향으로 1씩 증가한다. 
열 번호는 맨 왼쪽 위치가 0이고 오른쪽으로 1씩 증가한다. 
즉, 맨 왼쪽 위 위치가 (0, 0), 맨 아래 오른쪽 위치가 (4, 4)이다.

현재 한 명의 학생이 (r, c) 위치에 있고 한 번의 이동으로 상, 하, 좌, 우 방향 중에서 한가지 방향으로 한 칸 이동할 수 있다. 
학생이 사과가 있는 칸으로 이동하면 해당 칸에 있는 사과를 1개 먹는다. 
장애물이 있는 칸으로는 이동할 수 없다. 
학생이 지나간 칸은 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다. 
즉, 학생이 해당 칸에서 상, 하, 좌, 우 방향으로 한 칸 이동하는 즉시 해당 칸은 장애물이 있는 칸으로 변경된다.

학생이 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 그렇지 않으면 0을 출력하자.

첫 번째 줄부터 다섯 개의 줄에 걸쳐 보드의 정보가 주어진다. 
i번째 줄의 j번째 수는 보드의 (i - 1)번째 행, (j - 1)번째 열의 정보를 나타낸다. 
보드의 정보가 1이면 해당 칸은 사과가 1개 있는 격자임을 나타내고, 0이면 빈칸이 있는 격자를 나타내고, -1이면 장애물이 있는 격자임을 나타낸다.

다음 줄에 학생의 현재 위치 r, c가 빈칸을 사이에 두고 순서대로 주어진다.

첫 번째 줄에 학생이 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 먹을 수 없으면 0을 출력한다.

0 ≤ r, c ≤ 4
현재 위치 (r, c)는 빈칸이다.

0 0 1 0 0
0 0 -1 0 0
0 0 1 0 0
1 1 -1 1 0
0 0 0 -1 0
4 1

1
 */

import java.io.*;
import java.util.StringTokenizer;

public class N26169 {
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int startRow = Integer.parseInt(stoi.nextToken());
        int startCol = Integer.parseInt(stoi.nextToken());

        boolean[][] visited = new boolean[5][5];
        visited[startRow][startCol] = true;

        // 백트래킹 시작
        dfs(startRow, startCol, 0, 0, visited);

        System.out.println(answer);
    }

    static void dfs(int r, int c, int moveCnt, int appleCnt, boolean[][] visited) {
        if (moveCnt > 3) return; // 세 번 이상 이동한 경우 종료

        if (appleCnt >= 2) { // 사과를 2개 이상 먹은 경우
            answer = 1;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue; // 범위를 벗어난 경우
            if (visited[nr][nc] || board[nr][nc] == -1) continue; // 이미 방문한 곳이거나 장애물이 있는 경우

            visited[nr][nc] = true;
            dfs(nr, nc, moveCnt + 1, appleCnt + (board[nr][nc] == 1 ? 1 : 0), visited);
            visited[nr][nc] = false;
        }
    }
}