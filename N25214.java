package BOJ;

/*
민겸이는 크림 파스타를 먹다가 다음과 같은 문제를 생각해냈다.

빈 배열 A가 있다. 
민겸이는 A의 맨 뒤에 정수를 N번 추가하려고 한다. 
수를 그냥 추가하기만 하면 재미없으니, 수를 추가할 때마다 1 ≤ i ≤ j ≤ |A|를 만족하는 정수 i, j에 대하여 Aj - Ai의 최댓값을 구하려고 한다. 
|A|는 배열 A의 현재 길이를 뜻하고, Ai는 민겸이가 i번째로 추가한 정수를 뜻한다.

민겸이가 식사를 마치기 전에 이 문제를 대신 풀어보자.

입력은 두 줄로 주어진다.
첫 번째 줄에는 민겸이가 배열에 추가하려는 정수의 개수 N이 주어진다.
두 번째 줄에는 A1부터 AN까지 N개의 정수가 공백으로 구분되어 주어진다.

각 Ai가 추가된 직후의 문제의 답 N개를 공백으로 구분하여 출력한다.

1 ≤ N ≤ 200,000
1 ≤ Ai ≤ 109

6
50 100 70 110 10 100

0 50 50 60 60 90
 */

import java.io.*;
import java.util.StringTokenizer;

public class N25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        int[] array = new int[N];
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(stoi.nextToken());
        }

        int[] minus = new int[N];
        int max = array[0], min = array[0];
        for(int i = 1; i < N; i++) {
            if(array[i] - min > minus[i - 1]) minus[i] = array[i] - min;
            else minus[i] = minus[i - 1];

            if(array[i] > max) max = array[i];
            if(array[i] < min) min = array[i];
        }

        for(int i = 0; i < N; i++) {
            build.append(minus[i]).append(" ");
        }

        System.out.println(build);
    }   
}