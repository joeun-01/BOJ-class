package BOJ;

/*
정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 
섬의 개수를 세는 프로그램을 작성하시오.

한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다. 

두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 
지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. 
w와 h는 50보다 작거나 같은 양의 정수이다.

둘째 줄부터 h개 줄에는 지도가 주어진다. 
1은 땅, 0은 바다이다.

입력의 마지막 줄에는 0이 두 개 주어진다.

각 테스트 케이스에 대해서, 섬의 개수를 출력한다.

1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0

0
1
1
3
1
9
 */

import java.io.*;
import java.util.*;

public class N4963 {
    public static class Land {
        int r;
        int c;

        public Land(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int[][] map;
    public static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int w = Integer.parseInt(stoi.nextToken());
            int h = Integer.parseInt(stoi.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            for(int i = 0; i < h; i++) {
                stoi = new StringTokenizer(read.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(stoi.nextToken());
                }
            }

            isVisited = new boolean[h][w];

            int cnt = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1) {
                        if(isVisited[i][j]) {
                            continue;
                        } else {
                            BFS(i, j, h, w);
                            cnt++;
                        }
                    } else {
                        isVisited[i][j] = true;
                        continue;
                    }
                }
            }

            build.append(cnt).append("\n");
        }

        System.out.println(build);
    }

    public static int[] rowMove = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] colMove = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void BFS(int startRow, int startCol, int h, int w) {
        Queue<Land> queue = new LinkedList<>();

        queue.add(new Land(startRow, startCol));
        isVisited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            Land node = queue.poll();

            int r = node.r;
            int c = node.c;

            for(int i = 0; i < 8; i++) {
                int nextR = r + rowMove[i];
                int nextC = c + colMove[i];

                if(nextR < 0 || nextR >= h || nextC < 0 || nextC >= w) {
                    continue;
                }

                if(!isVisited[nextR][nextC] && map[nextR][nextC] == 1) {
                    queue.add(new Land(nextR, nextC));
                    isVisited[nextR][nextC] = true;
                }
            }
        }
    }
}