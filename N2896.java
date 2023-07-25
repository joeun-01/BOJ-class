package BOJ;

/*
상근이와 지수는 마트에서 오렌지 주스, 사과 주스, 파인애플 주스를 구매했다. 
그들은 인터넷에서 찾은 방법으로 무알콜 칵테일을 만들어 학교에서 팔려고 한다. 
하지만, 칵테일을 만드는 방법을 찾기 전에 주스를 구매했기 때문에, 주스가 남을 수도 있다.

무알콜 칵테일을 만드는데 필요한 오렌지, 사과, 파인애플 주스의 비율과 구매한 주스의 양이 주어진다. 
칵테일을 최대한 많이 만들었을 때, 각 주스가 얼만큼 남는지 구하는 프로그램을 작성하시오.

첫째 줄에 구매한 오렌지, 사과, 파인애플 주스의 양 A, B, C가 주어진다. (1 ≤ A, B, C ≤ 500)
둘째 줄에 칵테일을 만드는데 필요한 각 주스의 비율 I, J, K가 주어진다. (1 ≤ I, J, K ≤ 50)

첫째 줄에 칵테일을 최대한 많이 만들었을 때, 각 주스가 얼만큼 남는지를 공백으로 구분하여 출력한다. 
정답과의 오차는 10-4까지 허용한다.

9 9 9
3 2 1

0 3 6
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2896 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer juice = new StringTokenizer(read.readLine());
        int orange = Integer.parseInt(juice.nextToken());
        int apple = Integer.parseInt(juice.nextToken());
        int pineapple = Integer.parseInt(juice.nextToken());

        StringTokenizer ratio = new StringTokenizer(read.readLine());
        double oRatio = Double.parseDouble(ratio.nextToken());
        double aRatio = Double.parseDouble(ratio.nextToken());
        double pRatio = Double.parseDouble(ratio.nextToken());

        // 최대공약수를 구해서 최대공약수로 비율을 나눔
        int min = (int) Math.min(pRatio, Math.min(aRatio, pRatio)), gcd = 1;
        for(int i = 1; i <= min; i++) {
            if(oRatio % i == 0 && aRatio % i == 0 && pRatio % i == 0) {
                gcd = i;
            }
        }

        oRatio /= gcd;
        aRatio /= gcd;
        pRatio /= gcd;

        double possible = Math.min(orange / oRatio, Math.min(apple / aRatio, pineapple / pRatio));

        if((orange - (oRatio * possible)) % 1 == 0.0) {
            build.append((int) (orange - (oRatio * possible)));
            build.append(" ");
        } else {
            build.append(String.format("%.6f", orange - (oRatio * possible)));
            build.append(" ");
        }

        if((apple - (aRatio * possible)) % 1 == 0.0) {
            build.append((int) (apple - (aRatio * possible)));
            build.append(" ");
        } else {
            build.append(String.format("%.6f", apple - (aRatio * possible)));
            build.append(" ");
        }

        if((pineapple - (pRatio * possible)) % 1 == 0.0) {
            build.append((int) (pineapple - (pRatio * possible)));
            build.append(" ");
        } else {
            build.append(String.format("%.6f", pineapple - (pRatio * possible)));
            build.append(" ");
        }
        
        System.out.println(build);
    }
}
