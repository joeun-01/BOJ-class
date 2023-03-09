package BOJ;

/*
1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.

같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 
또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 
3개의 눈이 6, 2, 5로 주어지면 그 중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.

N(2 ≤ N ≤ 1,000)명이 주사위 게임에 참여하였을 때, 가장 많은 상금을 받은 사람의 상금을 출력하는 프로그램을 작성하시오.

첫째 줄에는 참여하는 사람 수 N이 주어지고 그 다음 줄부터 N개의 줄에 사람들이 주사위를 던진 3개의 눈이 빈칸을 사이에 두고 각각 주어진다. 

첫째 줄에 가장 많은 상금을 받은 사람의 상금을 출력한다.

3
3 3 6
2 2 2
6 2 5

12000
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.IOException;

public class N2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int max = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            int same = 0;

            int a = Integer.parseInt(stoi.nextToken());
            map.put(a, 1);

            int b = Integer.parseInt(stoi.nextToken());            
            if(map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
                same = b;
            }
            else map.put(b, 1);

            int c = Integer.parseInt(stoi.nextToken());
            if(map.containsKey(c)) {
                map.put(b, map.get(b) + 1);
                same = c;
            }
            else map.put(c, 1);

            // for(Integer value : map.keySet()) {
            //     System.out.println("map: " + value);
            // }

            int money = 0;
            if(map.size() == 1) money = 10000 + same * 1000;
            else if(map.size() == 2) money = 1000 + same * 100;
            else if(map.size() == 3) money = map.lastKey() * 100;

            max = Math.max(max, money);
        }

        System.out.println(max);
    }
}
