package BOJ;

import java.util.Scanner;

public class N2475 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sum = 0;
        try {
            int i;
            int[] num = new int[5];
            for(i = 0; i < 5; i++) {
                num[i] = input.nextInt();
                sum += Math.pow(num[i], 2);
            }
            System.out.println(sum % 10);
        } finally {
            input.close();
        } 
    }
}
