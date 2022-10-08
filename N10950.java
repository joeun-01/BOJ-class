package BOJ;

import java.util.Scanner;

public class N10950 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int num = input.nextInt();
            int size = num * 2;
    
            int i;
            int[] list = new int[size];
            for(i = 0; i < size; i++) {
                list[i] = input.nextInt();
            }   
    
            for(i = 0; i < num; i++) {
                System.out.println(list[i * 2] + list[i * 2 + 1]);
            }

        } finally {
            input.close();
        }
    }
}
