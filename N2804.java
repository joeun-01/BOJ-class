package BOJ;

/*
창영이는 크로스워드 퍼즐을 만들려고 한다.

두 단어 A와 B가 주어진다. 
A는 가로로 놓여야 하고, B는 세로로 놓여야 한다. 
또, 두 단어는 서로 교차해야 한다. (정확히 한 글자를 공유해야 한다) 
공유하는 글자는 A와 B에 동시에 포함되어 있는 글자여야 하고, 그런 글자가 여럿인 경우 A에서 제일 먼저 등장하는 글자를 선택한다. 
마찬가지로 이 글자가 B에서도 여러 번 등장하면 B에서 제일 처음 나오는 것을 선택한다. 
예를 들어, A = "ABBA"이고, B = "CCBB"라면, 아래와 같이 만들 수 있다.

.C..
.C..
ABBA
.B..

첫째 줄에 두 단어 A와 B가 주어진다. 
두 단어는 30글자 이내이고, 공백으로 구분되어져 있다. 
또, 대문자로만 이루어져 있고, 적어도 한 글자는 두 단어에 포함되어 있다.

A의 길이를 N, B의 길이를 M이라고 했을 때, 출력은 총 M줄이고, 각 줄에는 N개 문자가 있어야 한다. 
문제 설명에 나온 것 같이 두 단어가 교차된 형태로 출력되어야 한다. 
나머지 글자는 '.'로 출력한다.

BANANA PIDZAMA

.P....
.I....
.D....
.Z....
BANANA
.M....
.A....
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2804 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        String A = stoi.nextToken();
        String B = stoi.nextToken();

        // A와 B의 교차점 찾기
        int row = 0, col = -1;
        for(row = 0; row < A.length(); row++) {
            char c = A.charAt(row);
            col = B.indexOf(c);

            if(col != -1) break;
        }

        for(int i = 0; i < B.length(); i++) {
            for(int j = 0; j < A.length(); j++) {
                if(i == col && j == row) {
                    build.append(A.charAt(j));
                } else if(i == col) {
                    build.append(A.charAt(j));
                } else if(j == row) {
                    build.append(B.charAt(i));
                } else {
                    build.append(".");
                }
            }

            build.append("\n");
        }

        System.out.println(build);
    }
}