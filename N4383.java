package BOJ;

/*
Jolly jumper라 불리는 수열이 있다. 
길이가 1인 수열은 무조건 Jolly jumper이고, 길이가 2이상일 때는 n개의 연속된 두 수의 차의 절댓값이 1부터 n-1까지 모두 나와야 Jolly jumper라고 한다. 
예를 들어 1 4 2 3 이것은 Jolly jumper인데, 두 수의 차의 절댓값이 각각 3,2,1이기 때문이다. 
하여튼 조건을 충족하면 어느 수열이든 Jolly jumper라 할 수 있다. 
이제 각 케이스마다 Jolly jumper인지를 판별하자.

각 줄의 첫 수로 n이 주어진다.(n < 3000) 
그 다음에는 n개의 수가 주어진다.

각 줄마다 Jolly 인지 Not jolly 인지 출력한다.

4 1 4 2 3
5 1 4 2 -1 6

Jolly
Not jolly
 */

import java.io.*;
import java.util.StringTokenizer;

public class N4383 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while((str = read.readLine()) != null) {
            StringTokenizer stoi = new StringTokenizer(str);
            int N = Integer.parseInt(stoi.nextToken());

            boolean[] diff = new boolean[N + 1];
            int prev = Integer.parseInt(stoi.nextToken());
            for(int i = 1; i < N; i++) {
                int number = Integer.parseInt(stoi.nextToken());

                int abs = Math.abs(prev - number);
                if(0 < abs && abs < N) diff[abs] = true;
                prev = number;
            }

            boolean result = true;
            for(int i = 1; i < N; i++) {
                if(!diff[i]) {
                    result = false;
                }
            }

            if(result) System.out.println("Jolly");
            else System.out.println("Not jolly");
        }
    }
}
