package BOJ;

/*
초등학생인 도겸이는 숫자를 좋아한다. 
어느 날 도겸이는 숫자 책을 보다가 간단한 놀이를 하나 생각해냈다. 
숫자 놀이의 규칙은 다음과 같다.

1. 주어진 숫자의 각 자릿수를 더한다.
2. 결과가 한 자릿수가 될 때 까지 규칙1을 반복한다.
예를들어, 숫자 673에 규칙을 적용해보면 결과는 7이 된다 ; 6 + 7 + 3 = 16, 1 + 6 = 7 

도겸이는 당신과 함께 숫자놀이를 하고싶어한다. 
도겸이가 주는 숫자들을 풀어보자.

각 줄에 숫자 N이 주어진다. 
N은 100,000보다 작은 양의 정수이다. 
마지막 입력은 0이며, 0에 대한 결과는 출력하지 않는다.

한 줄에 하나씩 한 자릿수 결과를 출력한다.

673
51
1000
99
0

7
6
1
9
 */

import java.io.*;

public class N2145 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            String N = read.readLine();
            if(N.equals("0")) break;

            while(true) {
                int sum = 0;
                for(int i = 0; i < N.length(); i++) {
                    sum += Integer.parseInt(N.substring(i, i + 1));
                }

                N = Integer.toString(sum);
                if(N.length() == 1) break;
            }

            build.append(N + "\n");
        }

        System.out.println(build);
    }
}