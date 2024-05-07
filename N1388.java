package BOJ;

/*
형택이는 건축가이다. 지금 막 형택이는 형택이의 남자 친구 기훈이의 집을 막 완성시켰다. 
형택이는 기훈이 방의 바닥 장식을 디자인했고, 이제 몇 개의 나무 판자가 필요한지 궁금해졌다. 
나무 판자는 크기 1의 너비를 가졌고, 양수의 길이를 가지고 있다. 
기훈이 방은 직사각형 모양이고, 방 안에는 벽과 평행한 모양의 정사각형으로 나누어져 있다.

이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다. 
만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고, 두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.

기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력하는 프로그램을 작성하시오.

첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다. 
둘째 줄부터 N개의 줄에 M개의 문자가 주어진다. 
이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다. 
N과 M은 50 이하인 자연수이다.

첫째 줄에 문제의 정답을 출력한다.

4 4
----
----
----
----

4
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1388 {
    public static char[][] room;
    public static boolean[][] isChecked;
    static int N, M;

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] agrs) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        N = Integer.parseInt(stoi.nextToken());
        M = Integer.parseInt(stoi.nextToken());

        room = new char[N][M];
        for(int i = 0; i < N; i++) {
            String row = read.readLine();

            for(int j = 0; j < M; j++) {
                room[i][j] = row.charAt(j);
            }
        }

        int cnt = 0;
        isChecked = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(isChecked[i][j]) continue;

                BFS(i, j);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void BFS(int row, int col) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(row, col));
        isChecked[row][col] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;

            if(room[r][c] == '|') {
                if(r - 1 >= 0) {
                    if(!isChecked[r - 1][c] && room[r - 1][c] == '|') {
                        queue.add(new Node(r - 1, c));
                        isChecked[r - 1][c] = true;
                    }
                }

                if(r + 1 < N) {
                    if(!isChecked[r + 1][c] && room[r + 1][c] == '|') {
                        queue.add(new Node(r + 1, c));
                        isChecked[r + 1][c] = true;
                    }
                }
            } else if(room[r][c] == '-') {      
                if(c - 1 >= 0) {
                    if(!isChecked[r][c - 1] && room[r][c - 1] == '-') {
                        queue.add(new Node(r, c - 1));
                        isChecked[r][c - 1] = true;
                    }
                }
                
                if(c + 1 < M) {
                    if(!isChecked[r][c + 1] && room[r][c + 1] == '-') {
                        queue.add(new Node(r, c + 1));
                        isChecked[r][c + 1] = true;
                    }
                }
            }
        }
    }
}