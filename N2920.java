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
            if(origin.equals(sort)) {  // 오름차순
                System.out.println("ascending");
            } else {  // 이 아니면
                Collections.sort(sort, Collections.reverseOrder());
                if(origin.equals(sort)) {  // 내림차순 검색
                    System.out.println("descending");
                } else {  // 마저도 아니면 mix
                    System.out.println("mixed");
                }
            }
        } finally {
            input.close();      
        }
    }   
}
