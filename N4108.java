package BOJ;

/*
07년 개봉한 영화 '지뢰찾기'는 지뢰의 수를 조사해야하는 요원 예슬의 이야기를 다룬 영화다.

정보기관의 요원이었던 예슬은 심심해서 컴퓨터로 지뢰찾기를 켰다가 인사팀에 걸려 지뢰제거팀으로 좌천된다. 
좌천된 예슬에게 처음 부여된 임무는 지뢰 제거도 아닌 지뢰 수 조사!
예슬의 첫 임무에서 교육요원으로 배정된 다민은 "처음 건 무조건 안 터져." 라고 말하며 거침없이 땅을 팠지만 지뢰가 터져 얄짤없이 사망하고 만다. 
지뢰 밭에 혼자 남겨진 예슬! 과연 임무를 마치고 안전하게 돌아갈 수 있을 것인가!

지뢰밭은 R X C개의 칸으로 이루어져있다.
예슬이 발을 딛는 구역 중에서 일부 칸에는 지뢰가 들어있고 나머지는 모두 비어있다. 
예슬은 모든 비어있는 칸마다 인접해 있는 지뢰의 개수를 세서 적어야 한다.

선이나 점을 공유하고 있는 두개의 칸을 인접해있다고 정의한다. 
즉, 모든 칸은 최대 8개의 인접한 칸을 갖고 있다. (상, 하, 좌, 우, 4개의 대각선칸)

여러 개의 테스트 케이스가 제공된다.
각 테스트 케이스의 첫 번째 줄에는 행과 열의 수를 표현하는 두 개의 정수 R,C가 입력된다. (1 ≤ R,C ≤ 100)
이후 입력되는 R개의 줄은 C개의 문자로 이루어져있다. 
각 문자는 지뢰를 표현하는 '*'과 빈 공간을 표현하는 '.' 이다.
0 0이 입력되면 종료된다.

C개의 문자들이 포함된 R개의 줄을 출력한다. 
단, 모든 '.' 대신 인접한 칸에 위치한 지뢰의 수로 변경해 출력한다. '*' 칸은 그대로 출력한다.

문자 사이에 공백이나 줄 사이에 공백 줄이 있어선 안 된다.

3 2
..
.*
..
5 5
*.*.*
..*..
*****
.....
..**.
0 0

11
1*
11
*3*3*
36*63
*****
24553
01**1
 */

import java.io.*;
import java.util.StringTokenizer;

public class N4108 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int R = Integer.parseInt(stoi.nextToken());
            int C = Integer.parseInt(stoi.nextToken());

            if(R == 0 && C == 0) break;

            char[][] map = new char[R][C];
            for(int i = 0; i < R; i++) {
                String row = read.readLine();
                for(int j = 0; j < C; j++) {
                    map[i][j] = row.charAt(j);
                }
            }

            char[][] result = new char[R][C];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(map[i][j] == '*') result[i][j] = '*';
                    else {
                        int cnt = 0;
                        for(int k = 0; k < 8; k++) {
                            int row = i + r[k];
                            int col = j + c[k];

                            if(row < 0 || row >= R || col < 0 || col >= C) continue;

                            if(map[row][col] == '*') cnt++;
                        }

                        result[i][j] = (char) (cnt + 48) ;
                    }

                    build.append(result[i][j]);
                }

                build.append("\n");
            }
        }

        System.out.println(build);
    }
}
