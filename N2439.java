package BOJ;

import java.util.Scanner;

public class N2439 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        
        int num = input.nextInt();

        int i, j;
        for(i = 0; i < num; i++) {
            for(j = num - 1; j >= 0; j--) {
                if(i >= j) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}