package BOJ;

/*
준규는 숫자 카드 N장을 가지고 있다. 
숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.

준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 
만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.

첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.

첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.

5
1
2
1
2
1

1
 */

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;

public class N11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        HashMap<BigInteger, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            BigInteger num = new BigInteger(read.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        BigInteger maxKey = BigInteger.ZERO;
        for(BigInteger key : map.keySet()) {
            int value = map.get(key);

            if(value == max) {
                maxKey = key.min(maxKey);
            } else if(value > max) {
                max = value;
                maxKey = key;
            }
        }

        System.out.println(maxKey);
    }
}