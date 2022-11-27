package BOJ;

/*
차세대 영농인 한나는 강원도 고랭지에서 유기농 배추를 재배하기로 하였다. 
농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호하는 것이 중요하기 때문에, 한나는 해충 방지에 효과적인 배추흰지렁이를 구입하기로 결심한다. 
이 지렁이는 배추근처에 서식하며 해충을 잡아 먹음으로써 배추를 보호한다. 
특히, 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있어, 그 배추들 역시 해충으로부터 보호받을 수 있다. 
한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우에 서로 인접해있는 것이다.

한나가 배추를 재배하는 땅은 고르지 못해서 배추를 군데군데 심어 놓았다. 
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. 
예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의 배추흰지렁이가 필요하다. 
0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.

입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 
그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 
두 배추의 위치가 같은 경우는 없다.

각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다.

2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5

5
1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class N1012 {
	static int width, height, num;
	static int[][] field;
	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

	static void bfs(int x, int y) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { x, y });

		while (!qu.isEmpty()) {
			x = qu.peek()[0];
			y = qu.peek()[1];

            // 시작점을 방문했다고 알려줌
			visit[y][x] = true;

			qu.poll();

			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < width && cy < height) {
                    // 배열 범위 내에서 진행
					if (!visit[cy][cx] && field[cy][cx] == 1) {
                        // 방문한 적이 없고 배추가 있는 곳이면 현재 위치를 방문했다고 알려줌
						qu.add(new int[] { cx, cy });
						visit[cy][cx] = true;
					}
				}

			}

		}
	}

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int test = Integer.parseInt(read.readLine());
        
        int i, j, k;
        for(i = 0; i < test; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine(), " ");

            width = Integer.parseInt(token.nextToken());
            height = Integer.parseInt(token.nextToken());
            num = Integer.parseInt(token.nextToken());

            field = new int[height][width];
            visit = new boolean[height][width];

            // int 배열은 0으로 초기화 안해도 처음부터 0
            for(j = 0; j < num; j++) {
                String dot = read.readLine();
                String[] dotSplit = dot.split(" ");

                field[Integer.parseInt(dotSplit[1])][Integer.parseInt(dotSplit[0])] = 1;
            }

            int count = 0;
            for (j = 0; j < height; j++) {
				for (k = 0; k < width; k++) {
					if (field[j][k] == 1 && !visit[j][k]) {
						bfs(k, j);
						count++;
					}
				}
			}

			build.append(count + "\n");
        }

        System.out.println(build);
    }
}
