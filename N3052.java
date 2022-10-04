package BOJ;

import java.util.HashMap;
import java.util.Scanner;

public class N3052 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int i;
            HashMap<Integer, Integer> dup = new HashMap<>();
    
            for(i = 0; i < 10; i++) {
                int num = input.nextInt();
                dup.put(num % 42, 0);
            }
    
            System.out.println(dup.size());
        } finally {
            input.close();
        }
    }
}
