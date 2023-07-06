package BOJ;

/*
오늘은 갑자기 주사위를 던지고 싶다.
그런데 코딩도 하고 싶다.
그럼 같이할까?

첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 주사위를 두 번 던져 나온 두 수를 입력한다.

각 테스트 케이스마다 "Case x: "를 출력한 다음, 주사위를 두 번 던져 나온 두 수의 합을 출력한다. 
테스트 케이스 번호(x)는 1부터 시작한다.

5
1 2
1 3
3 5
2 6
3 4

Case 1: 3
Case 2: 4
Case 3: 8
Case 4: 8
Case 5: 7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N9295 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        for(int i = 1; i <= T; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int a = Integer.parseInt(stoi.nextToken());
            int b = Integer.parseInt(stoi.nextToken());

            build.append("Case " + i + ": " + (a + b) + "\n");
        }

        System.out.println(build);
    }
}
