package BOJ;

/*
넥슨의 FIFA ONLINE 4는 축구 경기 시뮬레이션을 생동감 있게 플레이할 수 있는 게임이다. 
각 선수별로 포지션이 있으며, 선수별로 능력치와 선수 가치가 존재하여 경기에 영향을 미치게 된다. 
또한 선발 선수와 후보 선수를 구분하여 선발 선수의 컨디션이 안 좋은 경우 후보 선수와 교체할 수도 있다.

FIFA ONLINE 4를 즐겨하는 주원이는 다음 과정대로 팀을 구성하면 K년 12월에 되었을 때 팀의 선발 선수 가치의 합은 얼마가 되어 있을지 궁금해 하였다.

팀은 총 11명으로, 포지션 번호는 1 이상 11 이하인 정수이다.
 
3월에 같은 포지션 중 선수 가치가 가장 높은 선수가 선발 선수가 된다. 
선수 가치가 가장 높은 선수가 여러 명 있을 경우, 그 중 아무나 선발 선수로 선택한다.
포지션에 해당하는 선수가 없을 시, 해당 포지션을 공석으로 팀을 구성한다.
 
8월에 현재 팀에 있는 선발 선수의 선수 가치는 모두 1이 떨어진다. 
선수 가치는 0보다 작아지지 않는다.
 
11월에 2의 조건대로 선발 선수를 재구성한다.
선수 N명의 포지션 번호와 선수 가치가 주어졌을 때, 1, 2, ..., K년이 될 때마다 매년 위 과정대로 새로운 팀을 구성한다. 
K년 12월에 되었을 때 만든 팀의 선발 선수 가치의 합을 구하여라.

첫 번째 줄에 선수의 수 N과 K가 공백으로 구분되어 주어진다. (0 <= N <= 1,000,000, 1 <= K <= 50,000)

두 번째 줄부터 N개의 줄에 걸쳐 각 줄에 i번째 선수의 포지션 Pi, 선수 가치 Wi가 공백으로 구분되어 주어진다. (1 <= i <= N, 1 <= Pi <= 11, 1 <= Wi 100,000)
입력으로 주어지는 수는 모두 정수이다.

K년 12월에 되었을 때 만든 팀의 선발 선수 가치의 합을 출력한다.

11 1
1 5
2 4
3 2
4 3
5 10
6 9
7 6
8 8
9 11
10 5
11 6

58
 */

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N29160 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 1; i <= 11; i++) {
            map.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer player = new StringTokenizer(read.readLine());
            int position = Integer.parseInt(player.nextToken());
            int value = Integer.parseInt(player.nextToken());

            map.get(position).add(value);
        }

        while(K-- > 0) {
            for(int i = 1; i <= 11; i++) {
                if(map.get(i).isEmpty()) continue;
                map.get(i).add(map.get(i).poll() - 1);
            }
        }

        int total = 0;
        for(int i = 1; i <= 11; i++) {
            if(map.get(i).isEmpty()) continue;
            total += map.get(i).poll();
        }

        System.out.println(total);
    }
}