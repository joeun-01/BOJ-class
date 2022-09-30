package BOJ;

import java.util.Scanner;

public class N2739 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        try {
            int num = input.nextInt();

            int i;
            for(i = 1; i < 10; i++) {
                System.out.println(num + " * " + i + " = " + num * i);
            }
        } finally {
            input.close();
        }
    }
}
