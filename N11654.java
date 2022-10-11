package BOJ;

import java.util.Scanner;

public class N11654 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String code = input.nextLine();
        
        int ascii = (int) code.charAt(0);
        System.out.println(ascii);

        input.close();
    }
}
