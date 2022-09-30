package BOJ;

import java.util.Scanner;

public class N2741 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();

            int i;
            for(i = 1; i <= num; i++) {
                System.out.println(i);
            }
        } finally {
            input.close();
        }
    }
}