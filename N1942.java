package BOJ;

/*
디지털시계는 일반적으로 시각을 “hh:mm:ss”의 형태로 표현한다. 
hh는 00 이상 23 이하의 값을, mm과 ss는 00 이상 59 이하의 값을 가질 수 있다. 
이러한 형태의 시각에서 콜론(“:”)을 제거하면 “hhmmss”라는 정수를 얻을 수 있는데, 이러한 정수를 시계 정수라고 한다. 
예를 들어, 오후 5시 5분 13초, 즉 17:05:13의 시계 정수는 170513이고, 오전 0시 7분 37초, 즉 00:07:37의 시계 정수는 737이다.

이 문제에서 시간이란 시각의 구간을 나타낸다. 
예를 들어 [00:59:58, 01:01:24]와 같이 시작하는 시각과 끝나는 시각으로 이루어진 구간을 우리는 시간이라고 부른다. (이러한 구간에는 시작하는 시간과 끝나는 시간도 포함된다)

이렇게 시간이 구간으로 주어지면, 그 구간에 포함되는 시계 정수들을 나열할 수 있다. 
예를 들어 [00:59:58, 01:01:24]에 포함되는 시계 정수는 5958, 5959, 다음으로 10000 이상 10059 이하, 마지막으로 10100 이상 10124 이하로 총 87개가 된다. 
우리는 이처럼 특정한 시간에 포함되는 시계 정수들 중, 3의 배수인 것이 몇 개나 있는지를 알고 싶다.

시간은 자정을 포함할 수도 있다. 
즉 [23:59:03, 00:01:24]처럼 시작하는 시각의 시계 정수(235903)가 끝나는 시각의 시계 정수(124)보다 클 수도 있다. 
물론 이 경우 이 구간에 포함되는 시계 정수는 235903 이상 235959 이하, 0 이상 59 이하, 100 이상 124 이하가 된다. 
모든 구간이 포함하는 시간은 만 하루, 즉 24시간보다는 항상 작다고 가정해도 좋다.

시간이 시작하는 시각과 끝나는 시각으로 주어졌을 때, 이 구간에 포함되는 시계 정수들 중, 3의 배수인 것의 개수를 구하는 프로그램을 작성하시오.

세 개의 입력이 주어진다. 
첫째 줄부터 세 줄에 걸쳐 시작하는 시각과 끝나는 시각이 “hh:mm:ss”의 형태로 주어진다. 
시작하는 시각과 끝나는 시각 사이에는 빈 칸이 하나 있어서, 한 줄마다 (빈 칸을 포함하여) 총 17글자가 입력으로 주어진다. 
시작하는 시각과 끝나는 시각은 항상 다르다.

첫째 줄부터 세 개의 줄에 걸쳐 입력된 구간에 포함되는 시계 정수들 중, 3의 배수인 것의 개수를 출력한다. 
입력된 순서대로 각 줄에 한 개씩 차례로 출력하면 된다.

00:59:58 01:01:24
22:47:03 01:03:24
00:00:09 00:03:37

29
2727
70
 */

import java.io.*;
import java.util.*;

public class N1942 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            String start = stoi.nextToken();
            String end = stoi.nextToken();

            int startNum = toClockInteger(start);
            int endNum = toClockInteger(end);

            // 시작 시각이 끝 시각보다 클 경우, 하루를 더해줌
            if (startNum > endNum) {
                endNum += 240000;
            }

            // 3의 배수인 시계 정수 개수 구하기
            int count = countMultiplesOf3(startNum, endNum);
            System.out.println(count);

        }
    }

    public static int toClockInteger(String time) {
        String[] tokens = time.split(":");
        int hh = Integer.parseInt(tokens[0]);
        int mm = Integer.parseInt(tokens[1]);
        int ss = Integer.parseInt(tokens[2]);

        return hh * 10000 + mm * 100 + ss;
    }

    public static int countMultiplesOf3(int startNum, int endNum) {
        int cnt = 0;

        int current = startNum;
        while(current <= endNum) {
            if (current % 3 == 0) {
                cnt++;
            }

            if (current % 10000 == 5959) { // 초가 59초일 때
                current += 4041; 
                continue;
            }

            if (current % 100 == 59) { // 초가 59일 때
                current += 41;
                continue;
            }

            current++;
        }

        return cnt;
    }
}