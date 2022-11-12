package BOJ;

/*
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 
 * 이 수는 10,000보다 작거나 같은 자연수이다.
 * 
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 10
 * 5
 * 2
 * 3
 * 1
 * 4
 * 2
 * 3
 * 5
 * 1
 * 7
 * 
 * 1
 * 1
 * 2
 * 2
 * 3
 * 3
 * 4
 * 5
 * 5
 * 7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class N10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());
        int[] list = new int[num];

        int i;
        for(i = 0; i < num; i++) {
            list[i] = Integer.parseInt(read.readLine());
        }

        Arrays.sort(list);

        for(i = 0; i < num; i++) {
            build.append(list[i] + "\n");
        }

        System.out.println(build);
    }
}
