package BOJ;

/*
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

5 3
5 4 3 2 1
1 3
2 4
5 5

12
9
1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer input = new StringTokenizer(read.readLine());
        int data = Integer.parseInt(input.nextToken());
        int test = Integer.parseInt(input.nextToken());

        int[] num = new int[data + 1];
        int[] sum = new int[data + 1];

        StringTokenizer array = new StringTokenizer(read.readLine());

        for(int i = 1; i <= data; i++) {
            num[i] = Integer.parseInt(array.nextToken());

            if(i == 0) sum[i] = num[i];
            else sum[i] = sum[i - 1] + num[i];
        }

        for(int i = 0; i < test; i++) {
            StringTokenizer range = new StringTokenizer(read.readLine());
            int start = Integer.parseInt(range.nextToken());
            int end = Integer.parseInt(range.nextToken());

            build.append((sum[end] - sum[start - 1]) + "\n");
        }

        System.out.print(build);
    }
}
