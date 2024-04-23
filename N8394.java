package BOJ;

/*
회의가 끝났고, 이제 악수를 하는 시간이다. 
모든 사람은 직사각형 탁자 하나의 한 면에 앉아있다.

자리를 벗어나지 않고 악수를 하는 방법의 수는 총 몇 가지일까?
각 사람들은 자신의 왼쪽이나 오른쪽에 있는 사람들과 악수를 할 수 있다. (안 할 수도 있다)

첫째 줄에 회의에 참석한 사람의 수 n (1 ≤ n ≤ 10,000,000)이 주어진다.

첫째 줄에 악수를 하는 방법의 수를 출력한다. 수가 매우 커질 수 있기 때문에, 마지막 자리만 출력한다.

4

5
 */

import java.io.*;

public class N8394 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        long[] DP = new long[N + 1];
        DP[1] = N == 1 ? 0 : 1;
        if(N >= 2) DP[2] = 2;
        
        for(int i = 3; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10;
        }

        System.out.println(DP[N]);
    }
}