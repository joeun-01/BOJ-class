package BOJ;

/*
돌 게임은 두 명이서 즐기는 재밌는 게임이다.
탁자 위에 돌 N개가 있다. 
상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개 또는 3개 가져갈 수 있다. 
마지막 돌을 가져가는 사람이 게임을 이기게 된다.

두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 
게임은 상근이가 먼저 시작한다.

첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1000)

상근이가 게임을 이기면 SK를, 창영이가 게임을 이기면 CY을 출력한다.

5

SK
 */

import java.io.*;

public class N9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());
        
        /*
         * 1 : 상근 1
         * 2 : 상근 1 창영 1
         * 3 : 상근 3
         * 4 : 상근 1 창영 3 or 상근 1 창영 1 상근 1 창영 1
         * 5 : 상근
         * 6 : 창영
         * 7 : 상근
         * 8 : 
         */

        if(N % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
