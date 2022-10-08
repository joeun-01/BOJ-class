package BOJ;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class N10950 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            int num = input.nextInt();
    
            int i;
            LinkedHashMap<Integer, Integer> list = new LinkedHashMap<>();
            for(i = 0; i < num; i++) {
                list.put(input.nextInt(), input.nextInt());
            }   
    
            for(int key : list.keySet()) {
                System.out.println(key + list.get(key));
            }
        } finally {
            input.close();
        }
    }
}
