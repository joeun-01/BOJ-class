package BOJ;

/*
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 주어진 수들 중 소수의 개수를 출력한다.
 * 
 * 4
 * 1 3 5 7
 * 
 * 3
 */

import java.util.Scanner;

public class N1978 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int n = input.nextInt();
            int[] num = new int[n];
    
            int i, j;
            for(i = 0; i < n; i++) {
                num[i] = input.nextInt();
            }
    
            int cnt = 0;
            for(i = 0; i < n; i++) {
                int check = 1;
    
                if(num[i] == 2) cnt++;
    
                if(num[i] % 2 != 0 && num[i] >= 3) {  // 짝수는 소수가 될 수 없음, 3부터 시작
                    for(j = 3; j <= Math.pow(num[i], 0.5); j++) {
                        if(num[i] % j == 0) {  // 나누어 떨어지는 수가 있으면 소수가 아님
                            check = 0;
                            break;
                        }
                    }
    
                    if(check == 1) cnt++;
                }
            }
    
            System.out.println(cnt);
        } finally {
            input.close();
        }
    }
}
