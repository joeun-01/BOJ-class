package BOJ;

/*
평면에 n개의 점이 있다. 
그중 두 개 이상의 점을 지나면서 x축 또는 y축에 평행한 직선이 몇 개인지 알아내는 프로그램을 작성하시오.

첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 
다음 n개의 줄에는 각 점의 좌표가 주어진다. 
같은 좌표가 여러 번 주어질 수 있으며, 그런 경우 서로 다른 점으로 간주한다. 
좌표는 절댓값이 231보다 작은 정수이다.

첫째 줄에 답을 출력한다.

4
0 0
10 10
0 10
10 0

4
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N2358 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        HashMap<Long, Long> xMap = new HashMap<>();
        HashMap<Long, Long> yMap = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            long x = Long.parseLong(stoi.nextToken());
            long y = Long.parseLong(stoi.nextToken());

            xMap.put(x, xMap.getOrDefault(x, 0L) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0L) + 1);
        }

        int line = 0;
        for(long key : xMap.keySet()) {
            long cnt = xMap.get(key);
            if(cnt >= 2) line++;
        }

        for(long key : yMap.keySet()) {
            long cnt = yMap.get(key);
            if(cnt >= 2) line++;
        }

        System.out.println(line);
    }
}