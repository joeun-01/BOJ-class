package BOJ;

/*
민승이는 N(1 ≤ N ≤ 1,000,000)명의 학생들에게 양의 정수로 된 라벨을 붙이려고 한다. 
하지만 모든 학생들은 숫자 L(0 ≤ L ≤ 9)이 자신의 라벨 숫자에 포함되길 원치 않는다. 

문제는 학생들에게 숫자 L을 쓰지 않고 최소한 작은 N개의 양의 수 세트를 라벨링 할 때 학생들이 받는 라벨 중 가장 큰 수가 몇인지를 구하는 것이다.

첫째 줄에 N과 L이 공백으로 구분되어 주어진다.

첫째 줄에 민승이가 학생들에게 붙이는 라벨 중 가장 큰 수를 출력한다.

10 1

22
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int L = Integer.parseInt(stoi.nextToken());

        char I = Integer.toString(L).charAt(0);

        int cur = 1, label = 1;
        while(cur <= N) {
            char[] num = Integer.toString(label).toCharArray();

            boolean fail = false;
            for(int i = 0; i < num.length; i++) {
                if(num[i] == I) {
                    fail = true;
                    break;
                }
            }

            label++;

            if(!fail) cur++;
        }

        System.out.println(label - 1);
    }
}
