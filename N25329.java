package BOJ;

/*
학생들이 한 달간 통화한 n개의 통화 기록 A가 주어진다. 
한 개의 통화 기록은 통화 시간과 학생 이름이 공백으로 구분되어 주어진다. 
한 학생의 통화 기록이 여러 번 주어질 수 있다. 
통화 시간은 시:분 형태로 주어지고 시와 분은 길이가 2인 문자열이다. 
학생 이름은 알파벳 소문자로 이루어져 있다. 
통화 요금표는 다음과 같다.

기본 시간(분): 100분, 기본 요금(원): 10, 단위 시간(분): 50, 단위 요금(원): 3

통화 요금은 학생별로 한 달간 통화한 누적 통화 시간에 대하여 청구된다. 
누적 통화 시간이 기본 시간 이하라면 기본 요금이 청구된다. 
누적 통화 시간이 기본 시간을 초과하면, 기본 요금에 더해서 초과한 시간에 대해서 단위 시간마다 단위 요금이 청구된다. 
초과한 시간이 단위 시간으로 나누어떨어지지 않으면 올림 한다.

통화 요금이 많은 학생부터 이름과 통화 요금을 출력하자. 
통화 요금이 같은 학생은 학생 이름 기준으로 오름차순으로 출력하자.

첫 번째 줄에 통화 기록의 개수 n이 주어진다.
다음 줄부터 n개의 줄에 통화 기록이 순서대로 주어진다. 
한 줄에 하나의 통화 기록이 주어진다. 
한 개의 통화 기록은 통화 시간과 학생 이름이 공백으로 구분되어 순서대로 주어진다.

첫 번째 줄부터 통화 요금이 많은 학생부터 학생 이름과 통화 요금을 공백을 사이에 두고 순서대로 출력한다. 
통화 요금이 같은 학생은 학생 이름 기준으로 오름차순으로 출력한다. 
한 줄에 한 학생의 정보를 출력한다.

1 ≤ n ≤ 10,000
00 ≤ 시 ≤ 23
00 ≤ 분 ≤ 59
2 ≤ 학생 이름 길이 ≤ 10

7
00:10 aaa
00:30 aaa
01:15 bbb
01:00 ccc
01:00 bbb
02:10 aaa
03:10 ccc

ccc 19
aaa 16
bbb 13
 */

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N25329 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            StringTokenizer time = new StringTokenizer(stoi.nextToken(), ":");

            String name = stoi.nextToken();
            int hour = Integer.parseInt(time.nextToken());
            int minute = Integer.parseInt(time.nextToken());

            int total = hour * 60 + minute;
            map.put(name, map.getOrDefault(name, 0) + total);
        }

        // System.out.println(map);

        TreeMap<Integer, String> costs = new TreeMap<>(Collections.reverseOrder());
        for(String key : map.keySet()) {
            int total = map.get(key);

            if(total > 100) {
                total -= 100;
                int plus = total % 50 == 0 ? total / 50 : total / 50 + 1;
                int cost = 10 + plus * 3;

                costs.put(cost, costs.getOrDefault(cost, "") + " " + key);
            } else {
                costs.put(10, costs.getOrDefault(10, "") + " " + key);
            }
        }

        for(int cost : costs.keySet()) {
            StringTokenizer stoi = new StringTokenizer(costs.get(cost));
            while(stoi.hasMoreTokens()) {
                build.append(stoi.nextToken()).append(" ").append(cost).append("\n");
            }
        }

        System.out.println(build);
    }
}