package BOJ;

/*
영식이는 숫자를 셀 때, 왼손을 이용한다. 
엄지손가락부터 시작해서 새끼손가락까지 차례대로 하나씩 센다. 
그다음에 새끼손가락까지 센 다음에는 반대로 엄지손가락으로 다시 역방향으로 센다. 
영식이는 자기가 원하는 숫자가 나올 때 까지 계속해서 이 방법으로 센다. 
영식이는 절대 손가락을 건너뛰지 않는다. 
예를 들어 숫자 10을 셀 때는, 엄지 → 검지 → 중지 → 약지 → 새끼 → 약지 → 중지 → 검지 → 엄지 → 검지 이렇게 센다.

영식이가 손가락을 하나 다쳤다. 
영식이는 오른손으로는 셀 수 없기 때문에, 왼손으로 세야 한다. 
다친 손가락을 이용해서 셀 수 있는 횟수가 제한되어 있다.

영식이가 셀 수 있는 최대 숫자를 출력하는 프로그램을 작성하시오.

첫째 줄에 영식이가 다친 손가락이 주어진다. 
엄지부터 차례대로 1, 2, 3, 4, 5로 번호가 매겨져 있다. 
둘째 줄에는 영식이가 다친 손가락으로 몇 번 셀 수 있는지 주어진다. 
이 수는 1,000,000,000보다 작거나 같은 자연수 또는 0이다.

첫째 줄에 영식이가 셀 수 있는 수의 최댓값을 출력한다. 
만약 시작도 할 수 없으면 0을 출력한다.

2
3

15
 */

import java.io.*;

public class N1614 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        long A = Integer.parseInt(read.readLine());
        long B = Integer.parseInt(read.readLine());

        if(A == 1) {
            System.out.println(8 * B);
        } else if(A == 5) {
            System.out.println(8 * B + 4);
        } else {
            if(B % 2 == 0) System.out.println((4 * B) + A - 1);
            else System.out.println((4 * B) + 5 - A);
        }
    }
}
