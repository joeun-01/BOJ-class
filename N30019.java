package BOJ;

/*
충남대학교 공대 5호관에는 1번부터 N번까지 번호가 매겨진 N개의 강의실이 있다. 
학생들은 강의실 예약 시스템을 통해 원하는 강의실을 예약한 후에 이용할 수 있다. 
강의실을 예약하기 위해서는 이용하려는 강의실의 번호 k와 이용 시작 시각과 끝 시각 s,e를 예약 시스템에 전송해야 한다.

어느 날, 예약 시스템에 M개의 예약 요청이 주어졌다. 
예약 요청은 이용 시작 시각 s가 임박한 순으로 주어지고, 이용 시작 시각이 같은 예약은 없다. 
예약 시스템은 예약 요청을 순서대로 확인하는데, 어떤 예약이 기존에 같은 강의실에 대해 수락한 예약과 겹치지 않는다면 그 예약을 수락하고 그렇지 않다면 거부한다. 
단, 이용 끝 시각과 이용 시작 시각이 같은 두 예약은 겹친 것이 아니다.

 
$M$개의 예약 요청이 주어질 때, 강의실 예약 시스템이 각 예약 요청을 수락하는지 거부하는지 구해보자.

첫째 줄에 정수 N, M(1 <= N, M<= 200,000)$이 주어진다.

둘째 줄부터 M개의 줄에 i번째 예약의 강의실 번호 ki(1 <= ki <= N)와 이용 시작 시각과 끝 시각을 의미하는 정수 si,ei(1 <= si <ei <= 10^9)가 주어진다. 
M개의 예약은 이용 시작 시각 s를 기준으로 오름차순으로 주어지며, 이용 시작 시각이 같은 예약은 주어지지 않는다.

$M$개의 줄에 순서대로 각 예약 요청을 수락한다면 YES를, 거부한다면 NO를 출력한다.

1 3
1 2 3
1 3 5
1 4 6

YES
YES
NO
 */

import java.io.*;
import java.util.StringTokenizer;

public class N30019 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[] rooms = new int[N + 1];

        for(int i = 0; i < M; i++) {
            stoi = new StringTokenizer(read.readLine());

            int k = Integer.parseInt(stoi.nextToken());
            int s = Integer.parseInt(stoi.nextToken());
            int e = Integer.parseInt(stoi.nextToken());

            if(rooms[k] <= s) {
                build.append("YES").append("\n");
                rooms[k] = e;
            } else {
                build.append("NO").append("\n");
            }                
        }

        System.out.println(build);
    }
}