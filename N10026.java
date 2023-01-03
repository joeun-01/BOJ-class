package BOJ;

/*
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 
따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 
그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 
또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 
하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
둘째 줄부터 N개 줄에는 그림이 주어진다.

적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

4 3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N10026 {
    static char[][] paint;
    static int n;

    static Queue<String> queue = new LinkedList<>(); 
    static boolean[][] visited;

    static int r[] = {-1, 1, 0, 0};  // 상하좌우
    static int c[] = {0, 0, -1, 1};  // 상하좌우

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        n = Integer.parseInt(read.readLine());

        paint = new char[n][n];

        for(int i = 0; i < n; i++) {
            String row = read.readLine();

            for(int j = 0; j < n; j++) {
                paint[i][j] = row.charAt(j);    
            }
        }

        // 정상인 경우
        int count = 0;
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    normal(i, j);
                    count++;
                } 
            }
        }

        build.append(count + " ");

        // 적록색약인 경우
        count = 0;
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    unnormal(i, j);
                    count++;
                } 
            }
        }

        build.append(count);

        System.out.println(build);

    }

    public static void normal(int i, int j) {
        char color = paint[i][j];

        queue.add(i + " " + j);
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            StringTokenizer node = new StringTokenizer(queue.poll());
            
            int row = Integer.parseInt(node.nextToken());
            int column = Integer.parseInt(node.nextToken());

            for(int k = 0; k < 4; k++) {
                int nr = row + r[k];
                int nc = column + c[k];

                if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                    if(!visited[nr][nc] && paint[nr][nc] == color) {
                        queue.add(nr + " " + nc);
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }

    public static void unnormal(int i, int j) {
        char color = paint[i][j];

        queue.add(i + " " + j);
        visited[i][j] = true;

        if(color == 'R' || color == 'G') {
            while(!queue.isEmpty()) {
                StringTokenizer node = new StringTokenizer(queue.poll());
                
                int row = Integer.parseInt(node.nextToken());
                int column = Integer.parseInt(node.nextToken());

                for(int k = 0; k < 4; k++) {
                    int nr = row + r[k];
                    int nc = column + c[k];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if(!visited[nr][nc] && (paint[nr][nc] == 'R' || paint[nr][nc] == 'G')) {
                            queue.add(nr + " " + nc);
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        } else {
            while(!queue.isEmpty()) {
                StringTokenizer node = new StringTokenizer(queue.poll());
                
                int row = Integer.parseInt(node.nextToken());
                int column = Integer.parseInt(node.nextToken());

                for(int k = 0; k < 4; k++) {
                    int nr = row + r[k];
                    int nc = column + c[k];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if(!visited[nr][nc] && paint[nr][nc] == color) {
                            queue.add(nr + " " + nc);
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
    }
}
