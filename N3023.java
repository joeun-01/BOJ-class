package BOJ;

/*
유명한 마술사인 이민혁이 사용하는 카드의 뒷 면은 모두 자신이 디자인한 카드이다.
민혁이는 카드 뒷 면 전체를 디자인하지 않고, 왼쪽 위 1/4만 디자인한다. 
그 다음 대칭시켜 오른쪽 위를 만들고, 다시 대칭시켜서 아래 부분을 모두 만든다.

이렇게 대칭시켜서 전체를 디자인 한 이후에는, 마술하는데 사용하기 위한 의도된 에러를 넣는다. 
에러는 원래 '#'이어야 하는 칸을 '.'로 바꾸거나 '.'이어야 하는 칸을 '#'로 바꾸는 것이다.

왼쪽 위의 디자인과 에러의 위치가 주어졌을 때, 카드 뒷 면 전체 디자인을 구하는 프로그램을 작성하시오.
아래 그림은 민혁이의 카드의 예시이다. (회색 칸은 에러이다)

첫째 줄에 왼쪽 위 부분의 행의 개수 R과 열의 개수 C가 주어진다. (1 ≤ R, C ≤ 50)
다음 R개 줄에는 C개의 문자 '.' 또는 '#'가 주어진다.
마지막 줄에는 에러의 위치 A와 B가 주어진다. (1 ≤ A ≤ 2R, 1 ≤ B ≤ 2C)

카드 뒷 면 전체 디자인을 총 2R개 줄에 걸쳐서 출력한다. 
각 줄은 2C개의 문자로 이루어져 있어야 한다.

2 2
#.
.#
3 3

#..#
.##.
.#..
#..#
 */

import java.io.*;
import java.util.StringTokenizer;

public class N3023 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer matrix = new StringTokenizer(read.readLine());
        int R = Integer.parseInt(matrix.nextToken());
        int C = Integer.parseInt(matrix.nextToken());

        int row = 2 * R, col = 2 * C;

        char[][] card = new char[row][col];
        for(int i = 0; i < R; i++) {
            String str = read.readLine();
            for(int j = 0; j < C; j++) {
                card[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = C - 1; j >= 0; j--) {
                card[i][col - (j + 1)] = card[i][j];
            }
        }

        for(int i = R - 1; i >= 0; i--) {
            for(int j = 0; j < col; j++) {
                card[row - (i + 1)][j] = card[i][j];
            }
        }

        StringTokenizer error = new StringTokenizer(read.readLine());
        int A = Integer.parseInt(error.nextToken()) - 1;
        int B = Integer.parseInt(error.nextToken()) - 1;

        if(card[A][B] == '#') card[A][B] = '.';
        else card[A][B] = '#';

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(card[i][j]);
            }
            System.out.println();
        }
    }
}