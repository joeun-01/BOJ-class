package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N27930 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String S = read.readLine();

        char[] korea = {'K', 'O', 'R', 'E', 'A'};
        char[] yonsei = {'Y', 'O', 'N', 'S', 'E', 'I'};

        int k = 0, y = 0;
        for(int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);

            if(letter == korea[k]) {
                k++;

                if(k == korea.length) {
                    System.out.println("KOREA");
                    System.exit(0);
                }
            } 
            
            if(letter == yonsei[y]) {
                y++;

                if(y == yonsei.length) {
                    System.out.println("YONSEI");
                    System.exit(0);
                }
            }
        }
    }
}