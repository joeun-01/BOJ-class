package BOJ;

/*
N마리의 새가 나무에 앉아있고, 자연수를 배우기 원한다. 
새들은 1부터 모든 자연수를 오름차순으로 노래한다. 
어떤 숫자 K를 노래할 때, K마리의 새가 나무에서 하늘을 향해 날아간다. 
만약, 현재 나무에 앉아있는 새의 수가 지금 불러야 하는 수 보다 작을 때는, 1부터 게임을 다시 시작한다.

나무에 앉아 있는 새의 수 N이 주어질 때, 하나의 수를 노래하는데 1초가 걸린다고 하면, 모든 새가 날아가기까지 총 몇 초가 걸리는지 출력하는 프로그램을 작성하시오.

첫째 줄에 새의 수 N이 주어진다. 
이 값은 109보다 작거나 같은 자연수이다.

첫째 줄에 정답을 출력한다.

14

7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(read.readLine());

        long cnt = N, i = 1, time = 0;
        while(cnt > 0) {
            if(cnt < i) i = 1;

            cnt -= i;

            i++;
            time++;
        }

        System.out.println(time);
    }
}
