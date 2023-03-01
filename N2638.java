package BOJ;

/*
N×M의 모눈종이 위에 아주 얇은 치즈가 <그림 1>과 같이 표시되어 있다. 
단, N 은 세로 격자의 수이고, M 은 가로 격자의 수이다.
이 치즈는 냉동 보관을 해야만 하는데 실내온도에 내어놓으면 공기와 접촉하여 천천히 녹는다. 
그런데 이러한 모눈종이 모양의 치즈에서 각 치즈 격자(작 은 정사각형 모양)의 4변 중에서 적어도 2변 이상이 실내온도의 공기와 접촉한 것은 정확히 한시간만에 녹아 없어져 버린다. 
따라서 아래 <그림 1> 모양과 같은 치즈(회색으로 표시된 부분)라면 C로 표시된 모든 치즈 격자는 한 시간 후에 사라진다.

<그림 2>와 같이 치즈 내부에 있는 공간은 치즈 외부 공기와 접촉하지 않는 것으로 가정한다. 
그러므 로 이 공간에 접촉한 치즈 격자는 녹지 않고 C로 표시된 치즈 격자만 사라진다. 
그러나 한 시간 후, 이 공간으로 외부공기가 유입되면 <그림 3>에서와 같이 C로 표시된 치즈 격자들이 사라지게 된다.

모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정한다. 
입력으로 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 구하는 프로그램을 작성하시오.

첫째 줄에는 모눈종이의 크기를 나타내는 두 개의 정수 N, M (5 ≤ N, M ≤ 100)이 주어진다. 
그 다음 N개의 줄에는 모눈종이 위의 격자에 치즈가 있는 부분은 1로 표시되고, 치즈가 없는 부분은 0으로 표시된다. 
또한, 각 0과 1은 하나의 공백으로 분리되어 있다.

출력으로는 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 정수로 첫 줄에 출력한다.

8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;

public class N2638 {
    static int N;
    static int M;
    static int[][] cheese;

    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, -1, 0, 0};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        N = Integer.parseInt(stoi.nextToken());
        M = Integer.parseInt(stoi.nextToken());

        cheese = new int[N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(read.readLine());
            for(int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        int hour = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cheese[i][j] == 1) {
                    BFS(i, j);
                }
            }
        }
        System.out.println();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(cheese[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void BFS(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new Node(r, c));
        visited[r][c] = true;

        while(queue.isEmpty()) {
            Node cur = queue.poll();
            int cnt = 0;  // 외부 접촉면 개수 = 4 - cnt

            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                if(!visited[ny][nx] && cheese[ny][nx] == 1) {
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                    cnt++;
                }
            }

            if(4 - cnt >= 2) {
                cheese[cur.y][cur.x] = 0;
            }
        }
    }
}