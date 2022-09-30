package BOJ;

import java.util.Scanner;
import java.util.ArrayList;

public class N2675 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();
    
            int i;
            ArrayList<String> result = new ArrayList<>();
            for(i = 0; i < num; i++) {
                int repeat = input.nextInt();
                String word = input.nextLine();
    
                result.add(repeatWord(repeat, word.trim()));
            }
    
            for(i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        } finally {
            input.close();
        }
    }

    public static String repeatWord(int repeat, String word) {
        int i, j;
        String result = "";
        for(i = 0; i < word.length(); i++) {
            for(j = 0; j <repeat; j++) {
                result += word.charAt(i);
            }
        }

        return result;
    }
}
