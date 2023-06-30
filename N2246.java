package BOJ;

/*
콘도를 선정할 때에는 가급적이면 싸고 바닷가에 가까운 곳으로 하려 한다. 
이를 위해 우선 적당한 콘도 몇 곳을 후보로 선정하려 하는데, 다음 두 조건을 만족하는 콘도 X가 후보가 된다.

1. X보다 바닷가에 더 가까운 콘도들은 모두 X보다 숙박비가 더 비싸다.
2. X보다 숙박비가 더 싼 콘도들은 모두 X보다 바닷가에서 더 멀다.
각 콘도의 바닷가에서의 거리와 숙박비에 대한 정보가 주어졌을 때, 후보 콘도의 개수를 구해내는 프로그램을 작성하시오.

첫째 줄에 콘도의 개수를 나타내는 자연수 N(1 ≤ N ≤ 10,000)이 주어진다. 
다음 N개의 줄에는 각 콘도에 대한 정보를 나타내는 두 정수 D(1 ≤ D ≤ 10,000), C(1 ≤ C ≤ 10,000)가 주어진다. 
D는 그 콘도의 바닷가로부터의 거리를 나타내고, C는 그 콘도의 숙박비를 나타낸다. 
서로 다른 두 콘도의 D 값과 C값이 모두 같은 입력은 주어지지는 않는다.

첫째 줄에 후보가 될 수 있는 콘도의 수를 출력한다.

5
300 100
100 300
400 200
200 400
100 500

2
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2246 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        int[][] condo = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int D = Integer.parseInt(stoi.nextToken());  // 거리
            int C = Integer.parseInt(stoi.nextToken());  // 금액

            condo[i][0] = D;
            condo[i][1] = C;
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            int[] X = condo[i];

            Boolean isX = true;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                if(X[0] > condo[j][0] && X[1] >= condo[j][1]) {
                    isX = false;
                    break;
                }

                if(X[1] > condo[j][1] && X[0] >= condo[j][0]) {
                    isX = false;
                    break;
                }
            }
            
            if(isX) result++;

        }

        System.out.println(result);
    }
}
