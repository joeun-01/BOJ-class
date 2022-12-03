package BOJ;

/*
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 
그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

첫째 줄에 식이 주어진다. 
식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 
수는 0으로 시작할 수 있다. 
입력으로 주어지는 식의 길이는 50보다 작거나 같다.

첫째 줄에 정답을 출력한다.

55-50+40

-35
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> number = new ArrayList<>();
        StringTokenizer input = new StringTokenizer(read.readLine(), "-");


        while(input.hasMoreTokens()) {
            number.add(input.nextToken());
        }

        int i = 0, sum = 0;
        while(i < number.size()) {
            if(i == 0) {
                StringTokenizer plus = new StringTokenizer(number.get(i), "+"); 

                while(plus.hasMoreTokens()) {
                    sum += Integer.parseInt(plus.nextToken());
                }
            } else {
                StringTokenizer plus = new StringTokenizer(number.get(i), "+"); 

                while(plus.hasMoreTokens()) {
                    sum -= Integer.parseInt(plus.nextToken());
                }
            }

            i++;
        }

        System.out.println(sum);
    }
}
