package BOJ;

import java.util.Scanner;

public class N1152 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            String word = input.nextLine();
    
            int i;
            int num = 0;
        
            for(i = 0; i < word.length(); i++) {
                // index 범위 관리를 위해 맨 왼쪽과 맨 오른쪽은 검사하지 않음
                if(i != 0 && i != word.length() - 1) {
                    int left = (int) word.charAt(i - 1);
                    int right = (int) word.charAt(i + 1);
    
                    if(word.charAt(i) == ' ' && check(left) && check(right)) {
                        num++;
                    }
                }
                
            }
    
            if(num == 0) {
                String finalWold = word.replace(" ", "");
                if(finalWold.length() == 0) {
                    System.out.println(num);
                } else {
                    System.out.println(num + 1);
                }
    
            } else {
                System.out.println(num + 1);
            }
        }
        finally {
            input.close();
        }


    }

    public static boolean check(int letter) {
        if((65 <= letter && letter <= 90) || (97 <= letter && letter <= 122)) {
            return true;
        }
        else {
            return false;
        }
    }

}
