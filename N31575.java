package BOJ;

/*
전날에 비해 비트코인의 시세가 백만원이나 오른 어느 아침, 진우는 거래소에 가서 비트코인을 매도하려고 한다. 
현재 비트코인의 시세가 점점 떨어지고 있기 때문에 진우는 최대한 빨리 거래소에 가야 한다.

도시는 가로 N, 세로 M 크기의 격자 모양으로 이루어졌다. 
진우는 북서쪽 끝에 있고 거래소는 남동쪽 끝에 있다. 
도시의 일부 구역은 공터 또는 도로라서 진우가 지나갈 수 있지만, 어떤 구역은 건물이 있어서 진우가 갈 수 없다.

진우는 최대한 빨리 거래소에 가야 하므로, 동쪽(오른쪽) 또는 남쪽(아래쪽)으로만 이동하여 거래소로 도착할 수 있어야 한다. 
진우를 도와 거래소로 갈 수 있는지 구하는 프로그램을 작성하여라. 
진우의 현재 위치가 거래소일 수 있다.

첫 번째 줄에 도시의 가로 크기 N과 세로 크기 M (1 <= N, M <= 300)이 주어진다.

두 번째 줄부터 M개의 줄에는 도시의 형태를 나타내는 N개의 정수가 공백을 사이에 두고 주어진다. 
각 칸이 1인 경우 진우가 갈 수 있는 칸을 의미하고 0인 경우 진우가 갈 수 없는 칸을 의미한다.

왼쪽 위의 끝 칸과 오른쪽 아래의 끝 칸은 모두 1이다.

첫 번째 줄에 진우가 거래소로 갈 수 있으면 Yes를, 그렇지 않으면 No를 출력한다.

5 4
1 1 1 1 1
0 1 0 0 1
1 0 0 0 1
0 0 0 1 1

Yes
*/

import java.io.*;
import java.util.*;

public class N31575 {
    public static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[][] city = new int[M][N];
        for(int i = 0; i < M; i++) {
            stoi = new StringTokenizer(read.readLine());

            for(int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(stoi.nextToken());
            }
        }

        if(N == 1 && M == 1) {
            System.out.println("Yes");
            System.exit(0);
        }

        int[] moveRow = {0, 1};
        int[] moveCol = {1, 0};

        Queue<Node> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[M][N];

        queue.add(new Node(0, 0));
        isVisited[0][0] = true;

        boolean canReach = false;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int row = node.row;
            int col = node.col;

            for(int i = 0; i < 2; i++) {
                int nextRow = row + moveRow[i];
                int nextCol = col + moveCol[i];

                if(nextRow >= M || nextCol >= N) continue;

                if(!isVisited[nextRow][nextCol] && city[nextRow][nextCol] == 1) {
                    queue.add(new Node(nextRow, nextCol));
                    isVisited[nextRow][nextCol] = true;

                    if(nextRow == M - 1 && nextCol == N - 1) {
                        canReach = true;
                        break;
                    }
                }
            }
        }

        if(canReach) System.out.print("Yes");
        else System.out.print("No");
    }
}