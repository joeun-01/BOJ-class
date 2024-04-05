package BOJ;

/*
미래를 예측하는 능력이 있는 정균이는 앞으로 N일간 ANA 회사의 주가가 어떻게 변하는지 정확히 예측할 수 있다. 
정균이는 예측한 결과를 바탕으로 ANA 회사의 주식 한 주를 적당한 시점에 사고 적당한 시점에 팔아서 최대한의 이득을 얻으려고 한다.

ANA 회사의 앞으로 N일간의 주가를 a_1, a_2, ..., a_N이라고 하자. 
정균이가 i번째 날에 주식을 사고, j번째 날에 판다면 a_j - a_i만큼의 이득을 얻을 수 있다. 
정균이는 자금이 넉넉하기 때문에 주가가 아무리 높아도 주식을 살 수 있고, 상황이 여의치 않을 경우 사자마자 바로 팔 수도 있다.

앞으로 N일간 ANA 회사의 주가가 주어졌을 때, 정균이가 주식 한 주를 적당한 시점에 사고 적당한 시점에 팔아서 얻을 수 있는 최대 이득은 얼마일까?

첫째 줄에 정수 N(1 <= N <= 200,000)이 주어진다.

두 번째 줄에 정수 a_1, a_2, ..., a_N이 주어진다. 
a_i(1 <= a_i <= 109)는 i번째 날의 ANA 회사의 주가이다.

ANA 회사의 주식 한 주를 적당한 시점에 사고 적당한 시점에 팔아서 얻을 수 있는 최대 이득을 출력한다.

5
4 2 3 1 5

4
 */

import java.io.*;
import java.util.StringTokenizer;

public class N25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int min = Integer.MAX_VALUE;
        int maxStock = 0;
        for(int i = 0; i < N; i++) {
            int stock = Integer.parseInt(stoi.nextToken());

            min = Math.min(min, stock);
            maxStock = Math.max(stock - min, maxStock);
        }

        System.out.println(maxStock);
    }
}