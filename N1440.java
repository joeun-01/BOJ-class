package BOJ;

/*
다솜이는 타임머신을 타고 8364년으로 갔다. 
다행히 지구는 평화롭다.

다솜이는 2008년으로 돌아가기 전에 시계를 샀다. 
다솜이는 시계를 볼 줄 모르기 때문에, 디지털 시계를 샀다. 
디지털 시계는 HH:MM:SS와 같은 모양으로 시간을 나타내 준다. 
그리고 앞에서부터 차례대로 HH는 시, MM은 분, SS는 초를 나타낸다.

다솜이는 8364년에는 2008년과 같은 방법으로 시간을 나타내는지 모른다. 
2008년엔 시:분:초를 나타내는지만, 8364년엔 분:시:초로 나타낼지도 모른다.

다행히 시는 01부터 12, 분은 00부터 59, 초는 00부터 59를 나타낸다.

다솜이의 시계에 쓰여 있는 숫자가 주어졌을 때, 이 시간을 읽을 수 있는 가능한 방법의 수를 출력하는 프로그램을 작성하시오. 
나타내는 시간이 같더라도, 시, 분, 초를 읽을 수 있는 위치가 다르면 다른 방법으로 센다. 
또한, 방법의 수가 0일 수도 있다.

예를 들어, 21:23:01 은 21분 23초 01시 로 읽을 수도 있지만, 21초 23분 01시로 읽을 수도 있다.

첫째 줄에 시간이 주어진다. 
시간은 DD:DD:DD와 같은 꼴로 주어진다. 
항상 8자리(:도 포함)로만 들어오며, D는 0-9 사이의 숫자이다.

첫째 줄에 시간을 읽을 수 있는 가능한 방법의 수를 출력한다.

00:00:00

0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1440 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer time = new StringTokenizer(read.readLine(), ":");

        int h = Integer.parseInt(time.nextToken());
        int m = Integer.parseInt(time.nextToken());
        int s = Integer.parseInt(time.nextToken());

        int cnt = 0;

        if(h > 0 && h <= 12) cnt++;
        if(m > 0 && m <= 12) cnt++;
        if(s > 0 && s <= 12) cnt++;

        if(h > 59) {
            System.out.println(0);
            System.exit(0);
        }
        if(m > 59) {
            System.out.println(0);
            System.exit(0);
        }        
        if(s > 59) {
            System.out.println(0);
            System.exit(0);
        }

        if(cnt == 0) System.out.println(0);
        if(cnt == 1) System.out.println(2);
        if(cnt == 2) System.out.println(4);
        if(cnt == 3) System.out.println(6);
    }
}

// 12 이하가 