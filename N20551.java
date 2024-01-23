package BOJ;

/*
지훈이는 Sort 마스터다. 
오랫동안 Sort 마스터 자리를 지켜온 지훈이는 이제 마스터 자리를 후계자에게 물려주려고 한다. 
수많은 제자들 중에 후계자를 고르기 위해서 지훈이는 제자들에게 문제를 준비했다. 
먼저 제자들에게 N개의 원소를 가진 배열A를 주고, A의 원소들이 오름차순으로 정렬된 배열B를 만들게 한다. 
그다음 M개의 질문을 한다. 
각 질문에는 정수 D가 주어진다. 
제자들은 주어진 정수D가 B에서 가장 먼저 등장한 위치를 출력하면 된다. 
단, D가 B에 존재하지 않는 경우에는 -1를 출력한다. 
Sort 마스터의 자리를 너무나도 물려받고 싶은 창국이를 위해 지훈이의 문제를 풀 수 있는 프로그램을 만들어 주자.

첫째 줄에 배열A의 원소의 개수 N과 질문의 개수 M이 공백으로 구분되어 주어진다.
다음 줄부터 N줄에 걸쳐 정수 A_0, A_1, ... , A_{N-1$이 주어진다.

다음 줄부터 M줄에 걸쳐 정수 D가 주어진다.

개의 질문에 대해서 주어진 D가 B에서 처음으로 등장한 위치를 출력한다. 
단, 존재하지 않는다면 -1를 출력한다. (배열에서 가장 앞의 원소의 위치는 0이다.)

5 5
9
0
-1
3
2
-1
10
5
9
0

0
-1
-1
4
1
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        int[] array = new int[N];
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(read.readLine());
            array[i] = num;
        }

        Arrays.sort(array);

        for(int i = 0; i < M; i++) {
            int search = Integer.parseInt(read.readLine());
            build.append(search(array, search, 0, N - 1)).append("\n");
        }

        System.out.println(build);
    }

    public static int search(int[] array, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(array[mid] == target) {
            if(end == mid) return mid;
            return search(array, target, start, mid);
        } else if(array[mid] > target) {
            return search(array, target, start, mid - 1);
        } else return search(array, target, mid + 1, end);
    }
}