package BOJ;

/*
상근이는 카약 대회를 개최했다. 
대회는 전세계에 생중계되고, 위성이 경기장 전체를 촬영하고 있다. 
상근이는 위성 사진을 바탕으로 실시간 순위를 계산하는 프로그램을 만들려고 한다.

위성 사진은 R행 C열이다. 
모든 줄의 첫 번째 글자는 'S'이고 출발선을 의미한다. 
또, 마지막 글자는 'F'이고 이것은 결승선을 의미한다. 
대회에 참가한 팀은 총 9팀이고, 각 팀은 1부터 9까지 번호가 매겨져 있다. 
카약은 항상 열에 대해 연속하는 세 칸을 차지하며, 카약 번호로 표시한다. 
마지막으로 물은 '.'로 나타나 있다.

팀의 순위는 결승선으로부터 떨어진 거리로 측정한다. 
가까울수록 순위가 높다. 
만약, 두 팀이 결승선과 떨어진 거리가 같다면, 같은 등수이다.

첫째 줄에 R과 C가 주어진다. 
다음 R개 줄에는 '.', 'S', 'F', '1'~'9'로 이루어진 위성 지도가 주어진다. 
한 줄에는 최대 한 개의 카약만 있고, 위성 사진에 있는 카약은 항상 9개이다. (10 ≤ R, C ≤ 50)

출력은 총 9줄을 해야 한다. i번째 줄에는 i번 팀의 등수를 출력한다. (i=1~9)

10 10
S.....111F
S....222.F
S...333..F
S..444...F
S.555....F
S666.....F
S.777....F
S..888...F
S...999..F
S........F

1
2
3
4
5
6
5
4
3
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2890 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int R = Integer.parseInt(stoi.nextToken());
        int C = Integer.parseInt(stoi.nextToken());

        char[][] map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String str = read.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int g = 1;
        int[] grade = new int[10];
        for(int j = C - 2; j > 0; j--) {
            boolean fix = false;
            for(int i = 0; i < R; i++) {
                if(map[i][j] != '.') {
                    // 첫 순위를 저장
                    int team = (int) map[i][j] - 48;
                    if(grade[team] == 0) {
                        grade[team] = g;
                        fix = true;
                    }
                }
            }

            if(fix) g++; 
        }

        for(int i = 1; i <= 9; i++) {
            System.out.println(grade[i]);
        }
    }
}