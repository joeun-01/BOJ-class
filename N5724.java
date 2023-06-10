package BOJ;

/*
리처드 필립스 파인만은 노벨 물리학상을 수상한 미국의 물리학자이다. 
그는 이론물리학을 연구했고, 양자 컴퓨팅 분야를 개척했다. 
"Surely You’re Joking, Mr. Feynman!", "What Do You Care What Other People Think?"와 같은 그의 책은 많은 사람들의 사랑을 받았고, 한국에도 번역되어 출판되어져 있다. 
그는 오랜 기간동안 퍼즐, 자물쇠, 암호를 만들고 푸는 일에 중독되어 있었다. 

어느 날, 남아메리카의 한 농장에서 파인먼의 것으로 추정되는 한 메모가 발견되었다. 
퍼즐은 이 메모에는 중간자와 전자기에 대한 내용이 적혀있었고, 가장 마지막 줄에는 다음과 같은 퀴즈가 적혀져 있었다. 
"N × N 정사각형으로 이루어진 그리드에는 서로 다른 정사각형이 몇 개나 있을까요?" 이 퀴즈의 정답을 구하는 프로그램을 작성하시오.
N = 2인 경우에 정답은 5이다.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 그리드 한 변에 있는 정사각형의 개수 N이 주어진다. (1 ≤ N ≤ 100)

입력의 마지막 줄에는 0이 하나 주어진다.

각 테스트 케이스에 대해서, 한 줄에 하나씩 서로 다른 정사각형의 개수를 출력한다.

2
1
8
0

5
1
204
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N5724 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int dp[] = new int[101];
        for(int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + (i * i);
        }

        while(true) {
            int N = Integer.parseInt(read.readLine());

            if(N == 0) break;

            build.append(dp[N] + "\n");
        }

        System.out.println(build);
    }   
}
