package BOJ;

/*
오세준은 어떤 자연수의 소인수중 최댓값이 K보다 크지 않을때 그 수를 K-세준수라고 부른다.
N보다 작거나 같은 자연수 중에 K-세준수가 총 몇 개인지 구하는 프로그램을 작성하시오.

첫째 줄에 N, 둘째 줄에 K가 주어진다. 
N은 100,000보다 작거나 같은 자연수이고, K는 100보다 작거나 같은 자연수이다.

첫째 줄에 N보다 작거나 같은 K-세준수가 몇 개인지 출력한다.

10
3

7
 */

import java.io.*;

public class N1418 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        int K = Integer.parseInt(read.readLine());

        int num = 1, result = 0;
        while(num <= N) {
            int prime = 0;
            for(int i = 1; i <= num; i++) {
                if(num % i == 0) {
                    int factor = num / i;
                    if(factor != 1 && isPrime(factor)) prime = factor; 

                    if(prime > K) break;

                    // System.out.println(num + " : " + prime);
                }
            }

            if(prime != 1 && prime <= K) {
                // System.out.println(num);
                result++;
            }

            num++;
        }

        System.out.println(result);
    }   

    public static boolean isPrime(int factor) {
        boolean isPrime = true;
        for(int i = 2; i <= factor / 2; i++) {
        	// 순차적으로 i를 num에 나누어본다.
			if(factor % i == 0) {
            	// num이 i로 나눠져 나머지가 0이 되면 isPrime에 false(소수가 아님)을 입력한다.
				isPrime = false;
				break;
			}
		}

        return isPrime;
    }
}
