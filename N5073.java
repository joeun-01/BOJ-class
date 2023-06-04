package BOJ;

/*
삼각형의 세 변의 길이가 주어질 때 변의 길이에 따라 다음과 같이 정의한다.

Equilateral :  세 변의 길이가 모두 같은 경우
Isosceles : 두 변의 길이만 같은 경우
Scalene : 세 변의 길이가 모두 다른 경우

단 주어진 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력한다. 
예를 들어 6, 3, 2가 이 경우에 해당한다. 가장 긴 변의 길이보다 나머지 두 변의 길이의 합이 길지 않으면 삼각형의 조건을 만족하지 못한다.

세 변의 길이가 주어질 때 위 정의에 따른 결과를 출력하시오.

각 줄에는 1,000을 넘지 않는 양의 정수 3개가 입력된다. 
마지막 줄은 0 0 0이며 이 줄은 계산하지 않는다.

각 입력에 맞는 결과 (Equilateral, Isosceles, Scalene, Invalid) 를 출력하시오.

7 7 7
6 5 4
3 2 5
6 2 6
0 0 0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            char save = 'a';
            int max = 0;
            
            int a = Integer.parseInt(stoi.nextToken());
            if(a > max) {
                max = a;
                save = 'a';
            }

            int b = Integer.parseInt(stoi.nextToken());
            if(b > max) {
                max = b;
                save = 'b';
            }

            int c = Integer.parseInt(stoi.nextToken());
            if(c > max) {
                max = c;
                save = 'c';
            }

            if(a == 0 && b == 0 && c == 0) break;

            if(save == 'a') {
                if(b + c > a) {
                    if(b == a && c == a) build.append("Equilateral\n");
                    else if(b == a || c == a) build.append("Isosceles\n");
                    else build.append("Scalene\n");
                } else {
                    build.append("Invalid\n");
                }
            } else if(save == 'b') {
                if(a + c > b) {
                    if(a == b && c == b) build.append("Equilateral\n");
                    else if(a == b && c == b) build.append("Isosceles\n");
                    else build.append("Scalene\n");
                } else {
                    build.append("Invalid\n");
                }
            } else if(save == 'c') {
                if(a + b > c) {
                    if(a == c && b == c) build.append("Equilateral\n");
                    else if(a == c && b == c) build.append("Isosceles\n");
                    else build.append("Scalene\n");
                } else {
                    build.append("Invalid\n");
                }
            }
        }

        System.out.println(build);
    }
}