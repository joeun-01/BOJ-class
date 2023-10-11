package BOJ;

/*
숫자와 콤마로만 이루어진 문자열 S가 주어진다. 
이때, S에 포함되어있는 자연수의 합을 구하는 프로그램을 작성하시오.

S의 첫 문자와 마지막 문자는 항상 숫자이고, 콤마는 연속해서 주어지지 않는다. 
주어지는 수는 항상 자연수이다.

문자열 S가 여러 줄에 걸쳐서 주어진다. 
S의 길이는 최대 10,000이다. 
포함되어있는 정수는 1,000,000보다 작거나 같은 자연수이다.

문자열 S에 포함되어 있는 자연수의 합을 출력한다.

10,20,
3
0,50
,1
00

210
 */

import java.io.*;
import java.util.StringTokenizer;

public class N10823 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = "", result = "";
        while((str = read.readLine()) != null) {
            result += str;
        }

        long sum = 0;
        StringTokenizer stoi = new StringTokenizer(result, ",");
        while(stoi.hasMoreTokens()) {
            sum += Integer.parseInt(stoi.nextToken());
        }

        System.out.println(sum);
    }
}
