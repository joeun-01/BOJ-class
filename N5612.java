package BOJ;

/*
상근이는 남산1호터널의 입구와 출구에서 1분에 통과하는 차량의 수를 조사했다. 
이때, 터널에 차량이 가장 많이 있었을 때, 몇 대 있었는지 구하는 프로그램을 작성하시오.

첫째 줄에 조사한 시간 n이 주어진다. 
둘째 줄에는 조사를 시작할 때, 터널 안에 들어있는 차량의 수 m이 주어진다. 
다음 n개 줄의 i번째 줄(i = 1 ~ n)의 정보는 조사를 시작한지 (i-1)분이 경과한 시점부터 i분 경과할 때 까지 1분에 입구를 통과한 차의 수와 출구를 통과한 차의 수이다. 
n은 10000보다 작거나 같고, 1분에 통과하는 차량의 수는 100이하이다.

조사 시작하고 j분이 지난 시점 (j = 0~n)에서 터널 안에 있는 차량의 수를 Sj라고 하자. 
이때, Sj의 최댓값을 출력한다. 
만약, 터널 안에 있는 차량의 수가 0보다 작은 경우가 한 번 이라도 발생한다면 0을 출력한다.

3
2
2 3
2 3
4 1

3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N5612 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        int start = Integer.parseInt(read.readLine());

        int total = start, max = start;
        boolean zero = false;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            int in = Integer.parseInt(stoi.nextToken());
            int out = Integer.parseInt(stoi.nextToken());

            total += (in - out);

            if(total < 0) zero = true;

            max = Math.max(total, max);
        }

        if(zero) System.out.println(0);
        else System.out.println(max);
    }
}