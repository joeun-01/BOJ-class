package BOJ;

/*
지민이는 길이가 64cm인 막대를 가지고 있다. 
어느 날, 그는 길이가 Xcm인 막대가 가지고 싶어졌다. 
지민이는 원래 가지고 있던 막대를 더 작은 막대로 자른다음에, 풀로 붙여서 길이가 Xcm인 막대를 만들려고 한다.

막대를 자르는 가장 쉬운 방법은 절반으로 자르는 것이다. 
지민이는 아래와 같은 과정을 거쳐서 막대를 자르려고 한다.

1. 지민이가 가지고 있는 막대의 길이를 모두 더한다. 처음에는 64cm 막대 하나만 가지고 있다. 이때, 합이 X보다 크다면, 아래와 같은 과정을 반복한다.
2. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자른다.
3. 만약, 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버린다.
4. 이제, 남아있는 모든 막대를 풀로 붙여서 Xcm를 만든다.

X가 주어졌을 때, 위의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 구하는 프로그램을 작성하시오. 

첫째 줄에 X가 주어진다.
X는 64보다 작거나 같은 자연수이다.

문제의 과정을 거친다면, 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지 출력한다.

23

4
 */

import java.io.*;

public class N1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // X = 23
        // 32 | 32
        // 16 16
        // 16 8 | 8
        // 16 4 4
        // 16 4 2 2
        // 16 4 2 1 | 1 

        // X = 25
        // 32 | 32
        // 16 16
        // 16 8 8
        // 16 8 4 | 4
        // 16 8 2 | 2 
        // 16 8 1 | 1

        int X = Integer.parseInt(read.readLine());
        int length = 64, cut = 1, tiny = 64;
        while(true) {
            if(length == X) break;

            tiny /= 2;  // 가장 짧은 막대를 반으로 자름

            if(length - tiny >= X) length -= tiny;  // 자른 막대의 반을 버려도 괜찮으면 버림
            else cut++;
        }

        System.out.println(cut);
    }
}
