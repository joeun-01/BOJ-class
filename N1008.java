package BOJ;

import java.util.Scanner;

public class N1008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        double divide = a / (double)b;

        System.out.println(String.format("%.9f", divide));

        in.close();
    }
}