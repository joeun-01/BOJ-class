package BOJ;

import java.util.Scanner;

public class N10809 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String s = input.nextLine();

            int i;
            for(i = 0; i < 26; i++) {
                char alpha = (char) (i + 97);
                System.out.println(s.indexOf(alpha));
            }
        } finally {
            input.close();
        }
    }
}
