package BOJ;

/*
맨 위 첫 번째 줄에 T(1 <T< 500)는 테스트케이스 수를 의미한다. 각 테스트 케이스의 첫 번째 줄에는 n이 주어지고 n은 후보자 수를 의미하며, 다음 n줄에는 순서대로 각 후보자가 받은 득표 수를 입력받는다.

후보자는 최소 2명에서 10명보다 많지 않으며, 득표 수는 50000표를 넘지 않으며, 후보자들은 분명 자기 자신을 찍기 때문에 최소 1표 이상은 받게된다.

각 테스트 케이스는 첫 번째 줄부터 순서대로 출력된다. 최다 득표자가 과반수 득표를 했을경우에는 "majority winner R", 절반 이하의 득표를 하였을 경우엔 "minority winner R"가 되며, 최다 득표자가 없을때(최다 득표자가 1명 초과일 경우)  "no winner"를 출력한다. 이때 R은 최다 득표자의 후보자 번호를 의미하며, 후보자의 번호는 각 케이스에서 1, 2, . . . , n 으로 부여된다.

4
3
10
21
10
3
20
10
10
3
10
10
10
4
15
15
15
45

majority winner 2
minority winner 1
no winner
minority winner 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N11637 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(read.readLine());

            int max = 0, sum = 0;
            for(int j = 1; j <= N; j++) {
                int vote = Integer.parseInt(read.readLine());
                map.put(j, vote);

                if(map.getOrDefault(max, 0) == vote) {
                    map.put(0, vote);
                    max = 0;
                } else if(map.getOrDefault(max, 0) < vote) {
                    max = j;
                }

                sum += vote;
                // System.out.println(max);
            }

            if(max == 0) {
                build.append("no winner\n");
            } else {
                if((float) sum / 2 < map.get(max)) {
                    build.append("majority winner " + max + "\n");
                } else {
                    build.append("minority winner " + max + "\n");
                }
            }

            map.clear();
        }

        System.out.println(build);
    }
}
