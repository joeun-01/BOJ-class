package BOJ;

/*
세 수 A, B, C가 주어진다. 
A는 B보다 작고, B는 C보다 작다.

세 수 A, B, C가 주어졌을 때, 입력에서 주어진 순서대로 출력하는 프로그램을 작성하시오.

첫째 줄에 세 수 A, B, C가 주어진다. 
하지만, 순서는 A, B, C가 아닐 수도 있다. 
세 수는 100보다 작거나 같은 자연수이다. 
둘째 줄에는 A, B, C로 이루어진 세 글자가 주어지며, 이 순서대로 출력하면 된다.

주어진 세 수를 주어진 출력 순서대로 출력하면 된다.

1 5 3
ABC

1 3 5
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class N3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        String order = read.readLine();

        int[] array = new int[3];
        for(int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(stoi.nextToken()); 
        }

        Arrays.sort(array);

        for(int i = 0; i < 3; i++) {
            char alpha = order.charAt(i);

            if(alpha == 'A') build.append(array[0] + " ");
            else if(alpha == 'B') build.append(array[1] + " ");
            else if(alpha == 'C') build.append(array[2] + " ");
        }

        System.out.println(build);
    }
}
