package BOJ;

/*
강민이는 치킨 한 마리를 주문할 수 있는 치킨 쿠폰을 n장 가지고 있다. 
이 치킨집에서는 치킨을 한 마리 주문할 때마다 도장을 하나씩 찍어 주는데, 도장을 k개 모으면 치킨 쿠폰 한 장으로 교환할 수 있다.

강민이가 지금 갖고 있는 치킨 쿠폰으로 치킨을 최대 몇 마리나 먹을 수 있는지 구하여라. 
단, 치킨을 주문하기 위해서는 반드시 치킨 쿠폰을 갖고 있어야 한다.

여러 줄에 걸쳐서 자연수 n과 k가 주어진다.

각 입력마다 한 줄에 정답을 출력한다.

1 < k ≤ n ≤ 1,000,000,000

4 3
10 3
100 5

5
14
124
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1673 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        while(true) {
            String input = read.readLine();
            if (input == null) {
                break;
            }

            String[] inputs = input.split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            int chicken = 0;
            int newCoupon;
            int newCount;

            while(true){
                newCount = (n - n % k);
                newCoupon = newCount / k;
                n = n % k;
                n += newCoupon;

                chicken += newCount;
                if(n < k) {
                    chicken += n;
                    break;
                }
            }

            build.append(chicken + "\n");
        }

        System.out.println(build);
    }
}