package BOJ;

/*
제연이는 그의 생일(2000년 3월 3일)을 기념해 자신이 가장 좋아하는 수를 20000303으로 나눈 나머지를 구해 그 수만큼 잠을 자기로 했다. 제연이가 얼마나 잠을 잘 수 있을지 구하자.

첫째 줄에 제연이가 가장 좋아하는 수 N이 주어진다. (N ≤ 10^1,000,000)

N을 20000303으로 나눈 나머지를 출력한다.

20000303200003032000030320000303200003032000030320000303200003032000030320000303

0
 */

import java.io.*;

public class N14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = read.readLine();
        long temp = 0;
        for(int i = 0; i < str.length(); i++) {
            temp = (temp * 10 + (str.charAt(i) - '0')) % 20000303;
        }

        System.out.println(temp);
    }
}