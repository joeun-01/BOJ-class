package BOJ;

/*
당신은 사탕 공장의 주인이다. 
날마다, 당신은 J개의 사탕을 가게에 보내기 위해 상자에 포장해야 한다.

당신은 크기가 다른 상자 N개를 가지고 있다. 
당신은 편리를 위해 상자를 최소한으로 쓰려고 한다. (박스를 다 채울 필요는 없다. 일부분만 채워도 된다.)

당신이 공장에서 나오는 사탕의 개수와 각 상자의 크기를 입력받고, 상자를 최소한으로 쓸 때의 사용되는 상자 개수를 출력하는 프로그램을 작성하라. 
사탕들을 포장할 공간은 충분하다는 것이 보장된다.

첫 번째 줄에는 테스트 케이스의 개수 T (1 ≤ T ≤ 10)가 주어진다. 
각각의 테스트 케이스는 아래 형식을 따른다.

테스트 케이스의 첫 번째 줄에는 사탕의 개수 J와 상자의 개수 N이 주어진다. (1 ≤ J, N ≤ 1,000)

다음 N개의 줄에는 각각 줄마다 i번째 상자의 세로 길이 Ri 그리고 가로 길이 Ci가 주어진다. 
상자의 크기는 다른 상자의 크기와 똑같을 수도 있다. 
상자에는 Ri * Ci보다 더 많은 사탕을 포장할 수 없다. (1 ≤ Ri, Ci ≤ 10,000)

출력은 T개의 줄로 이루어진다. 
각각의 줄마다 i번째 테스트 케이스에서 최소한의 상자 개수를 출력하여야 한다.

1
20 5
3 4
2 5
1 8
3 3
2 5

2
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11256 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int J = Integer.parseInt(stoi.nextToken());
            int N = Integer.parseInt(stoi.nextToken());

            int[] boxList = new int[N];
            for(int j = 0; j < N; j++) {
                StringTokenizer box = new StringTokenizer(read.readLine());
                int row = Integer.parseInt(box.nextToken());
                int col = Integer.parseInt(box.nextToken());

                boxList[j] = row * col;
            }

            Arrays.sort(boxList);

            int cnt = 0;
            for(int j = N - 1; j >= 0; j--) {
                J -= boxList[j];
                cnt++;

                if(J <= 0) break;
            }

            build.append(cnt).append("\n");
        }

        System.out.println(build);
    }
}