package BOJ;

/*
옛날에는 결정하기 어려운 일이 있을 때는 꽃을 이용해서 결정을 내렸다. 
꽃을 하나 떼서 잎을 하나씩 떼면서, 한다와 안한다를 번갈아 가면서 말하다가 마지막 잎을 뗄 때 말한 말로 결정을 했다.

상근이는 이 방법을 응용해서 결정하기 어려운 일을 하나 결정하려고 한다.

먼저, 0과 1로 이루어진 문자열을 랜덤으로 하나 만든다. 
그 다음 문자열의 양 끝에서 수를 하나씩 고르고, 두 수를 비교한다. 
수가 같으면 "한다"이고, 다르면 "안한다"이다. 
그 다음에는 고른 수를 버리고, 모든 수를 고를 때까지 이 작업을 반복한다. 
따라서, 마지막으로 고르는 두 숫자로 결정을 내리는 것이다.

0과 1로 이루어진 문자열이 주어졌을 때, 상근이가 내리는 결정을 구하는 프로그램을 작성하시오.

첫째 줄에는 테스트 케이스의 개수 N이 주어진다. (1 ≤ N ≤ 1000) 
각 테스트 케이스는 한 줄로 이루어져 있으며, 0과 1로 이루어진 문자열이 주어진다. 
문자열의 길이는 항상 짝수이고, 1000보다 작다.

각 테스트 케이스에 대해서 상근이가 내린 결정이 한다이면 Do-it을, 안한다이면 Do-it-Not을 출력한다. 

3
00100010
01010101
100001

Do-it
Do-it-Not
Do-it
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            String str = read.readLine();

            int length = str.length();
            int left = length / 2 - 1, right = length / 2;

            if(str.charAt(left) == str.charAt(right)) build.append("Do-it\n");
            else build.append("Do-it-Not\n");
        }

        System.out.println(build);
    }
}