package BOJ;

/*
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

첫째 줄에 구한 0의 개수를 출력한다.

10

2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(read.readLine());

        int five = 0;
        for(int i = 1; i <= num; i++) {
            // i에 들어가는 5의 개수를 셈
            if(i % 5 == 0) {
                int count = i;
                while(count >= 5) {
                    if(count % 5 == 0) {
                        five++;
                        count /= 5;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.println(five);
    }
}
