package BOJ;

/*
세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.

세 점의 좌표가 한 줄에 하나씩 주어진다. 
좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.

직사각형의 네 번째 점의 좌표를 출력한다.

5 5
5 7
7 5

7 7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class N3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();

        for(int i = 0; i < 3; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            int first = Integer.parseInt(stoi.nextToken());
            int second = Integer.parseInt(stoi.nextToken());

            x.put(first, x.getOrDefault(first, 0) + 1);
            y.put(second, y.getOrDefault(second, 0) + 1);
        }   

        for(int key : x.keySet()) {
            if(x.get(key) == 1) build.append(key + " ");
        }
        for(int key : y.keySet()) {
            if(y.get(key) == 1) build.append(key);
        }

        System.out.println(build);
    }
}
