package BOJ;

/*
정수 N이 주어져 있을 때 이 수가 10보다 크면 일의 자리에서 반올림을 하고, 이 결과가 100보다 크면 다시 10의 자리에서 반올림을 하고, 또 이 수가 1000보다 크면 100의 자리에서 반올림을 하고.. (이하 생략) 
이러한 연산을 한 결과를 출력하시오.

첫째 줄에 정수 N이 주어진다. (0 ≤ N ≤ 99,999,999)

첫째 줄에 위와 같은 연산을 한 결과를 출력하시오.

15

20
 */

import java.io.*;

public class N2033 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(read.readLine());
		
		int x = 1;
		int result = num;
		
		while(num > 0) {
			result = (int)((result / (double) x) + 0.5) * x;
			x *= 10;
			num /= 10;
		}
		
		System.out.println(result);
    }
}