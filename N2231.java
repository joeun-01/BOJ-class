package BOJ;

/*
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
 * 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 
 * 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
 * 
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 * 
 * 216
 * 
 * 198
 */

import java.util.Scanner;

public class N2231 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextInt();

        
        if(n == 0 || n == 1) {
            System.out.println(0);
        } else {
            int check = 0;

            int i, j;
            
            for(i = (int) n / 2; i < n; i++) {  // 어짜피 절반 아래면 답이 되기 어렵다고 생각해서 이상부터 체크
                String num = Integer.toString(i);  // 자릿수를 더하기 위해서 String으로 만들어줌
                long sum = i;  // 생성자 + 생성자의 각 자릿수

                for(j = 0; j < num.length(); j++) {
                    sum += Integer.parseInt(num.substring(j, j + 1));
                }

                if(sum == n) {
                    check = 1;
                    System.out.println(i);  // 가장 작은 생성자가 나오면 바로 출력
                    break;
                }
            }

            if(check == 0) System.out.println(0);
        }

        input.close();
    }    
}
