package BOJ;

/*
상근이는 등차수열을 이루는 정수 4개를 골랐다. 
이것은 상근이가 고른 수 4개를 정렬했을 때, 인접한 쌍의 차이가 일정하다는 것을 의미한다. 
그 다음 이렇게 고른 수 4개를 노래로 만들어서 외우고 다닌다.

어느 날, 상근이는 자신이 고른 4개 수 중 1개를 까먹었다. 
상근이가 기억하고 있는 수 세 개가 주어졌을 때, 까먹은 수를 구하는 프로그램을 작성하시오.

첫째 줄에 상근이가 고른 4개의 수 중 3개가 주어진다. 
이 수는 크기 순이 아닐 수도 있고, -100보다 크거나 같고, 100보다 작거나 같은 정수이다.

첫째 줄에 까먹은 수를 출력한다. 
정답이 여러 개일 경우에는 아무거나 출력하면 된다. 
또한 정답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

4 6 8

10
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2997 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        int[] array = new int[3];
        for(int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(stoi.nextToken());
        }

        Arrays.sort(array);
        int a = array[1] - array[0];
        int b = array[2] - array[1];

        if(a == b) System.out.println(array[2] + a);
        else if(a > b) System.out.println(array[0] + b);
        else if(a < b) System.out.println(array[1] + a);
    }
}