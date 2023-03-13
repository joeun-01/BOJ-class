package BOJ;

/*
사탕 박사 고창영은 사탕 공장을 그만 두고 초등학교 선생님으로 취직했다.
오늘은 창영이네 반 학생들과 소풍을 가는 날이다.
N명의 학생은 모두 가방에 사탕을 가득 담아왔다.
그런데, 사탕을 많이 가져온 학생들이 사탕을 적게 가져온 학생들을 놀리기 시작했다.
창영이는 "얘들아~ 그러면 안되지ㅜㅜ 사탕을 모두 여기에 가져와보렴. 선생님이 공평하게 나눠줄게"
창영이는 모든 학생들이 같은 사탕을 가지게 하려고 한다.
이것이 가능한 일일까?

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스는 빈 줄로 구분되어 있고, 다음과 같이 구성되어 있다.

테스트 케이스의 첫째 줄에 학생의 수 N이 주어진다. 
다음 N개의 줄에는 각 학생들이 가져온 사탕의 수가 주어진다.

N은 100,000보다 작거나 같은 자연수이고, 사탕의 개수는 0보다 크거나 같은 정수이다. 
학생들이 가져온 사탕 개수는 1018보다 작거나 같다. (학생들이 가져온 사탕 개수의 합은 1018을 넘어갈 수 있다)

각 테스트 케이스에 대해 모두에게 같은 사탕을 나눠줄 수 있으면 YES를, 없으면 NO를 출력한다.

2

5
5
2
7
3
8

6
7
11
2
7
3
4

YES
NO
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class N2547 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());

        for(int i = 0; i < T; i++) {
            read.readLine();

            int N = Integer.parseInt(read.readLine());
            BigInteger candy = BigInteger.ZERO;
            for(int j = 0; j < N; j++) {
                candy = candy.add(new BigInteger(read.readLine()));
            }

            if(candy.mod(new BigInteger(Integer.toString(N))) == BigInteger.ZERO) build.append("YES\n");
            else build.append("NO\n");
        }
        
        System.out.println(build);
    }
}