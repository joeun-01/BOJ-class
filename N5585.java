package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(read.readLine());
        int change = 1000 - money;

        int cnt = 0, temp = 0;
        int[] options = {500, 100, 50, 10, 5};

        for(int i = 0; i < options.length; i++) {
            temp = change / options[i];
            change = change - temp * options[i];
            cnt += temp;
        }
        
        cnt += change;

        System.out.println(cnt);
    }
}