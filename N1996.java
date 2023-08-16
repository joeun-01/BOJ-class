package BOJ;

/*
다들 windows에서 지원하는 지뢰 찾기 게임을 한번쯤은 해 보았을 것이다. 
특히 동호는 지뢰찾기의 매니아로 알려져 있다. 
지뢰 찾기 map은 N*N의 정사각형 모양으로 각 칸에는 숫자가 들어가 있거나 지뢰가 들어가 있다. 
빈 칸에는 숫자 0이 들어있다고 생각하자.

map의 어떤 칸에 적혀 있는 숫자는, 그 칸과 인접해 있는 여덟 개의 칸 중에서 지뢰가 들어 있는 칸이 몇 개인지를 나타내 준다. 
물론 인접한 칸이 map 내부에 있는 경우에 대해서만 생각하면 된다. 
예제를 보면 더 잘 이해할 수 있을 것이다.

이번 문제는 조금 업그레이드 된 지뢰 찾기로, 한 칸에 한 개의 지뢰가 있는 것이 아니고, 한 칸에 여러 개(1 이상 9 이하)의 지뢰가 묻혀 있는 게임이다. 
따라서 map의 어떤 칸에 적혀 있는 숫자는, 그 칸과 인접해 있는 여덟 개의 칸들에 들어 있는 지뢰의 총 개수가 된다.

이미 windows 지뢰찾기 같은 것을 마스터한 영식이는, map에서 지뢰에 대한 정보만이 주어졌을 때, 영식이는 map을 완성하고 싶다고 한다. 
N과 지뢰의 위치가 주어졌을 때, 영식이를 도와서 지뢰 찾기 map을 완성하는 프로그램을 작성하시오.

첫째 줄에 N(1 ≤ N ≤ 1,000)이 주어진다.
다음 N개의 줄에는 지뢰 찾기 map에 대한 정보가 주어지는데 '.' 또는 숫자로 이루어진 문자열이 들어온다. 
'.'는 지뢰가 없는 것이고 숫자는 지뢰가 있는 경우로 그 칸의 지뢰의 개수이다. 
한 줄은 N개의 문자로 이루어져 있다.

N개의 줄에 걸쳐서 완성된 지뢰 찾기 map을 출력한다. 
지뢰는 '*'로 출력하며. 10 이상인 경우는 'M'(Many)으로 출력하면 된다. 
map은 숫자 또는 'M' 또는 '*'로만 이루어져 있어야 한다.

5
1....
..3..
.....
.4...
...9.

*4330
14*30
47730
4*M99
44M*9
 */

import java.io.*;

public class N1996 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++) {
            String str = read.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int[] r = {-1, -1, -1, 0, 0, 1, 1, 1};  // 왼쪽 위부터 시작해서 행을 오른쪽으로 쓱 훑고 내려옴
        int[] c = {-1, 0, 1, -1, 1, -1, 0, 1};

        char[][] result = new char[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] != '.') {
                    result[i][j] = '*';
                    build.append(result[i][j]);

                    continue;
                }

                int cnt = 0;
                for(int idx = 0; idx < 8; idx++) {
                    int row = i + r[idx];
                    int col = j + c[idx];

                    if(0 <= row && row < N && 0 <= col && col < N) {
                        if(map[row][col] != '.') cnt += ((int) map[row][col] - 48);
                    }
                }

                if(cnt >= 10) result[i][j] = 'M';
                else result[i][j] = (char) (cnt + 48);
                
                build.append(result[i][j]);
            }

            build.append("\n");
        }

        System.out.println(build);
    }
}