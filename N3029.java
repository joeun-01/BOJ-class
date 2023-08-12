package BOJ;

/*
창영마을에서 정인이의 반란은 실패로 끝났다. (3028번)
테러리스트로 변신한 정인이는 창영마을에 경고를 하려고 한다.
사실 정인이는 창영마을에서 제일 착한사람이다. 
따라서, 사람들을 다치지 않게하려고 한다.

유튜브에서 폭발에 대한 동영상을 찾아보다가, 그는 나트륨을 물에 던지면 폭발한다는 사실을 알게 되었다.
정인이는 창영마을의 중심을 지나는 "강산강" 근처에 숨어있다가, 나트륨을 위의 동영상처럼 물에 던질 것이다.
현재 시간과 정인이가 나트륨을 던질 시간이 주어졌을 때, 정인이가 얼마나 숨어있어야 하는지 구하는 프로그램을 작성하시오. 
(정인이는 적어도 1초를 기다리며, 많아야 24시간을 기다린다.)

첫째 줄에 현재 시간이 hh:mm:ss 형식으로 주어진다. (시, 분, 초) 
hh는 0보다 크거나 같고, 23보다 작거나 같으며, 분과 초는 0보다 크거나 같고, 59보다 작거나 같다.
둘째 줄에는 나트륨을 던질 시간이 위와 같은 형식으로 주어진다.

첫째 줄에 정인이가 기다려야 하는 시간을 입력과 같은 형식으로 출력한다.

20:00:00
04:00:00

08:00:00
 */

import java.io.*;
import java.util.StringTokenizer;

public class N3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer now = new StringTokenizer(read.readLine(), ":");
        int nHour = Integer.parseInt(now.nextToken());        
        int nMinute = Integer.parseInt(now.nextToken());
        int nSecond = Integer.parseInt(now.nextToken());

        StringTokenizer later = new StringTokenizer(read.readLine(), ":");
        int lHour = Integer.parseInt(later.nextToken());        
        int lMinute = Integer.parseInt(later.nextToken());
        int lSecond = Integer.parseInt(later.nextToken());

        if(nHour == lHour && nMinute == lMinute && nSecond == lSecond) {
            System.out.println("24:00:00");
            System.exit(0);
        }

        if(lSecond < nSecond) {
            lSecond += 60;
            lMinute--;
        }
        if(lMinute < nMinute) {
            lMinute += 60;
            lHour--;
        }
        if(lHour < nHour) {
            lHour += 24;
        }

        String hour = String.format("%02d", (lHour - nHour));
        String minute = String.format("%02d", (lMinute - nMinute));
        String second = String.format("%02d", (lSecond - nSecond));

        System.out.println(hour + ":" + minute + ":" + second);
    }
}
