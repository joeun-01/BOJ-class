package BOJ;

/*
어떤 수 X가 주어졌을 때, X의 모든 자리수가 역순이 된 수를 얻을 수 있다. 
Rev(X)를 X의 모든 자리수를 역순으로 만드는 함수라고 하자. 
예를 들어, X=123일 때, Rev(X) = 321이다. 
그리고, X=100일 때, Rev(X) = 1이다.

두 양의 정수 X와 Y가 주어졌을 때, Rev(Rev(X) + Rev(Y))를 구하는 프로그램을 작성하시오.

첫째 줄에 수 X와 Y가 주어진다. 
X와 Y는 1,000보다 작거나 같은 자연수이다.

첫째 줄에 문제의 정답을 출력한다.

123 100

223
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1357 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int X = Integer.parseInt(stoi.nextToken());
        int Y = Integer.parseInt(stoi.nextToken());

        int revX = 0;
        while(true) {
            revX = revX * 10 + X % 10;

            X /= 10;

            if(X < 1) break;
        }

        int revY = 0;
        while(true) {
            revY = revY * 10 + Y % 10;

            Y /= 10;

            if(Y < 1) break;
        }

        int V = revX + revY, revV = 0;
        while(true) {
            revV = revV * 10 + V % 10;

            V /= 10;

            if(V < 1) break;
        }

        System.out.println(revV);
    }
}
