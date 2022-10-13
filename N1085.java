package BOJ;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N1085 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        int w = input.nextInt();
        int h = input.nextInt();

        ArrayList<Integer> min = new ArrayList<>();

        min.add(x);
        min.add(y);
        min.add(w - x);
        min.add(h - y);

        Collections.sort(min);

        System.out.println(min.get(0));

        input.close();
    }
}