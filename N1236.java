/*
영식이는 직사각형 모양의 성을 가지고 있다. 
성의 1층은 몇 명의 경비원에 의해서 보호되고 있다. 
영식이는 모든 행과 모든 열에 한 명 이상의 경비원이 있으면 좋겠다고 생각했다.

성의 크기와 경비원이 어디있는지 주어졌을 때, 몇 명의 경비원을 최소로 추가해야 영식이를 만족시키는지 구하는 프로그램을 작성하시오.

첫째 줄에 성의 세로 크기 N과 가로 크기 M이 주어진다. 
N과 M은 50보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에는 성의 상태가 주어진다. 
성의 상태는 .은 빈칸, X는 경비원이 있는 칸이다.

첫째 줄에 추가해야 하는 경비원의 최솟값을 출력한다.

4 4
....
....
....
....

4
 */

import java.io.*;
import java.util.StringTokenizer;

public class N1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        char[][] castle = new char[N][M];
        
        boolean[] row = new boolean[N];
        boolean[] col = new boolean[M];
        for(int i = 0; i < N; i++) {
            String rowStr = read.readLine();

            for(int j = 0; j < M; j++) {
                castle[i][j] = rowStr.charAt(j);

                if(castle[i][j] == 'X') {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        int rowCnt = 0;
        for(int i = 0; i < N; i++) {
            if(!row[i]) rowCnt++;
        }

        int colCnt = 0;
        for(int i = 0; i < M; i++) {
            if(!col[i]) colCnt++;
        }

        System.out.println(Math.max(rowCnt, colCnt));
    }
}