package BOJ;

/*
세준이와 세비는 온라인 게임을 즐겨한다. 
이 온라인 게임에서는 군대를 서로 키울 수 있다. 
세준이는 N명의 병사를 키웠고, 세비는 M명의 병사를 키웠다.

이제 서로 전쟁을 하려고 한다.

전쟁은 여러 번의 전투로 이루어진다. 
각 전투에서 살아있는 병사중 제일 약한 병사가 죽는다. 
만약 제일 약한 병사가 여러 명이고, 제일 약한 병사가 모두 같은 편에 있다면, 그 중에 한 명이 임의로 선택되어 죽는다. 
하지만, 제일 약한 병사가 여러 명이고, 양 편에 모두 있다면, 세비의 제일 약한 병사 중 한 명이 임의로 선택되어 죽는다.

전쟁은 한 명의 병사를 제외하고 모두 죽었을 때 끝난다. 
전쟁의 승자를 출력하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
T는 100보다 작거나 같다. 
각 테스트 케이스는 다음과 같이 이루어져 있다. 
첫째 줄에 N과 M이 들어오고, 둘째 줄에는 세준이의 병사들의 힘이 들어오고, 셋째 줄에는 세비의 병사들의 힘이 들어온다. 
힘은 정수이고, 이 값이 클수록 강하고, 작을수록 약하다.

각 테스트 케이스는 줄 바꿈으로 구분되어 있다.

각 테스트 케이스에 대해서 한 줄에 하나씩 차례대로 승자를 출력한다. 
세준이가 이기면 S를 세비가 이기면 B를 둘다 아닐 경우에는 C를 출력한다.

1 ≤ N, M ≤ 1,000,000
병사들의 힘은 300,000,000보다 작거나 같은 자연수이다. 

2

1 1
1
1

3 2
1 3 2
5 5

S
B
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        while(T > 0) {
            read.readLine();
            StringTokenizer num = new StringTokenizer(read.readLine());
            int N = Integer.parseInt(num.nextToken());
            int M = Integer.parseInt(num.nextToken());

            // 세준
            StringTokenizer n = new StringTokenizer(read.readLine());
            ArrayList<Integer> sejun = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                sejun.add(Integer.parseInt(n.nextToken()));
            }
            Collections.sort(sejun);

            // 세비
            StringTokenizer m = new StringTokenizer(read.readLine());
            ArrayList<Integer> sebi = new ArrayList<>();
            for(int i = 0; i < M; i++) {
                sebi.add(Integer.parseInt(m.nextToken()));
            }
            Collections.sort(sebi);

            while(true) {
                if(sejun.get(0) >= sebi.get(0)) {
                    sebi.remove(0);
                } else {
                    sejun.remove(0);
                }

                if(sebi.size() == 0) {
                    build.append("S\n");
                    break;
                } else if(sejun.size() == 0)  {
                    build.append("B\n");
                    break;
                }
            }   

            T--;
        }

        System.out.println(build);
    }
}
