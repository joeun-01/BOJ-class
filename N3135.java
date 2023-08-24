package BOJ;

/*
준하는 라디오 수집광으로 신제품의 라디오가 나올때마다 흥분을 금치 못한다고 한다.
최근 준하가 구입한 라디오는 매우 하이테크 한데, 그 라디오에는 다음과 같은 버튼이 있다.

첫 번째 버튼은 주파수를 1MHz 증가시킨다.
두 번째 버튼은 주파수를 1MHz 감소시킨다.
나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.

준하는 몸이 안좋아 하루에 손가락을 몇 번 움직이지 못하기 때문에 우리의 도움이 필요하다.
현재 주파수 A와 듣고싶은 주파수 B가 주어질 때, 
주파수 A에서 B로 갈 때 눌러야 하는 가장 적은 버튼수를 구해주자.

첫 줄엔 정수 A와 B가 주어진다 (1 ≤ A, B < 1000, A ≠ B).
다음 줄엔 정수 N이 주어진다 (1 ≤ N ≤ 5).
다음 N개의 줄엔 미리 지정되어 있는 주파수가 주어진다 (주파수는 1000 보다 작다).

주파수 A에서 B로 갈 때 눌러야 하는 버튼수의 최솟값을 출력한다.

100 15
1
15

1
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3135 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int A = Integer.parseInt(stoi.nextToken());  // 현재 주파수
        int B = Integer.parseInt(stoi.nextToken());  // 듣고 싶은 주파수

        int N = Integer.parseInt(read.readLine());  // 지정되어 있는 주파수
        int[] radio = new int[N];
        for(int i = 0; i < N; i++) {
            radio[i] = Integer.parseInt(read.readLine());
        }

        Arrays.sort(radio);

        int cur = A, button = 0;
        
        int min = Math.abs(B - A), temp = A;
        for(int i = 0; i < N; i++) {
            if(Math.abs(B - temp) >= Math.abs(B - radio[i])) {
                min = Math.abs(B - radio[i]);
                temp = radio[i];
            }
        }

        if(Math.abs(B - cur) >= min + 1) {
            cur = temp;
            button++;
        }
        button += Math.abs(B - cur);

        System.out.println(button);
    }
}
