package BOJ;

import java.util.Scanner;

public class N10871 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();
            int standard = input.nextInt();
    
            int[] numList = new int[num];
    
            int i;
            for(i = 0; i < num; i++) {
                numList[i] = input.nextInt();
            }
    
            for(i = 0; i < num; i++) {
                if(numList[i] < standard) {
                    System.out.print(numList[i] + " ");
                }
            }
        } finally {
            input.close();
        }
    }
}
