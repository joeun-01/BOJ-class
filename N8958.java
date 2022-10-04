package BOJ;

import java.util.Scanner;

public class N8958 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();
            input.nextLine();
            String[] ox = new String[num];
            
            int i;
            for(i = 0; i < num; i++) {
                ox[i] = input.nextLine();
            }
    
            int j;
            for(i = 0; i < num; i++) {
                int o = 0, score = 0;
                for(j = 0; j < ox[i].length(); j++) {
                    if(ox[i].charAt(j) == 'O') {
                        o++;
                        score += o;
                    } else {
                        o = 0;
                    }
                }
                
                System.out.println(score);
            }
        } finally {
            input.close();
        }
    }
}
