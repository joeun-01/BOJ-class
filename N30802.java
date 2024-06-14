package BOJ;

import java.io.*;
import java.util.*;

public class N30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        int[] size = new int[6];
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < size.length; i++) {
            size[i] = Integer.parseInt(stoi.nextToken());
        }

        stoi = new StringTokenizer(read.readLine());
        int T = Integer.parseInt(stoi.nextToken());
        int P = Integer.parseInt(stoi.nextToken());

        int clothes = 0;
        for(int i = 0; i < size.length; i++) {
            int need = isInteger(T / (double) size[i]) ? (T / size[i]) : (T / size[i] + 1);
            clothes += need;
        }
        build.append(clothes);

        int pens = N / P;
        build.append(pens).append(" ");

        build.append(N % P);

        System.out.println(build);
    }

    public static boolean isInteger(double num) {
        return num == (int) num;
    }
}