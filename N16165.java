package BOJ;

/*
정우는 소문난 걸그룹 덕후이다. 
정우의 친구 준석이도 걸그룹을 좋아하지만 이름을 잘 외우지 못한다는 문제가 있었다. 
정우는 친구를 위해 걸그룹 개인과 팀의 이름을 검색하여 외우게 하는 퀴즈 프로그램을 만들고자 한다.

첫 번째 줄에는 총 입력 받을 걸그룹의 수 N(0 < N < 100)과 맞혀야 할 문제의 수 M(0 < M < 100)을 입력받는다.

두 번째 줄부터는 각 걸그룹마다 팀의 이름, 걸그룹의 인원 수, 멤버의 이름을 한 줄씩 차례대로 입력받는다. 
팀과 멤버의 이름은 최대 100글자이며, 모든 글자는 알파벳 소문자이다. 
하나의 걸그룹이나 서로 다른 두 걸그룹에 이름이 같은 두 멤버가 있는 경우는 없다.

그 다음 줄부터는 M개의 퀴즈를 입력받는다. 
각각의 퀴즈는 두 줄로 이루어져 있으며, 팀의 이름이나 멤버의 이름이 첫 줄에 주어지고 퀴즈의 종류를 나타내는 0 또는 1이 두 번째 줄에 주어진다. 
퀴즈의 종류가 0일 경우 팀의 이름이 주어지며, 1일 경우 멤버의 이름이 주어진다.

첫 번째 줄부터 차례대로 퀴즈에 대한 답을 출력한다. 
퀴즈의 종류가 0일 경우 해당 팀에 속한 멤버의 이름을 사전순으로 한 줄에 한 명씩 출력한다. 
퀴즈의 종류가 1일 경우 해당 멤버가 속한 팀의 이름을 출력한다.

3 4
twice
9
jihyo
dahyeon
mina
momo
chaeyoung
jeongyeon
tzuyu
sana
nayeon
blackpink
4
jisu
lisa
rose
jenny
redvelvet
5
wendy
irene
seulgi
yeri
joy
sana
1
wendy
1
twice
0
rose
1

twice
redvelvet
chaeyoung
dahyeon
jeongyeon
jihyo
mina
momo
nayeon
sana
tzuyu
blackpink
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        while(N-- > 0) {
            String group = read.readLine();
            int memberCnt = Integer.parseInt(read.readLine());
            map.put(group, new ArrayList<>());

            for(int i = 0; i < memberCnt; i++) {
                map.get(group).add(read.readLine());
            }
        }

        while(M-- > 0) {
            String question = read.readLine();
            String option = read.readLine();

            if(option.equals("0")) {
                String group = question;

                ArrayList<String> list = map.get(group);
                Collections.sort(list);

                for(String name : list) {
                    build.append(name).append("\n");
                }
            } else if(option.equals("1")) {
                String member = question;

                for(String group : map.keySet()) {
                    ArrayList<String> list = map.get(group);
                    if(list.contains(member)) {
                        build.append(group).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.println(build);
    }
}