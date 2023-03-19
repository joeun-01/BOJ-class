package BOJ;

/*
대부분의 자전거 속도계는 앞 포크에 설치된 홀 효과 센서로 동작한다. 
자석이 앞 바퀴의 포크중 하나에 부착되어, 홀 효과를 이용해 속도계가 바퀴의 회전수를 측정한다. 
따라서 바퀴의 지름을 안다면 회전수를 통해 이동 거리를 측정할 수 있다. 
또한 바퀴가 회전하는 동안 걸린 시간을 안다면 평균 속도 역시 알 수 있다.

바퀴의 지름, 회전수, 걸린 시간이 주어졌을 때, 총 이동 거리와 평균 속도를 계산하여라. 
앞바퀴는 땅에서 떨어지거나 미끄러지거나 공전하지 않았다고 가정한다.

이동 거리의 단위는 miles이고, 평균 속도의 단위는 miles/hour 이다.

입력은 여러 줄의 데이터로 구성된다. 
각 데이터는 지름, 회전수, 시간이 공백으로 구분되어 주어진다. 
지름은 inch단위의 실수이며, 회전수는 정수이다. 
시간은 초단위의 실수로 주어진다. 입력은 회전수가 0이면 끝난다. 
실수는 소수점 셋째자리이하까지 주어진다.

각각의 데이터에 대해 다음을 출력한다.

Trip #N: distance MPH

N은 각각의 데이터 번호를 출력해야 하며, distance는 총 거리(Miles)를 소수 둘째 자리까지 반올림하여 나타내며, MPH는 평균 속도(miles per hour)를 소수 둘째 자리까지 반올림하여 나타낸다. 
회전수가 0인 데이터에 대해서는 출력하지 않는다.

26 1000 5
27.25 873234 3000
26 0 1000

Trip #1: 1.29 928.20
Trip #2: 1179.86 1415.84
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2765 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int i = 1;
        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            float diameter = Float.parseFloat(stoi.nextToken());
            int rotate = Integer.parseInt(stoi.nextToken());
            float time = Float.parseFloat(stoi.nextToken());

            if(rotate == 0) break;

            float distance = diameter * 3.1415927f * rotate / (5280 * 12);
            float MPH = distance * 60 * 60 / time;

            build.append("Trip #" + i + ": " + String.format("%.2f", distance) + " " + String.format("%.2f", MPH) + "\n");

            i++;
        }

        System.out.println(build);
    }
}