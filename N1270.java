package BOJ;

/*
드디어 전쟁은 전면전이 시작되었고, 서로 땅을 따먹기 시작했다.
현재 여러 지역은 한창 전쟁이 벌어지고 있는 상황인데, 어느 지역은 거의 전쟁이 마무리 단계로 가고 있다.
하지만 당신은 군대를 보낼 때 적군을 혼란시키기 위해서 우리 나라의 군대라는걸 표시하지 않고, 군대의 번호로 표시했다.

어느 땅에서 한 번호의 군대의 병사가 절반을 초과한다면 그 땅은 그 번호의 군대의 지배하에 놓이게 된다.

이때, 각 땅들을 지배한 군대의 번호를 출력하여라. 
만약, 아직 전쟁이 한창중인 땅이라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.

첫째 줄에는 땅의 개수 n(n<=200)이 주어진다. 
그리고 두 번째 줄에서 n+1번째 줄에는 제일 처음에 숫자 Ti(i번째 땅의 병사수, Ti<=100,000)와, Ti개의 숫자 (각각 병사의 군대 번호)가 주어진다. 
i번째 땅의 j번째 병사 번호 Nij가 주어진다. ( | Nij | <= 2^31 )

첫째 줄에는 각각의 땅의 상태를 순서대로 출력한다. 
만약 땅이 지배가 되어있다면 그 지배한 병사의 번호를 출력하고, 아니라면 “SYJKGW”을 쌍 따옴표 없이 출력한다.

4
10 1 2 3 1 2 3 1 2 3 1
5 1 1 1 2 2
6 10 10 2 10 10 2
6 1 1 1 2 2 2 

SYJKGW
1
10
SYJKGW
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        HashMap<Long, Long> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            long soldier = Long.parseLong(stoi.nextToken());
            
            for(int j = 0; j < soldier; j++) {
                long num = Long.parseLong(stoi.nextToken());
                map.put(num, map.getOrDefault(num, 0L) + 1);
            }

            long max = 0, maxKey = 0;
            long sum = 0;
            for(long key : map.keySet()) {
                long soldiers = map.get(key);

                sum += soldiers;
                if(soldiers > max) {
                    max = soldiers;
                    maxKey = key;
                }
            }

            if(max > sum / 2) build.append(maxKey).append("\n");
            else build.append("SYJKGW").append("\n");

            map.clear();
        }

        System.out.println(build);
    }
}