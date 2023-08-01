package BOJ;

/*
7:00부터 19:00까지 전화 요금은 1분에 10원이다.
19:00부터 7:00까지 전화 요금은 1분에 5원이다.
상근이가 전화를 건 시간과 통화 시간이 모두 주어졌을 때, 전화 요금을 구하는 프로그램을 작성하시오.

첫째 줄에 상근이가 건 전화의 수 N이 주어진다. (1 ≤ N ≤ 100)
다음 N개 줄에는 상근이가 건 전화에 대한 정보가 HH:MM DD와 같은 형식으로 주어진다.
HH:MM은 전화를 건 시간이며, DD는 통화 시간이다. 
DD는 최대 60이며, MM과 DD사이에는 공백이 하나 주어진다.
만약 시나 분이 한자리 숫자라면, 앞에 0이 하나 주어진다.
시간은 00:00부터 23:59까지이다.

총 전화 요금을 출력한다.

2
11:02 11
15:30 01

120
 */

import java.io.*;
import java.util.StringTokenizer;

public class N3226 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine()), total = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            StringTokenizer start = new StringTokenizer(stoi.nextToken(), ":");
            int hour = Integer.parseInt(start.nextToken());
            int minute = Integer.parseInt(start.nextToken());

            int call = Integer.parseInt(stoi.nextToken());

            if(hour == 6) {
                if(minute + call > 60) {
                    total += (60 - minute) * 5;
                    total += (call - (60 - minute)) * 10;
                } else {
                    total += 5 * call;
                }
            } else if(hour == 18) {
                if(minute + call > 60) {
                    total += (60 - minute) * 10;
                    total += (call - (60 - minute)) * 5;
                } else {
                    total += 10 * call;
                }
            } else if(7 <= hour && hour < 18) {
                total += 10 * call;
            } else if(hour < 6 || hour >= 19) {
                total += 5 * call;
            }
        }

        System.out.println(total);
    }
}
