package BOJ;

/*
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 * 
 * 24 18
 * 6 72
 */

import java.util.Scanner;

public class N2609 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int a = input.nextInt();
        int b = input.nextInt();

        // 최소공배수는 a * b / 최대공약수
        int gcd = euclid(Math.max(a, b), Math.min(a, b));
        int lcm = a * b / gcd;
        
        System.out.println(gcd + " " + lcm);

        input.close();
    }

    public static int euclid(int a, int b) {
        if(b == 0) return a;
        else return euclid(b, a % b);
    }
}
