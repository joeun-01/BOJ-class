package BOJ;

/*
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) 
 * M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 * 
 * 에라토스테네스의 체..?
 */

import java.util.Scanner;

public class N1929 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            long m = input.nextInt();
            long n = input.nextInt();

            long i, j;
            for(i = m; i <= n; i++) {
                int check = 0;

                if(i == 2) System.out.println("2");

                if(i % 2 != 0 && i >= 3) {  // 짝수는 소수가 될 수 없고 판별을 3부터 시작
                    for(j = 3; j <= Math.pow(i, 0.5); j++) {  // 범위는 i^0.5 까지, 그 이후는 의미 X 
                        if(j % 2 == 1) {  // 짝수는 볼 필요 없음
                            if(i % j == 0) {  // j로 나눴을 때 나머지 없이 나눠떨어지는 게 있으면 소수가 아님
                                check = 1;
                                break;
                            } 
                        }
                    }

                    if(check == 0) System.out.println(i);
                }
            }
        } finally {
            input.close();
        }
    }
}