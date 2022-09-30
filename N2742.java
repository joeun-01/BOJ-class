package BOJ;

import java.util.Scanner;

public class N2742 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();

            int i;
            for(i = num; i > 0; i--) {
                System.out.println(i);
            }
        } finally {
            input.close();
        }
    }
}
