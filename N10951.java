package BOJ;

import java.util.Scanner;

public class N10951 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            System.out.println(input.nextInt() + input.nextInt());
        }

        input.close();
    }
}
