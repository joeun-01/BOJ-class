package BOJ;

/*
수 N개가 주어졌을 때, N개의 합을 구하는 프로그램을 작성하시오.

첫째 줄에 N(1 ≤ N ≤ 100)개의 수가 공백으로 구분되어서 주어진다. 
입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다. 
또, 0으로 시작하는 수는 주어지지 않는다.

입력받은 수 N개의 합을 출력한다.

1 2 3 4 5

15
 */

import java.io.*;
import java.util.StringTokenizer;

public class N11023 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int sum = 0;
        while(stoi.hasMoreTokens()) {
            sum += Integer.parseInt(stoi.nextToken());
        }

        System.out.println(sum);
    }
}
