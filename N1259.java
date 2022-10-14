package BOJ;

import java.util.Scanner;

public class N1259 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            int word = input.nextInt();

            if(word == 0) break;

            String letter = Integer.toString(word);

            int i, status = 1;
            if(letter.length() % 2 == 0) {  // 길이가 짝수인 경우
                int index = letter.length() / 2 - 1;

                for(i = 0; i <= index; i++) {
                    // 양쪽 값을 비교
                    if(i == 0) {  // 중간값
                        if(letter.charAt(index) != letter.charAt(index + 1)) {
                            System.out.println("no");
                            status = 0;
                            break;
                        } 
                    } else {
                        if(letter.charAt(index - i) != letter.charAt(index + 1 + i)) {
                            System.out.println("no"); 
                            status = 0;
                            break;
                        }
                    }
                }

                if(status == 1) System.out.println("yes");

            } else {  // 길이가 홀수인 경우
                int index = letter.length() / 2;

                for(i = 0; i <= index; i++) {
                    // 양쪽 값을 비교
                    if(i != 0) {  // 중간값 제외
                        if(letter.charAt(index - i) != letter.charAt(index + i)) {
                            System.out.println("no");
                            status = 0;
                            break;
                        }
                    } 
                }

                if(status == 1) System.out.println("yes");
                
            }
        }

        input.close();
    }
}
