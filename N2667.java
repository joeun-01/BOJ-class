package BOJ;

/*
<그림 1>과 같이 정사각형 모양의 지도가 있다. 
1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
대각선상에 집이 있는 경우는 연결된 것이 아니다. 
<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class N2667 {
    static int num;
    static int count;

    static int[][] table;
    static boolean[][] visited;

    static ArrayList<Integer> sort = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(read.readLine());
        table = new int[num][num]; 
        visited = new boolean[num][num];

        for(int i = 0; i < num; i++) {
            String row = read.readLine();

            for(int j = 0; j < num; j++) {
                table[i][j] = Integer.parseInt(row.substring(j, j + 1));
            }
        }   

        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                if(!visited[i][j] && table[i][j] == 1) {
                    visited[i][j] = true;
                    count = 1;

                    DFS(i, j);
                    sort.add(count);
                }
            }
        }

        System.out.println(sort.size());

        sort.sort(null);

        for(int i = 0; i < sort.size(); i++) {
            System.out.println(sort.get(i));
        }
    }

    public static void DFS(int row, int column) {
        // 우 왼 하 상
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};

        for(int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = column + dc[i];

            if(nr >= 0 && nc >= 0 && nr < num && nc < num){
                if(table[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    count++;

                    DFS(nr, nc);
                }
            }
        }
    }
}
