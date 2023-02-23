package BOJ;

/*
N×M의 행렬로 표현되는 맵이 있다. 
맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 
당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 
최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.
한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 
다음 N개의 줄에 M개의 숫자로 맵이 주어진다. 
(1, 1)과 (N, M)은 항상 0이라고 가정하자.

첫째 줄에 최단 거리를 출력한다. 
불가능할 때는 -1을 출력한다.

6 4
0100
1110
1000
0000
0111
0000

15
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class N2206 {
    static int[][] graph;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        N = Integer.parseInt(stoi.nextToken());
        M = Integer.parseInt(stoi.nextToken());

        graph = new int[N][M];

        // 맵 정보 입력하기
        for(int i = 0; i < N; i++) {
            String row = read.readLine();

            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }

        if(N == 1 && M == 1){
            System.out.println(1);
            System.exit(0);
        }

        int result = BFS();

        if(result == -1) System.out.println(-1);
        else System.out.println(result);
    }

    static class Coordinate {
        int x;
        int y;
        int crash;

        public Coordinate(int x, int y, int crash) {
            this.x = x;
            this.y = y;
            this.crash = crash;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    /*
        visited를 3중 배열로 만들어서,
        벽을 부수고 탐색하는 경우와 부수지 않고 탐색하는 경우를 따로 처리
        visited[n][m][0]은 한 번도 부수지 않은 경우, visited[n][m][1]은 한 번 부순 경우
     */
    public static int BFS() {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2]; 
        int[][] dist = new int[N][M];

        queue.add(new Coordinate(0, 0, 0));
        visited[0][0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];               

                if(x >= 0 && x < M && y >= 0 && y < N) {   
                    if(graph[y][x] == 0) {             
                        // 다음 칸이 벽이 아닐 때
                        if(!visited[y][x][now.crash]) {
                            visited[y][x][now.crash] = true;
                            dist[y][x] = dist[now.y][now.x] + 1;

                            queue.add(new Coordinate(x, y, now.crash));
                        }
                    } else {
                        // 다음 칸이 벽일 때
                        if(now.crash == 0 && !visited[y][x][1]) {
                            visited[y][x][1] = true;
                            dist[y][x] = dist[now.y][now.x] + 1;

                            queue.add(new Coordinate(x, y, 1));
                        }
                    }    

                    if((y == N - 1) && (x == M - 1)) {
                        return dist[y][x];
                    }
                }
            }
        }

        return -1;
    }
}
