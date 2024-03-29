package BOJ;

/*
오늘은 화이트데이이다. 
상근이는 여자친구를 위해서 사탕을 사려고 한다. 
하지만, 상근이는 독특한 성격을 가지고 있어서, 특정 액면가의 지폐만 가지고 있는다. 
또, 거스름돈은 받지 않는다. 
따라서, 사탕 가게의 사장과 상근이는 다음과 같은 합의를 했다. 
상근이는 사장에게 자신이 가지고 있는 지폐의 액면가를 말해준다. 
그럼 사장은 상근이가 지불할 수 있는 가장 가까운 금액으로 사탕의 가격을 반올림해준다.

예를 들어, 상근이가 가지고 있는 지폐의 액면가가 100원이라고 하자.
만약 상근이가 고른 사탕의 가격이 150원이라면, 사장은 가격을 200원으로 반올림해서 상근이가 낼 수 있도록 해준다. 
또, 가격이 149원이라면, 사장은 가격을 100원으로 반올림해서 상근이가 지불할 수 있도록 해준다.

상근이가 가지고 있는 지폐의 액면가는 항상 1, 10, 100, 1000, ..., 1,000,000,000 중 하나이다. 
또, 지폐를 무한개 가지고 있다.

사탕 가격과 상근이가 가지고 있는 지폐의 액면가가 주어졌을 때, 사장은 가격을 얼마로 바꿔줄 것인지 구하는 프로그램을 작성하시오.

첫째 줄에 사탕의 가격 C와 상근이가 가지고 있는 지폐의 액면가에 적혀있는 0의 개수 K가 주어진다. (0 ≤ C ≤ 1,000,000,000, 0 ≤ K ≤ 9)

첫째 줄에 상근이가 내야하는 가격을 출력한다.

184 1

180
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2909 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        long C = Integer.parseInt(stoi.nextToken());
        long K = Integer.parseInt(stoi.nextToken());

        long money = (int) Math.pow(10, K);
        double result = C / (double) money;

        // System.out.println(money + " " + result);

        System.out.println(Math.round(result) * money);
    }
}