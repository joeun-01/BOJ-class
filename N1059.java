package BOJ;

/*
정수 집합 S가 주어졌을때, 다음 조건을 만족하는 구간 [A, B]를 좋은 구간이라고 한다.

A와 B는 양의 정수이고, A < B를 만족한다.
A ≤ x ≤ B를 만족하는 모든 정수 x가 집합 S에 속하지 않는다.
집합 S와 n이 주어졌을 때, n을 포함하는 좋은 구간의 개수를 구해보자.

첫째 줄에 집합 S의 크기 L이 주어진다. 
둘째 줄에는 집합에 포함된 정수가 주어진다. 
셋째 줄에는 n이 주어진다.

첫째 줄에 n을 포함하는 좋은 구간의 개수를 출력한다.

1 ≤ L ≤ 50
집합 S에는 중복되는 정수가 없다.
집합 S에 포함된 모든 정수는 1보다 크거나 같고, 1,000보다 작거나 같다.
1 ≤ n ≤ (집합 S에서 가장 큰 정수)

4
1 7 14 10
2

4
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(read.readLine());
        
        int[] array = new int[S];
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < S; i++) {
            array[i] = Integer.parseInt(stoi.nextToken());
        }

        Arrays.sort(array);
        int n = Integer.parseInt(read.readLine());

        int cnt = 0;
        // 좋은 구간이 집합 S의 가장 작은 숫자보다 작은 경우
        for(int i = 1; i < array[0]; i++) { 
            for(int j = i + 1; j < array[0]; j++) {
                if((n >= i && n <= j) && j < array[0]) cnt++; //n이 i와 j 사이에 존재하고 집합 S의 가장 작은 숫자보다 작은 경우 +1
            }
        }

        // 좋은 구간이 집합 S의 숫자들 사이에 위치하는 경우
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = array[i] + 1; j < array[i + 1]; j++) { // 집합 S의 i번째 숫자+1부터 i+1번째 숫자 전까지의 경우에 대해서
                for(int k = j + 1; k < array[i + 1]; k++) { // 집합 S의 i번째 숫자+2부터 i+1번째 숫자 전까지의 경우에 대해서
                    if((n >= j && n <= k) && k < array[i + 1]) cnt++; // n이 j와 k 사이에 존재하고 집합 S의 i+1번째 숫자보다 작은 경우 +1
                }
            }
        }

        System.out.println(cnt);
    }   
}