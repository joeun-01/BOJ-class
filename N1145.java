package BOJ;

/*
다섯 개의 자연수가 있다. 
이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.

서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.

첫째 줄에 다섯 개의 자연수가 주어진다. 
100보다 작거나 같은 자연수이고, 서로 다른 수이다.

첫째 줄에 적어도 대부분의 배수를 출력한다.

30 42 70 35 90

210
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] num = new int[5];
        int min = 100;
        for(int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(stoi.nextToken());

            if(num[i] < min) min = num[i];
        }

        int idx = min;
        while(true) {
            int cnt = 0;
            for(int i = 0; i < 5; i++) {
                if(idx % num[i] == 0) cnt++;
            }

            if(cnt >= 3) break;

            idx++;
        }

        System.out.println(idx);
    }
}
