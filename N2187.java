package BOJ;

/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
각각의 수들은 붙어서 입력으로 주어진다.

첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 
항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

4 6
101111
101010
101011
111011

15
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2187 {
    static int table[][];
    static int row;
    static int column;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(read.readLine());

        row = Integer.parseInt(input.nextToken());
        column = Integer.parseInt(input.nextToken());

        table = new int[row][column];

        for(int i = 0; i < row; i++) {
            String rowString = read.readLine();

            for(int j = 0; j < column; j++) {
                table[i][j] = Integer.parseInt(rowString.substring(j, j + 1));
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                System.out.print(table[i][j]);
            }

            System.out.println();
        }        
    }

    public static void BFS(int rs, int re, int cs, int ce) {
        Queue<String> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][column];
        int[][] depth = new int[row][column];

        queue.add(0 + " " + 0);
        visited[0][0] = true;
        depth[0][0] = 0;

        while(!queue.isEmpty()) {
            StringTokenizer node = new StringTokenizer(queue.poll());
            
            int row = Integer.parseInt(node.nextToken());
            int column = Integer.parseInt(node.nextToken());

            if(row > 0) {
                
            }
        }
    }
}
