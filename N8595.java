package BOJ;

/*
단어에 숫자가 숨어있다. 
이 숫자를 히든 넘버라고 한다. 
알파벳 대/소문자와 숫자로 이루어진 단어가 주어졌을 때, 모든 히든 넘버의 합을 구하는 프로그램을 작성하시오.

단어와 히든 넘버는 아래와 같은 성질을 갖는다.

연속된 숫자는 한 히든 넘버이다.
두 히든 넘버 사이에는 글자가 적어도 한 개 있다.
히든 넘버는 6자리를 넘지 않는다.

첫째 줄에 단어의 길이 n (1 ≤ n ≤ 5,000,000)이 주어진다. 
둘째 줄에는 단어가 주어진다. 
단어는 알파벳 대/소문자와 숫자(0-9)로 이루어져 있다. 

입력으로 주어진 단어에 숨어있는 모든 히든 넘버의 합을 출력한다. 
만약, 히든 넘버가 없는 경우에는 0을 출력한다.

14
ab13c9d07jeden

29
 */

import java.io.*;
import java.util.StringTokenizer;

public class N8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(read.readLine());
        String str = read.readLine();

        String intStr = str.replaceAll("[^0-9]", " ");

        // System.out.println(intStr);

        long sum = 0;

        StringTokenizer stoi = new StringTokenizer(intStr);
        while(stoi.hasMoreTokens()) {
            sum += Integer.parseInt(stoi.nextToken());
        }

        System.out.println(sum);
    }
}
