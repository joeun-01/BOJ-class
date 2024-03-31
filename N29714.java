package BOJ;

/*
브실이는 더위를 식히기 위해 구슬 아이스크림을 만들어 먹는다. 
처음에 구슬 아이스크림에는 아이스크림 구슬이 N개 들어 있으며, 각 구슬의 색깔은 1 이상 10^9 이하의 정수로 표현된다.

브실이는 Q번의 과정을 거쳐 아이스크림을 먹는다. 
i번째 과정은 떠먹을 구슬의 목록 Ai와 부어 넣을 구슬의 목록 Bi로 표현된다. 
브실이는 먼저 Ai에 주어진 구슬들이 현재 아이스크림에 모두 있는지 확인한다. 
같은 색 구슬이 여러 번 주어지면 그 수만큼 아이스크림에 있어야 하며, 목록 Ai가 비어있는 경우에는 아이스크림에 구슬이 모두 있는 것으로 간주한다. 
만약 아이스크림에 구슬들이 모두 있다면 구슬들을 먹어 치우고 목록 Bi에 있는 구슬들을 부어 넣는다. 
아이스크림에 없는 구슬이 적어도 하나 있다면 아무것도 하지 않는다.

브실이가 아이스크림을 다 먹은 후 구슬 아이스크림의 모습을 출력하자!

첫 번째 줄에 처음 아이스크림의 구슬 수 N이 주어진다. (1 <= N <= 200,000)
두 번째 줄에 각 구슬의 색깔을 나타내는 정수 N개가 공백으로 구분되어 주어진다.
세 번째 줄에 브실이가 아이스크림을 먹는 횟수 Q가 주어진다. (1 <= Q <= 200,000) 

네 번째 줄부터 Q번의 과정에 대한 정보가 주어진다. 
i번째 정보의 첫 번째 줄에는 Ai의 구슬 개수 ai, 그리고 각 구슬의 색깔을 나타내는 ai개의 정수가 공백으로 구분되어 주어진다. 
i번째 정보의 두 번째 줄에는 Bi의 구슬 개수 bi, 그리고 Bi의 각 구슬의 색깔을 나타내는 bi개의 정수가 공백으로 구분되어 주어진다. (1 <= i <= Q, 0 <= ai, bi <= 200,000) 

ai의 합과 bi의 합은 각각 200,000 이하이다.

첫 번째 줄에 아이스크림을 다 먹은 후 아이스크림의 구슬 개수 M을 출력한다.
두 번째 줄에 아이스크림의 각 구슬의 색깔을 나타내는 M$의 정수를 공백으로 구분하여 출력한다. 
M = 0인 경우 두 번째 줄에 아무것도 출력하지 않는다.

각 구슬의 색깔을 어떤 순서로 출력해도 정답으로 인정된다.

6
1 3 3 5 5 5
3
1 3
2 4 4
2 3 3
1 4
2 5 5
1 5

6
1 3 4 4 5 5
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N29714 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < N; i++) {
            int color = Integer.parseInt(stoi.nextToken());
            map.put(color, map.getOrDefault(color, 0) + 1);
        }
    
        int Q = Integer.parseInt(read.readLine());
        for(int i = 0; i < Q; i++) {
            StringTokenizer in = new StringTokenizer(read.readLine());
            int A = Integer.parseInt(in.nextToken());

            HashMap<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < A; j++) {
                int color = Integer.parseInt(in.nextToken());
                temp.put(color, temp.getOrDefault(color, 0) + 1);
            }

            boolean canEat = true;
            for(int color : temp.keySet()) {
                int cnt = map.getOrDefault(color, 0);

                if(cnt < temp.get(color)) {
                    canEat = false;
                    break;
                }
            }
            
            StringTokenizer out = new StringTokenizer(read.readLine());
            if(!canEat) continue;

            for(int color : temp.keySet()) {
                map.put(color, map.get(color) - temp.get(color));
                if(map.get(color) == 0) map.remove(color);
            }

            int B = Integer.parseInt(out.nextToken());

            for(int j = 0; j < B; j++) {
                int fill = Integer.parseInt(out.nextToken());
                map.put(fill, map.getOrDefault(fill, 0) + 1);
            }
        }


        int sum = 0;
        for(int color : map.keySet()) {
            int cnt = map.get(color);
            sum += cnt;

            for(int i = 0; i < cnt; i++) {
                build.append(color).append(" ");
            }
        }

        build.insert(0, sum + "\n");
        System.out.print(build);
    }
}