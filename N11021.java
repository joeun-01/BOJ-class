package BOJ;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 
테스트 케이스 번호는 1부터 시작한다.

5
1 1
2 3
3 4
9 8
5 2

Case #1: 2
Case #2: 5
Case #3: 7
Case #4: 17
Case #5: 7
 */

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class N11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());

        for(int i = 1; i <= T; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int A = Integer.parseInt(stoi.nextToken());
            int B = Integer.parseInt(stoi.nextToken());

            build.append("Case #" + i + ": " + (A + B) + "\n");
        }

        System.out.println(build);
    }
}
