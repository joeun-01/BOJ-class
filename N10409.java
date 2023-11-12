package BOJ;

/*
당신은 FCFS(First-Come, First-Served)의 규칙에 따라 요청된 일을 처리하는 서버를 담당하게 되었다. 
매일, 당신은 일을 처리하기 위해 최대 T분 동안 서버에 시간을 할당할 수 있다. 
당신은 오늘 주어진 시간동안 몇개의 일이 완료될 수 있는지 알고싶다.

예시를 들어보겠다. T = 180이고, 요청된 일들의 수행시간이 요청된 순으로 각각 45, 30, 55, 20, 80, 20분이다. 
그러면, 단 4개의 일만이 완료될 수 있다. 
처음 4개의 일의 수행시간은 150분으로 주어진 시간 내에 완료될 수 있지만, 처음 5개의 일의 수행시간은 230분으로 주어진 시간 180분보다 크기 때문에 완료될 수 없다. 
처음 4개의 일을 수행한 뒤 6번째의 일을 수행해도 T를 초과하지 않지만 5번째 일을 수행할 수 없기 때문에 6번째 일을 수행할 수 없음을 참고해라.

첫 줄은 두 정수 n과 T이며 (1 ≤ n ≤ 50, 1 ≤ T ≤ 500) n은 일의 개수를 나타낸다. 
두 번째 줄은 n개의 100 이하인 자연수가 입력되며, 입력된 각 일의 수행 시간을 나타낸다.

일이 First-come, First-served 규칙에 따라 처리될 때, T분 안에 완료될 수 있는 일들의 개수를 출력하라.

6 180
45 30 55 20 80 20

4
 */

import java.io.*;
import java.util.StringTokenizer;

public class N10409 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int T = Integer.parseInt(stoi.nextToken());

        int[] work = new int[N];
        stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < N; i++) {
            work[i] = Integer.parseInt(stoi.nextToken());
        }

        int i = 0, time = 0, cnt = 0;
        while(i < N) {
            if(time + work[i] > T) break;

            time += work[i];
            cnt++;
            i++;
        }

        System.out.println(cnt);
    }
}
