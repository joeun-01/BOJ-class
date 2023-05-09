package BOJ;

/*
상근이는 3003번에서 동혁이가 발견한 체스판을 톱으로 자르려고 한다.

상근이는 체스판을 최대 N번 자를 수 있으며, 변에 평행하게만 자를 수 있다. 
또, 자를 때는 체스판의 그 변의 한쪽 끝에서 다른쪽 끝까지 잘라야 한다. 
자른 후에는 조각을 이동할 수 없다.

이때, 최대 몇 조각을 낼 수 있는지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        int answer = 0;
        if(N % 2==0) {
			answer = (N / 2 + 1) * (N / 2 + 1);
		} else {
			answer = (N / 2 + 2) * (N / 2 + 1);
		}

		System.out.println(answer);
	}
}
