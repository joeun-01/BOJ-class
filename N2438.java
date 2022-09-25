package BOJ;

import java.util.Scanner;

public class N2438 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        int i, j;

        for(i = 0; i < num; i++) {
            for(j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
