package BOJ;

/*
민균이는 요즘 준민이를 놀리는 일에 재미가 들렸다. 
오늘도 그는 준민이를 놀리기 위해 한가지 재미있는 아이디어를 떠올렸다. 
그는 하나의 정수가 쓰여 있는 카드 N장을 준비하여 준민이에게 정해진 순서대로 보여줄 것이다. 
준민이는 앞의 카드부터 임의의 개수만큼 골라서 민균이에게 제시하게 되는데, 제시한 카드의 수열이 순증가가 아니면 민균이에게 바보라고 놀림받게 된다. 
예를 들어 민균이가 보여준 카드가 {4, 9, 10, 9} 일 때 준민이가 {4, 9}를 골랐다면 놀림을 받지 않겠지만, {4, 10, 9}이나 {9, 9}를 제시하면 놀림받게 될 것이다.

생각보다 바보가 아닌 준민이는 한번도 민균이에게 놀림을 받지 않았다. 
이에 분노한 민균이는 하나의 조건을 더 추가했다. 
이제 준민이가 제시해야하는 수열은 순증가여야 할 뿐만 아니라, 원소의 개수가 제일 많은 수열이여야 한다. 
예를 들어 민균이가 보여준 카드가 {8, 9, 1, 2 ,10}일 때 준민이가 {8, 9, 10} 또는 {1, 2, 10}을 골랐다면 놀림을 받지 않겠지만, {8, 9}나 {1, 2}를 제시하면 놀림받게 될 것이다.

당황한 준민이는 일단 제시할 수 있는 수열의 원소의 최대 개수를 구해보기로 하였다. 
예를 들어 {8, 9, 1, 2, 10}에서의 원소의 최대 개수는 3이 될 것이다. 
도저히 못 풀겠어서 고민하던 준민이는 똑똑하기로 소문난 당신을 찾아가 이 문제를 의뢰하였다! 
불쌍하고 딱한 준민이를 위해 이 문제를 해결하는 프로그램을 작성해보자.

첫 번째 줄에는 민균이가 제시한 카드의 개수 N (1 ≤ N ≤ 1,000)이 주어진다. 
두 번째 줄에는 민균이가 제시한 카드 N개에 들어있는 정수가 공백(빈 칸)으로 구분되어 주어진다.
각 정수는 1 이상 100,000,000 이하의 자연수이다.

준민이가 제시할 수 있는 수열의 원소의 최대 개수를 출력한다.

5
8 9 1 2 10

3
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11568 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        int[] nums = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(stoi.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}