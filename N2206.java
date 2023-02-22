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

        int min = BFS();
        if(min == 0) min = Integer.MAX_VALUE;

        // System.out.println(min);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 1) { 
                    if(!check(j, i)) continue;

                    graph[i][j] = 0;

                    int dist = BFS();
                    if(dist != 0) min = Math.min(min, BFS());
                    // System.out.println(min);

                    graph[i][j] = 1;
                }
            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static int BFS() {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M]; 
        int[][] dist = new int[N][M];

        queue.add(new Coordinate(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];               

                if(x >= 0 && x < M && y >= 0 && y < N) {                

                    if(!visited[y][x] && graph[y][x] == 0) {
                        queue.add(new Coordinate(x, y));
                        visited[y][x] = true;
                        dist[y][x] = dist[now.y][now.x] + 1;

                        if((y == N - 1) && (x == M - 1)) {
                            return dist[y][x];
                        }
                    }
                }
            }
        }

        return dist[N - 1][M - 1];
    }
    
    public static boolean check(int x, int y) {
        int cnt = 0;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];               

            if(nx >= 0 && nx < M && ny >= 0 && ny < N) {                
                if(graph[ny][nx] == 0) cnt++;
            }
        }

        if(cnt < 2) return false;
        else return true; 
    }
}
