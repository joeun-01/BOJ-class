package BOJ;

/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
둘째 줄부터 N개의 줄에는 수가 주어진다. 
이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
수는 중복되지 않는다.

첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

5
5
2
3
4
1

1
2
3
4
5
 */

import java.io.*;
import java.util.Arrays;

public class N2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int[] array = new int[N];
        for(int i = 0; i < N; i++) {    
            array[i] = Integer.parseInt(read.readLine());
        }

        Arrays.sort(array);

        for(int i = 0; i < N; i++) {    
            System.out.println(array[i]);
        }
    }
}