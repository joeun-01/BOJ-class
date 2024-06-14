package BOJ;

/*
2024년 2월 3일 개최 예정인 온사이트 그랜드 아레나에서는 참가자들에게 티셔츠 한 장과 펜 한 자루가 포함된 웰컴 키트를 나눠줄 예정입니다. 
키트를 제작하는 업체는 다음과 같은 조건으로만 주문이 가능합니다.

티셔츠는 S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈가 있습니다. 
티셔츠는 같은 사이즈의 T장 묶음으로만 주문할 수 있습니다.
펜은 한 종류로, P자루씩 묶음으로 주문하거나 한 자루씩 주문할 수 있습니다.
총 N명의 참가자 중 S, M, L, XL, XXL, XXXL 사이즈의 티셔츠를 신청한 사람은 각각 S, M, L, XL, XXL, XXXL명입니다. 
티셔츠는 남아도 되지만 부족해서는 안 되고 신청한 사이즈대로 나눠주어야 합니다. 
펜은 남거나 부족해서는 안 되고 정확히 참가자 수만큼 준비되어야 합니다.

티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지, 그리고 펜을 P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

첫 줄에 참가자의 수 N이 주어집니다. (1 <= N <= 10^9)
둘째 줄에 티셔츠 사이즈별 신청자의 수 S, M, L, XL, XXL, XXXL이 공백으로 구분되어 주어집니다. (0 <= S, M, L, XL, XXL, XXXL <= N; S + M + L + XL + XXL + XXXL = N)
셋째 줄에 정수 티셔츠와 펜의 묶음 수를 의미하는 정수 T와 P가 공백으로 구분되어 주어집니다. (2 <= T, P <= 10^9)

첫 줄에 티셔츠를 T장씩 최소 몇 묶음 주문해야 하는지 출력하세요.
다음 줄에 펜을 P자루씩 최대 몇 묶음 주문할 수 있는지와, 그 때 펜을 한 자루씩 몇 개 주문하는지 구하세요.

23
3 1 4 1 5 9
5 7

7
3 2
 */

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
            int need = isInteger((double) size[i] / T) ? (size[i] / T) : (size[i] / T) + 1;
            clothes += need;
        }
        build.append(clothes).append("\n");

        int pens = N / P;
        build.append(pens).append(" ");

        build.append(N % P);

        System.out.println(build);
    }

    public static boolean isInteger(double num) {
        return num == (int) num;
    }
}