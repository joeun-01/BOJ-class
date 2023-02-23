package BOJ;

/*
nCm을 출력한다.

n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)

nCm을 출력한다.

100 6

1192052400
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.math.BigInteger;

public class N2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(stoi.nextToken());
        int m = Integer.parseInt(stoi.nextToken());

        System.out.println(comb(n, m));
    }

    public static BigInteger comb(int n, int m) {       
        BigInteger[][] arr = new BigInteger[101][101];

        // nCr = (n-1)C(r-1) + (n-1)C(r)
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(i == j || j == 0) arr[i][j] = BigInteger.ONE;
                else arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j]);

                // System.out.println(arr[i][j]);
            }
        }
    
        return arr[n][m];
    }
}
