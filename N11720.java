package BOJ;

import java.util.Scanner;

public class N11720 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int index = input.nextInt();
            input.nextLine();
            String num = input.nextLine();
    
            int i, sum = 0;
            for(i = 0; i < index; i++) {
                sum += num.charAt(i) - '0';
            }
    
            System.out.println(sum);
        } finally {
            input.close();
        }
    }   
}
