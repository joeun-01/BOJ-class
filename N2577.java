package BOJ;

import java.util.Scanner;

public class N2577 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int i, mul = 1;
            for(i = 0; i < 3; i++) {
                int num = input.nextInt();
                mul *= num;
            }
    
            String total = ""+ mul;
            int[] numList = {0, 0, 0, 0, 0, 0, 0, 0, 0 , 0};
    
            for(i = 0; i < total.length(); i++) {
                numList[Integer.parseInt(total.substring(i, i + 1))]++;
            }
    
            for(i = 0; i < numList.length; i++) {
                System.out.println(numList[i]);
            }
        } finally {
            input.close();
        }
    }
}
