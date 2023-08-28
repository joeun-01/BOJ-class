package BOJ;

/*
상근이와 친구들은 MT에 가서 아래 설명과 같이 재미있는 게임을 할 것이다.
각 플레이어는 1이상 100 이하의 정수를 카드에 적어 제출한다. 
각 플레이어는 자신과 같은 수를 쓴 사람이 없다면, 자신이 쓴 수와 같은 점수를 얻는다. 
만약, 같은 수를 쓴 다른 사람이 있는 경우에는 점수를 얻을 수 없다.

상근이와 친구들은 이 게임을 3번 했다. 
각 플레이어가 각각 쓴 수가 주어졌을 때, 3번 게임에서 얻은 총 점수를 구하는 프로그램을 작성하시오.

첫째 줄에 참가자의 수 N이 주어진다. (2 ≤ N ≤ 200) 
둘째 줄부터 N개 줄에는 각 플레이어가 1번째, 2번째, 3번째 게임에서 쓴 수가 공백으로 구분되어 주어진다.

각 플레이어가 3번의 게임에서 얻은 총 점수를 입력으로 주어진 순서대로 출력한다.

5
100 99 98
100 97 92
63 89 63
99 99 99
89 97 98

0
92
215
198
89
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N5533 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        StringTokenizer[] number = new StringTokenizer[N];
        for(int i = 0; i < N; i++) {
            number[i] = new StringTokenizer(read.readLine());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int score[] = new int[N];
        for(int i = 0; i < 3; i++) {
            int[] temp = new int[N];
            for(int j = 0; j < N; j++) {
                int round = Integer.parseInt(number[j].nextToken());

                temp[j] = round;
                map.put(round, map.getOrDefault(round, 0) + 1);
            }

            for(int j = 0; j < N; j++) {
                if(map.get(temp[j]) == 1) score[j] += temp[j];
            }

            map.clear();
        }

        for(int i = 0; i < N; i++) {
            System.out.println(score[i]);
        }
    }
}
