package BOJ;

/*
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
회의의 시작시간과 끝나는 시간이 같을 수도 있다. 
이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(read.readLine());
        int[][] counsil = new int[num][2];

        for(int i = 0; i < num; i++) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            counsil[i][0] = Integer.parseInt(token.nextToken());
            counsil[i][1] = Integer.parseInt(token.nextToken());
        }

        // 끝나는 시간을 기준으로 정렬
        Arrays.sort(counsil, new Comparator<int[]>() {
            @Override
            public int compare(int[] num, int[] num2){
                if(num[1] == num2[1]) {
                    return num[0] - num2[0];
            }else {
                return num[1] - num2[1]; 
            }

        }});

        int answer = 1;
        int end = counsil[0][1];
        for(int i = 1; i < num; i++) {
            if(counsil[i][0] >= end) {
                answer++;
                end = counsil[i][1];
            } 
        }

        System.out.println(answer);
    }
}
