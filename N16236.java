package BOJ;

/*
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 
공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 
한 칸에는 물고기가 최대 1마리 존재한다.
아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 
가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
2. 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
3. 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.

거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 
즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 
물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 
예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.

첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.

첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.

3
0 0 0
0 0 0
0 9 0

0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;

public class N16236 {
    static int N;
    static int[][] space;
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(read.readLine());

        space = new int[N][N];

        int sti = 0;
        int stj = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(read.readLine());
            for(int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(row.nextToken());

                if(space[i][j] == 9) {
                    sti = i;
                    stj = j;
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(sti + " " + stj);
        space[sti][stj] = 0;

        int sec = 0;
        int shark = 2, fish = -1;
    
        while(!queue.isEmpty()) {
            StringTokenizer stoi = new StringTokenizer(queue.poll());

            int row = Integer.parseInt(stoi.nextToken());
            int col = Integer.parseInt(stoi.nextToken());

            fish++;

            if(fish == shark) {
                shark++;
                fish = 0;
            }

            StringTokenizer next = new StringTokenizer(BFS(row, col, shark));

            int nextRow = Integer.parseInt(next.nextToken());
            int nextCol = Integer.parseInt(next.nextToken());

            if(row == nextRow && col == nextCol) break;
            
            queue.add(nextRow + " " + nextCol);
            sec += Integer.parseInt(next.nextToken());
        }

        System.out.println(sec);
        
    }

    public static String BFS(int str, int stc, int shark) {
        Queue<String> queue = new LinkedList<>();

        boolean[][] visited = new boolean[N][N];
        int[][] path = new int[N][N];

        visited[str][stc] = true;
        queue.add(str + " " + stc);

        int[] r = {-1, 0, 0, 1};
        int[] c = {0, -1, 1, 0};

        while(!queue.isEmpty()) {
            StringTokenizer node = new StringTokenizer(queue.poll());
            
            int nr = Integer.parseInt(node.nextToken());
            int nc = Integer.parseInt(node.nextToken());

            for(int i = 0; i < 4; i++) {
                int row = nr + r[i];
                int col = nc + c[i];

                if(row >= 0 && row < N && col >= 0 && col < N) {
                    // 자기보다 크기가 작거나 같은 경우에만 지나갈 수 있음
                    if(!visited[row][col] && space[row][col] <= shark) {
                        // 길 +1
                        visited[row][col] = true;
                        path[row][col] = path[nr][nc] + 1;
                        queue.add(row + " " + col);

                        System.out.println("row : " + row + " col : " + col + " / " + space[row][col]);

                        if(space[row][col] != 0 && space[row][col] < shark) {
                            // 같은 경우에는 먹음
                            space[row][col] = 0;
                            return row + " " + col + " " + path[row][col];    
                        }
                    }

                }
            }

        }

        return str + " " + stc;
    }
}
