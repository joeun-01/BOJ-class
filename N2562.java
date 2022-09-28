package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N2562 {
    public static void main(String[] main) {
        Scanner input = new Scanner(System.in);

        int i;
        int[] origin = new int[9];
        ArrayList<Integer> copy = new ArrayList<>();

        for(i = 0; i < 9; i++) {
            origin[i] = input.nextInt();
            copy.add(origin[i]);
        }

        Collections.sort(copy);

        System.out.println(copy.get(8));

        for(i = 0; i < 9; i++) {
            if(copy.get(8) == origin[i]) {
                System.out.println(i);
            }
        }

    }
    
}
