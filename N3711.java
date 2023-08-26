package BOJ;

/*
Z 대학교 학생은 입학할 때 학번을 받게 된다. 학번은 0보다 크거나 같고, 106-1보다 작거나 같은 정수이다. Z 대학의 김상근 교수는 학번으로 학생들을 구분한다. 상근이는 학생들을 조금 더 쉽게 기억하기 위해서 자신이 가르치는 학생들의 학번을 m으로 나누었을 때, 나머지가 모두 다른 가장 작은 양의 정수를 찾으려고 한다.

첫째 줄에 테스트 케이스의 개수 N이 주어진다. 각 테스트 케이스의 첫째 줄에는 상근이가 가르치는 학생의 수 G가 (1 ≤ G ≤ 300) 주어진다. 다음 G개 줄에는 학생의 학번이 한 줄에 하나씩 주어진다. 학번이 같은 경우는 없다.

각 테스트 케이스마다, 학번을 m으로 나눈 나머지가 모두 다른 가장 작은 정수 m을 출력한다.

2
1
124866
3
124866
111111
987651

1
8
 */

import java.io.*;
import java.util.HashSet;

public class N3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            int G = Integer.parseInt(read.readLine());

            long[] number = new long[G];
            for(int j = 0; j < G; j++) {
                number[j] = Long.parseLong(read.readLine());
            }            

            int M = G;
            HashSet<Long> set = new HashSet<>();
            while(true) {
                int cnt = 0;
                for(int j = 0; j < G; j++) {
                    long mod = number[j] % M;

                    int size = set.size();
                    set.add(mod);

                    if(set.size() == size + 1) cnt++;
                    else break;
                }

                if(cnt == G) {
                    build.append(M + "\n");
                    break;
                }

                set.clear();
                M++;
            }
        }

        System.out.println(build);
    }
}
