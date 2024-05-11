package BOJ;

/*
준석이는 두 동생을 위해 사탕 가게에서 사탕을 최대한 많이 사 가려고 한다. 
사탕 가게에는 N개의 사탕 묶음이 있으며 i번째 사탕 묶음에는 ai개의 사탕이 있다. 
준석이는 정말 부자라 사탕 묶음을 마음껏 살 수 있다. 
하지만 준석이가 사간 총 사탕의 개수가 홀수가 되면 두 동생이 사탕을 한 개라도 더 갖기 위해 서로 싸울 것이라 총 짝수 개의 사탕을 가져가려고 한다. 
준석이를 위해서 최대로 가져갈 수 있는 사탕의 개수를 구해주자!

첫째 줄에 사탕 묶음의 개수 N이 주어진다. (1 <= N <= 1000) 
둘째 줄에 각각의 사탕 묶음에 담겨있는 사탕의 개수 a1, a2, ..., aN가 주어진다. (1 <= ai <= 1000) 
입력으로 주어지는 모든 수는 정수이다.

준석이가 최대로 가져갈 수 있는 사탕의 개수를 출력한다.
사탕을 홀수 개로만 가져갈 수 있으면 0을 출력한다.

5
8 3 6 7 5

26
 */

import java.io.*;
import java.util.StringTokenizer;

public class N28062 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        Integer[] even = new Integer[N], odd = new Integer[N];
        int evenIdx = 0, oddIdx = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(stoi.nextToken());

            if(num % 2 == 0) {
                even[evenIdx] = num;
                evenIdx++;
            } else {
                odd[oddIdx] = num;
                oddIdx++;
            }
        }

        int sum = 0;
        for(int i = 0; i < evenIdx; i++) {
            sum += even[i];
        }

        int min = 10000;
        for(int i = 0; i < oddIdx; i++) {
            sum += odd[i];
            min = Math.min(min, odd[i]);
        }

        if(oddIdx != 0 && oddIdx % 2 == 1) {
            sum -= min;
        }

        System.out.println(sum);
    }
}