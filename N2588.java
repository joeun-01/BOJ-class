package BOJ;

/*
세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.

첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.

첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.

472
385

2360
3776
1416
181720
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());
        String str = read.readLine();
        
        int mul = 0;
        for(int i = 3; i > 0; i--) {
            int parse = Integer.parseInt(str.substring(i - 1, i));
            build.append(num * parse + "\n");
            mul += num * parse * Math.pow(10, 3 - i);
        }
        build.append(mul + "\n");

        System.out.println(build);
    }
}