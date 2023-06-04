package BOJ;

/*
새 학기를 맞아 상근이는 책을 10권 구입했다. 
상근이는 의욕이 너무 앞서서 가격을 조사하지 않고 책을 구입했다. 
이제 각 책의 가격을 알아보려고 한다.

하지만, 영수증에는 얼룩이 묻어있었고, 상근이는 책 10권 중 9권의 가격만 읽을 수 있었다.

책 10권의 총 가격과 가격을 읽을 수 있는 9권 가격이 주어졌을 때, 가격을 읽을 수 없는 책의 가격을 구하는 프로그램을 작성하시오.

첫째 줄에 10권의 총 가격이 주어진다. 
둘째 줄부터 9개 줄에는 가격을 읽을 수 있는 책 9권의 가격이 주어진다. 
책의 가격은 10,000이하인 양의 정수이다.

첫째 줄에 가격을 읽을 수 없는 책의 가격을 출력한다.

9850
1050
800
420
380
600
820
2400
1800
980

600
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(read.readLine());
        for(int i = 0; i < 9; i++) {
            int price = Integer.parseInt(read.readLine());

            total -= price;
        }

        System.out.println(total);
    }
}
