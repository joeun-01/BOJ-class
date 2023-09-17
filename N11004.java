package BOJ;

/*
수 N개 A1, A2, ..., AN이 주어진다. 
A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.
둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

5 2
4 1 2 3 5

2
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        StringTokenizer num = new StringTokenizer(read.readLine());
        int[] number = new int[N];
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(num.nextToken());
        }

        Arrays.sort(number);

        System.out.println(number[K - 1]);
    }
}
