package BOJ;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class N1157 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {        
            String word = input.nextLine();
            word = word.toUpperCase();  // 소문자로 통일
    
            int i;
            HashMap<Character, Integer> save = new HashMap<>();
            for(i = 0; i < word.length(); i++) {
                if(save.containsKey(word.charAt(i))) {  // 이미 있는 경우 + 1
                    save.put(word.charAt(i), save.get(word.charAt(i)) + 1);
                }
                else {
                    save.put(word.charAt(i), 1); // 없으면 1
                }
            }
    
            int maxValue = Collections.max(save.values());
            char max = ' ';
    
            for(Character key : save.keySet()) {
                if(save.get(key) == maxValue) {
                    if(max == ' ') {
                        max = key;
                    } else {
                        max = '?';
                    }
                }
            }
    
            System.out.println(max);

        } finally {
            input.close();
        }


    }
}