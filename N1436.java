package BOJ;

import java.util.Scanner;

public class N1436 {
    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
    
        int cnt = 0;
    
        int num = 666;
        while(true) {
            String numStr = Integer.toString(num);

            if(numStr.contains("666")) {  // 666이 포함되어있는지 확인
                cnt++;
            }

            if(n == cnt) break;

            num++;
        }
        
        System.out.println(num);

        input.close();
    }
}
