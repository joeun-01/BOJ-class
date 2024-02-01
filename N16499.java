package BOJ;

/*
첫째 줄에 주어진 여러 개의 정수 중에서 합이 둘째 줄에 주어진 수와 같은 서로 다른 위치에 있는 두 수의 쌍을 모두 출력하고 맨 아래에 이 쌍의 개수를 이어서 출력하는 프로그램을 작성하시오.

첫째 줄에 빈 칸으로 구분된 정수가 2개 이상, 10개 이하 주어진다. 
둘째 줄에는 정수가 하나 주어진다. 
주어지는 정수는 100,000보다 작거나 같은 자연수이다.

찾은 수의 쌍을 한 줄에 하나씩 출력하고 맨 아랫 줄에 그러한 쌍의 개수를 출력한다.
구성은 같지만, 순서가 다른 쌍 (a, b)와 (b, a)는 쌍 하나로 하며, a ≤ b인 쌍을 출력한다.
쌍이 여러 개인 경우에는 사전 순으로 출력한다. (a, b)가 (c, d)보다 사전 순으로 앞서는 기준은 a < c이거나, a == c 이면서, b < d 인 것이다.

1 2
3

1 2
1
 */

import java.io.*;
import java.util.HashSet;
import java.util.TreeMap;

public class N16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            String str = read.readLine();
            
            TreeMap<Character, Integer> treeMap = new TreeMap<>();
            for(int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                treeMap.put(letter, treeMap.getOrDefault(letter, 0) + 1);
            }

            String word = "";
            for(char letter : treeMap.keySet()) {
                for(int j = 0; j < treeMap.get(letter); j++) {
                    word += letter;
                }
            }

            set.add(word);
        }

        // System.out.println(set);
        System.out.println(set.size());
    }
}