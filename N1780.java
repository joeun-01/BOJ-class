package BOJ;

/*
N×N크기의 행렬로 표현되는 종이가 있다. 
종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 
우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1

10
12
11
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class N1780 {
    static int[][] chart;

    static int minus;
    static int zero;
    static int plus;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());
        chart = new int[num][num];

        for(int i = 0; i < num; i++) {
            StringTokenizer row = new StringTokenizer(read.readLine());
            
            int j = 0;
            while(row.hasMoreTokens()) {
                chart[i][j] = Integer.parseInt(row.nextToken());
                j++;
            }
        }

        recursive(0, num, 0, num);

        build.append(minus + "\n");
        build.append(zero + "\n");
        build.append(plus + "\n");

        System.out.println(build);

    }

    public static void recursive(int rs, int re, int cs, int ce) {
        // System.out.println(rs + " " + re + " " + cs + " " + ce);
        int standard = chart[rs][cs];
        
        if(rs + 1 == re || cs + 1 == ce) {
            // 칸 개수가 하나면 바로 return
            if(standard == 0) zero++;
            else if(standard == 1) plus++;
            else if(standard == -1) minus++;

            return;
        }
        
        int interval = (re - rs) / 3;

        for(int i = rs; i < re; i++) {
            for(int j = cs; j < ce; j++) {
                if(chart[i][j] != standard) {
                    // 9칸으로 쪼개기
                    recursive(rs, rs + interval, cs, cs + interval);
                    recursive(rs, rs + interval, cs + interval, cs + interval * 2);
                    recursive(rs, rs + interval, cs + interval * 2, ce);

                    recursive(rs + interval, rs + interval * 2, cs, cs + interval);
                    recursive(rs + interval, rs + interval * 2, cs + interval, cs + interval * 2);
                    recursive(rs + interval, rs + interval * 2, cs + interval * 2, ce);

                    recursive(rs + interval * 2, re, cs, cs + interval);
                    recursive(rs + interval * 2, re, cs + interval, cs + interval * 2);
                    recursive(rs + interval * 2, re, cs + interval * 2, ce);

                    return;
                }
            }
        }

        if(standard == 0) zero++;
        else if(standard == 1) plus++;
        else if(standard == -1) minus++;
    }
}
