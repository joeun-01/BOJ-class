package BOJ;

/*
어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.

A+: 4.3, A0: 4.0, A-: 3.7
B+: 3.3, B0: 3.0, B-: 2.7
C+: 2.3, C0: 2.0, C-: 1.7
D+: 1.3, D0: 1.0, D-: 0.7
F: 0.0

첫째 줄에 C언어 성적이 주어진다. 성적은 문제에서 설명한 13가지 중 하나이다.

첫째 줄에 C언어 평점을 출력한다.

A0

4.0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String grade = read.readLine();

        switch(grade) {
            case "A+" :
                System.out.println(4.3);
                break;
            case "A0" :
                System.out.println(4.0);
                break;
            case "A-" :
                System.out.println(3.7);
                break;    
            case "B+" :
                System.out.println(3.3);
                break;
            case "B0" :
                System.out.println(3.0);
                break;
            case "B-" :
                System.out.println(2.7);
                break;
            case "C+" :
                System.out.println(2.3);
                break;
            case "C0" :
                System.out.println(2.0);
                break;
            case "C-" :
                System.out.println(1.7);
                break;
            case "D+" :
                System.out.println(1.3);
                break;
            case "D0" :
                System.out.println(1.0);
                break;
            case "D-" :
                System.out.println(0.7);
                break;
            case "F" :
                System.out.println(0.0);
                break;
        }
    }
}