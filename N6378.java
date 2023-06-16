package BOJ;

/*
양의 정수 N의 디지털 루트를 구하려면 N을 이루고 있는 모든 자리수를 더해야 한다. 
이때, 더한 값이 한 자리 숫자라면, 그 수가 N의 디지털 루트가 된다. 
두 자리 이상 숫자인 경우에는 다시 그 수를 이루고 있는 모든 자리수를 더해야 하며, 한 자리 숫자가 될 때 까지 반복한다.

24의 디지털 루트를 구해보자. 2+4=6이다. 
6은 한 자리 숫자이기 때문에, 24의 디지털 루트는 6이 된다. 
39의 경우에는 3+9=12이기 때문에, 한 번 더 더해야 한다. 
따라서, 1+2=3이 디지털 루트가 된다.

양의 정수 N이 주어졌을 때, 그 수의 디지털 루트를 구하는 프로그램을 작성하시오.

한 줄에 하나씩 양의 정수가 주어진다. 
입력의 마지막 줄은 0으로 나타낸다.  
수는 최대 1000자리이다.

입력으로 주어진 양의 정수의 디지털 루트를 한 줄에 하나씩 주어진 순서대로 출력한다.

24
39
0

6
3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N6378 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();    

        String num = "";
        while(true) {
            num = read.readLine();

            if(num.equals("0")) break;

            while(true) {
                int sum = 0;
                
				if(num.length() < 2) {
					break;
				}else {
					for(int i = 0; i < num.length(); i++) {
						sum += num.charAt(i) - '0';
					}
				}

                num = Integer.toString(sum);
            }

            build.append(num + "\n");
        }

        System.out.println(build);
    }
}
