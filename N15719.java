package BOJ;

/*
1부터 N - 1까지의 정수가 하나씩 정렬되지 않은 채로 저장되어 있는 어떤 수열 A가 있다. 
수열 A에 임의의 정수 M(1 ≤ M ≤ N – 1)을 넣어 크기가 N인 수열로 만들었을 때, 임의의 정수 M을 찾는 프로그램을 작성하라.

첫째 줄에 수열의 크기 N(2 ≤ N ≤ 10,000,000)이 주어진다.

둘째 줄에 수열 A의 원소인 N개의 정수가 주어진다. 
입력으로 주어지는 정수는 모두 1보다 크거나 같고, N-1보다 작거나 같은 정수이며 문제의 답인 M을 제외하고는 모두 서로 다른 정수이다.

M을 출력하라.

10
1 2 2 5 6 4 3 7 8 9

2
 */

import java.io.*;
import java.util.StringTokenizer;

public class N15719 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        int sum = 0, originSum = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(stoi.nextToken());
            sum += num;
            originSum += i;
        }

        System.out.println(sum - originSum);
    }
}