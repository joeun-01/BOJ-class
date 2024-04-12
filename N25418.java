package BOJ;

/*
입력으로 양의 정수 A와 K가 주어지면, 아래 연산을 이용하여 A를 K로 변경하려고 한다. 
정수 A를 변경할 때 사용할 수 있는 연산 종류는 다음과 같다.

- 연산 1: 정수 A에 1을 더한다.
- 연산 2: 정수 A에 2를 곱한다.
정수 A를 정수 K로 만들기 위해 필요한 최소 연산 횟수를 출력하자.

첫 번째 줄에 양의 정수 A와 K가 빈칸을 사이에 두고 순서대로 주어진다.

첫 번째 줄에 양의 정수 A를 양의 정수 K로 만들기 위해 필요한 최소 연산 횟수를 출력한다.

1 ≤ A < K ≤ 1,000,000

5 10

1
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int A = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        long[] depth = new long[K + 1];
        boolean[] isVisited = new boolean[K + 1];

        depth[A] = 0;
        queue.add(A);
        isVisited[A] = true;

        long cnt = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            isVisited[node] = true;

            if(node + 1 < K && !isVisited[node + 1]) {
                depth[node + 1] = depth[node] + 1;
                queue.add(node + 1);
            } 

            if(node * 2 < K && !isVisited[node * 2]) {
                depth[node * 2] = depth[node] + 1;
                queue.add(node * 2);
            } 

            if(node + 1 == K || node * 2 == K) {
                cnt = depth[node] + 1;
                break;
            }
        }

        System.out.println(cnt);
    }
}