package BOJ;

/*
당신은 학생들의 기초수학 학습을 돕는 소프트웨어를 개발하는 팀의 개발자이다. 
당신은 가분수를 대분수(?)로 출력하는 부분을 개발해야 한다. 
진분수는 분자가 분모보다 작은 분수이다; 
대분수는 정수부를 따로 떼어주고 남는 부분을 진분수로 쓰는 기법이다. 
예제로, 27/12는 대분수로 2 3/12이다. 
기약분수로 만들지 말아야 한다.(3/12를 1/4로 바꿔 출력하지 마시오.)

한 줄에 걸쳐 한 테스트 케이스가 입력된다. 
각각의 테스트 케이스는 [1, 2^31 - 1]범위의 두 정수가 입력된다. 
첫 번째 정수는 분자고 두 번째는 분모이다. 
"0 0" 입력이 들어오는 라인에서 입력을 종료한다.

각 테스트 케이스에 대해 한 줄에 걸쳐 주어진 입력에 맞는 대분수를 공백토큰으로 구분하여 출력하라.

27 12
2460000 98400
3 4000
0 0

2 3 / 12
25 0 / 98400
0 3 / 4000
 */

import java.io.*;
import java.util.StringTokenizer;

public class N10474 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int numerator = Integer.parseInt(stoi.nextToken());
            int denominator = Integer.parseInt(stoi.nextToken());

            if(numerator == 0 && denominator == 0) {
                break;
            }

            int quotient = numerator / denominator;
            int remainder = numerator % denominator;

            build.append(quotient + " " + remainder + " / " + denominator);
            build.append("\n");
        }

        System.out.println(build);
    }
}
