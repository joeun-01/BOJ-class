package BOJ;

/*
상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. 
하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.

이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.

첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,
각 테스트 케이스마다 다음과 같은 정보가 주어진다.

첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.
이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b) 
주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.

테스트 케이스마다 한 줄을 출력한다.

상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.

2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5

2
4
 */

import java.io.*;
import java.util.StringTokenizer;

public class N9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        while(T-- > 0) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int N = Integer.parseInt(stoi.nextToken());
            int M = Integer.parseInt(stoi.nextToken());

            for(int i = 0; i < M; i++) {
                stoi = new StringTokenizer(read.readLine());
                Integer.parseInt(stoi.nextToken());
                Integer.parseInt(stoi.nextToken());
            }

            build.append(N - 1).append("\n");
        }

        System.out.println(build);
    }
}