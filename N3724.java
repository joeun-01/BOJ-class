package BOJ;

/*
N행, M열로 이루어진 표에 32비트 부호있는 정수가 저장되어 있다. 
제일 왼쪽 열은 1이고, 오른쪽으로 갈 수록 번호가 1씩 증가한다.

Ai(1 ≤ i ≤ M)를 i번 열에 있는 모든 수의 곱으로 정의하자. 
이때, 가장 큰 값을 갖는 열의 번호를 찾는 프로그램을 작성하시오. 
그러한 열이 여러개라면, 번호가 가장 큰 열을 출력한다.

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 
각 테스트 케이스의 첫째 줄에는 M과 N이 주어진다. (1 ≤ M ≤ 20, 1 ≤ N ≤ 1000) 
다음 N개 줄에는 M개의 32비트 부호있는 정수가 주어진다.

각 테스트 케이스에 대해서 한 줄에 하나씩 가장 큰 곱을 갖는 열의 번호를 출력한다.

2
3 3
20 10 30
15 20 20
30 30 20
3 2
2 -2 2
2 -2 2

3
3
 */

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3724 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int C = Integer.parseInt(stoi.nextToken());
            int R = Integer.parseInt(stoi.nextToken());

            BigInteger[][] table = new BigInteger[R][C];
        
            BigInteger[] column = new BigInteger[C + 1];
            Arrays.fill(column, BigInteger.ONE);

            for(int r = 0; r < R; r++) {
                StringTokenizer row = new StringTokenizer(read.readLine());
                for(int c = 0; c < C; c++) {
                    table[r][c] = new BigInteger(row.nextToken());

                    column[c + 1] = column[c + 1].multiply(table[r][c]); 
                }
            }

            int max = 1;
            for(int j = 1; j <= C; j++) {
                if(column[j].compareTo(column[max]) >= 0) max = j;
            }

            build.append(max + "\n");
        }

        System.out.println(build);
    }
}