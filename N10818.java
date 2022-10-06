package BOJ;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N10818 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            int num = input.nextInt();

            int i;
            ArrayList<Integer> sort = new ArrayList<>();
            for(i = 0; i < num; i++) {
                int number = input.nextInt();
                sort.add(number);
            }
    
            Collections.sort(sort);

            System.out.println(sort.get(0) + " " + sort.get(num - 1));
        } finally {
            input.close();
        }
    }
}
