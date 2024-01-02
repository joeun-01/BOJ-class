package BOJ;

/*
1부터 n까지 차례대로 써 내려갈 때 특정 숫자(digit)의 빈도수를 구하여 출력하는 프로그램을 작성하시오.
예를 들어, n = 11 이고 숫자 1의 빈도수를 구하라고 하면, 1 2 3 4 5 6 7 8 9 10 11 에서 숫자 1은 1에서 한 번, 10에서 한 번, 11에서 두 번 나타나므로 1의 빈도수는 총 4 이다.

자연수 n (1 ≤ n ≤ 100,000)과 한 자리 숫자 d(0~9)가 첫째 줄에 주어진다.

첫째 줄에 빈도수를 출력한다.

11 1

4
 */

import java.io.*;
import java.util.StringTokenizer;

public class N14912 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        char num = stoi.nextToken().charAt(0);

        StringBuilder build = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            build.append(i);
        }

        int cnt = 0;
        for(int i = 0; i < build.length(); i++) {
            if(build.charAt(i) == num) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}