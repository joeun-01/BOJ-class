/*
영선이는 과대 포장으로 유명한 남규 회사에서 아르바이트를 한다. 
영선이는 여러 박스들을 여러겹으로 포장하는 업무를 맡았다. 
박스를 포장할 때 규칙이 있는데, 일단 박스를 일렬로 주어진다. 
그리고 앞에 있는 박스가 뒤에 있는 박스보다 작아야지만, 뒤에 있는 박스에 넣을 수 있다. 
뒤에 있는 박스를 앞에 있는 박스에 넣을 순 없다.

박스의 크기가 앞에서부터 일렬로 주어졌을 때, 최대한 박스안에 박스를 넣어 과대 포장한 박스 개수를 구하시오.

첫째 줄에는 박스의 개수 n이 주어진다.(1≤n≤5000)
다음 줄에는 박스의 크기 Ai가 앞에서부터 차례대로 주어진다.(1≤Ai≤100,000)

최대한 박스안에 박스를 넣어 과대 포장을 할 때, 그 박스들의 개수를 구하시오.

4
1 2 3 4

4
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14231 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] boxes = new int[N];
        for(int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(stoi.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 1; i < N; i++)  {
            for(int j = 0; j < i; j++) {
                if(boxes[j] < boxes[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}