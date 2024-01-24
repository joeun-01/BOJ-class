package BOJ;

/*
알고리즘 입문방 오픈 채팅방에서는 새로운 분들이 입장을 할 때마다 곰곰티콘을 사용해 인사를 한다. 
이를 본 문자열 킬러 임스는 채팅방의 기록을 수집해 그 중 곰곰티콘이 사용된 횟수를 구해 보기로 했다.

ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다. 
그 외는 채팅을 입력한 유저의 닉네임을 나타낸다. 
닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.

새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다. 
그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.

채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!

첫 번째 줄에는 채팅방의 기록 수를 나타내는 정수 N이 주어진다. (1 <= N <= 100,000)
두 번째 줄부터 N개의 줄에 걸쳐 새로운 사람의 입장을 나타내는 ENTER, 혹은 채팅을 입력한 유저의 닉네임이 문자열로 주어진다. (문자열길이 1 <= T <= 20)
첫 번째 주어지는 문자열은 무조건 ENTER이다.

채팅 기록 중 곰곰티콘이 사용된 횟수를 출력하시오.

9
ENTER
pjshwa
chansol
chogahui05
lms0806
pichulia
r4pidstart
swoon
tony9402

8
 */

import java.io.*;
import java.util.HashSet;

public class N25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        boolean enter = false;
        HashSet<String> names = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String name = read.readLine();

            if(name.equals("ENTER")) {
                enter = true;

                cnt += names.size();
                names.clear();

                continue;
            }

            if(enter == true) {
                names.add(name);
            }
        }

        cnt += names.size();

        System.out.println(cnt);
    }
}