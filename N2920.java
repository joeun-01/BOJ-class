package BOJ;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N2920 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int i;
            ArrayList<Integer> origin = new ArrayList<>();
    
            for(i = 0; i < 8; i++) {
                int num = input.nextInt();
                origin.add(num);
            }
    
            ArrayList<Integer> sort = (ArrayList<Integer>) origin.clone();
            
            Collections.sort(sort);
            if(origin.equals(sort)) {
                System.out.println("ascending");
            } else {
                Collections.sort(sort, Collections.reverseOrder());
                if(origin.equals(sort)) {
                    System.out.println("descending");
                } else {
                    System.out.println("mixed");
                }
            }
        } finally {
            input.close();      
        }
    }   
}
