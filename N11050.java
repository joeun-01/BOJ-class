package BOJ;

/*
 * 자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 
 * \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤ \(K\) ≤ \(N\))
 * 
 *  \(\binom{N}{K}\)를 출력한다. 
 * 
 * 5 2
 * 
 * 10
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class N11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String input = read.readLine();
        String[] split = input.split(" ");

        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        int index = k;

        int i, deno = n;
        for(i = 0; i < index - 1; i++) {
            n--;
            deno *= n; 
            System.out.println(i + " : " + deno);
        }

        int nume = k;
        for(i = 0; i < index - 1; i++) {
            k--;
            nume *= k;
            System.out.println(i + " : " + nume);
        }

        if(nume != 0) {
            build.append(deno / nume);
        } else if(nume == 0) {
            build.append(1);
        }

        System.out.println(build);
    }
}