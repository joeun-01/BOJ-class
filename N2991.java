package BOJ;

/*
창영 마을의 우체부, 우유배달원, 신문배달원은 상근이네 집에 가는 것을 매우 싫어한다. 
그 이유는 상근이네 집에는 사나운 개 두 마리가 지키고 있기 때문이다. 
하지만, 그들은 이 개의 행동이 예측 가능하다는 것을 모르고 있다.

매일 아침, 개 한마리는 A분동안 공격적이고, B분동안 조용히 쉬고 있다. 
또다른 개는 C분동안 공격적이고, D분동안 조용히 쉰다. 
두 개는 이 행동을 계속해서 연속적으로 반복한다.

우체부, 신문배달원, 우유배달원의 도착 시간이 주어졌을 때, 개 몇 마리에게 공격을 받는지 알아내는 프로그램을 작성하시오.

첫째 줄에 A, B, C, D가 주어진다. 
둘째 줄에는 P, M, N가 주어진다. 
P는 우체부의 도착 시간, M은 우유배달원의 도착 시간, N은 신문배달원의 도착 시간이다. 
매일 아침이 시작하는 시간을 0이라고 한다. 
도착 시간은 아침이 시작한 후 지난 시간이다. 
예를 들어, P가 3이면, 우체부는 아침이 시작하고 세 번째 분이 진행되는 중에 도착했다는 뜻이다.

모든 수는 1보다 크거나 같고, 999보다 작거나 같은 정수이다.

첫째 줄에는 우체부, 둘째 줄에는 우유배달원, 셋째 줄에는 신문배달원이 개 몇 마리에게 공격 받는지 출력한다.

2 2 3 3
1 3 4

2
1
0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2991 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer dog = new StringTokenizer(read.readLine());

        int A = Integer.parseInt(dog.nextToken());
        int B = Integer.parseInt(dog.nextToken());
        int C = Integer.parseInt(dog.nextToken());
        int D = Integer.parseInt(dog.nextToken());

        StringTokenizer deliver = new StringTokenizer(read.readLine());
        while(deliver.hasMoreTokens()) {
            int attack = 0;

            int arrive = Integer.parseInt(deliver.nextToken());

            int time = arrive % (A + B);
            if(time != 0 && time <= A) attack++;
            
            time = arrive % (C + D);
            if(time != 0 && time <= C) attack++;

            build.append(attack + "\n");
        }

        System.out.println(build);
    }
}
