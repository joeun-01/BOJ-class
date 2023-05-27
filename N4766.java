package BOJ;

/*
입력은 동혁이가 측정한 혼합물의 온도가 순서대로 주어진다. 
온도는 -10도와 200도 사이이고, 소수점 둘째자리까지 적혀져 있을 수도 있다. 
마지막 측정 후에는 999가 주어진다. 
동혁이는 온도를 적어도 2번 측정했다.

입력으로 주어진 각 온도와 이전 온도와의 차이를 출력한다. 
첫 번째 측정할 온도는 이전 온도가 없으니 출력할 필요가 없다. 
차이는 항상 소수점 둘째자리까지 출력한다.

10.0
12.05
30.25
20
999

2.05
18.20
-10.25
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        float pre = Float.parseFloat(read.readLine());
        while(true) {
            float temp = Float.parseFloat(read.readLine());
            
            if(temp == 999) break;

            build.append(String.format("%.2f", temp - pre) + "\n");
            pre = temp;  
        }

        System.out.println(build);
    }
}
