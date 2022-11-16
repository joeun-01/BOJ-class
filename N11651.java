package BOJ;

/*
 * 2차원 평면 위의 점 N개가 주어진다. 
 * 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 
 * 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * 
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * 
 * 5
 * 0 4
 * 1 2
 * 1 -1
 * 2 2
 * 3 3
 * 
 * 1 -1
 * 1 2
 * 2 2
 * 3 3
 * 0 4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class N11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());
        int[][] dot = new int[num][2];

        int i;
        for(i = 0; i < num; i++) {
            String input = read.readLine();
            String[] split = input.split(" ");

            dot[i][0] = Integer.parseInt(split[0]);
            dot[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(dot, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                 if(o1[1] == o2[1]) {
                         return o1[0] - o2[0];
                 }else {
                     return o1[1] - o2[1]; 
                 }
               }
            });

        for(i = 0; i < num; i++) {
            build.append(dot[i][0] + " " + dot[i][1] + "\n");
        }

        System.out.println(build);
    }
}
