package BOJ;

import java.util.Scanner;

public class N2884 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int hour = input.nextInt();
            int minute = input.nextInt();
    
            if(minute < 45) {  // 45분 미만인 경우
                if(hour != 0) {  // 0시 이상인 경우
                    hour -= 1;
                    minute += 15;
                } else {
                    hour = 23;
                    minute += 15;
                }
            } else {  // 45분 이상인 경우
                minute -= 45;
            }

            System.out.println(hour + " " + minute);
        } finally {
            input.close();
        }



    }
}