package BOJ;

/*
 * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 
 * 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 
 * 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 * 
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
 * 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
 */

import java.util.Scanner;

public class N2292 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextInt();

        int max = 2;

        if(n == 1) System.out.println(1);  // 1은 방을 이동하지 않음
        else {
            int i = 1;
            while(true) {
                // 2 ~ 7 은 한 칸 (범위 : 6), 8 ~ 19 는 두 칸 (범위 : 12), 이런 식으로 범위가 6의 배수로 넓어짐
                if(max <= n && n < max + i * 6) {
                    System.out.println(i + 1);
                    break;
                } else {
                    max += i * 6;
                }

                i++;
            }
        }
        
        input.close();
    }
}
