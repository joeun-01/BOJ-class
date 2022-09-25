package BOJ;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N1546 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int num = input.nextInt();
        
            int i;
            ArrayList<Float> scoreList = new ArrayList<>(); 
            for(i = 0; i < num; i++) {
                Float score = input.nextFloat();
                scoreList.add(score);
            }
    
            Collections.sort(scoreList);
    
            float avg = 0;
            float max = scoreList.get(num - 1);
            for(i = 0; i < num; i++) {
                scoreList.set(i, scoreList.get(i) / max * 100);
                avg += scoreList.get(i);
            }
    
            System.out.println(String.format("%.2f", avg / (float) num));
    
        } finally {
            input.close();
        }
    }
}
