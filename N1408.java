package BOJ;

/*
도현이는 Counter Terror Unit (CTU)에서 일하는 특수요원이다. 
도현이는 모든 사건을 정확하게 24시간이 되는 순간 해결하는 것으로 유명하다. 
도현이는 1시간 만에 범인을 잡을 수 있어도 잡지 않는다. 
정확하게 24시간이 되는 순간이 아니면 잡지 않는 CTU 특수요원이다.

2008년 3월 3일 월요일, CTU는 새학기에 맞춰 핵폭탄을 날리겠다는 테러 정보를 입수했다. 
CTU에서는 특수요원 도현이에게 이 임무를 맡겼다. 
CTU의 프로그래머 준규는 이 사건의 배후가 김선영이란 것을 해킹을 통해 밝혀내었다.

도현이는 선영이를 임무를 시작한지 정확하게 24시간이 되는 순간에 잡으려고 한다.

만약 지금 시간이 13:52:30이고, 임무를 시작한 시간이 14:00:00 이라면 도현이에게 남은시간은 00:07:30 이다.

모든 시간은 00:00:00 ~ 23:59:59로 표현할 수 있다. 
입력과 출력에 주어지는 모든 시간은 XX:XX:XX 형태이며, 숫자가 2자리가 아닐 경우에는 0으로 채운다.

도현이가 임무를 시작한 시간과, 현재 시간이 주어졌을 때, 도현이에게 남은 시간을 구하는 프로그램을 작성하시오.

첫째 줄에는 현재 시간이, 둘째 줄에는 도현이가 임무를 시작한 시간이 주어진다. 
임무를 시작한 시간과 현재 시간이 같은 경우는 주어지지 않는다.

첫째 줄에 도현이가 임무를 수행하는데 남은 시간을 문제에서 주어지는 시간의 형태 (XX:XX:XX)에 맞춰 출력한다.

13:52:30
14:00:00

00:07:30
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer start = new StringTokenizer(read.readLine(), ":");
        StringTokenizer now = new StringTokenizer(read.readLine(), ":");

        int hour = Integer.parseInt(now.nextToken()) - Integer.parseInt(start.nextToken());
        int min = Integer.parseInt(now.nextToken()) - Integer.parseInt(start.nextToken());
        int sec = Integer.parseInt(now.nextToken()) - Integer.parseInt(start.nextToken());
        
        if(sec < 0) {
            min--;
            sec += 60;
        }

        if(min < 0) {
            hour--;
            min += 60;
        }

        if(hour < 0) hour += 24;

        System.out.println(String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" +  String.format("%02d", sec));
    }
}