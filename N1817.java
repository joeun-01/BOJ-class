package BOJ;

/*
숌은 짐을 챙겨서 겨울캠프에서 집으로 가려고 한다. 
근데 숌은 공부를 많이 하러 캠프에 온 것이기 때문에 책을 엄청나게 많이 가지고 왔다. 
숌은 이 책을 방에 탑처럼 쌓아 놨다.

숌은 책을 박스에 차곡차곡 넣어서 택배로 미리 보내려고 한다. 
책은 탑처럼 차곡차곡 쌓여있기 때문에, 차례대로 박스에 넣을 수밖에 없다.

각각의 책은 무게가 있다. 
그리고 박스는 최대 넣을수 있는 무게가 있다. 
숌이 필요한 박스의 개수의 최솟값을 구하는 프로그램을 작성하시오.

첫째 줄에 책의 개수 N과 박스에 넣을 수 있는 최대 무게 M이 주어진다. 
N은 0보다 크거나 같고 50보다 작거나 같은 정수이고, M은 1,000보다 작거나 같은 자연수이다. 
N이 0보다 큰 경우 둘째 줄에 책의 무게가 공백을 사이에 두고 주어진다. 
책의 무게는 M보다 작거나 같은 자연수이다.

첫째 줄에 필요한 박스의 개수의 최솟값을 출력한다.

6 10
5 5 5 5 5 5

3
 */

import java.io.*;
import java.util.StringTokenizer;

public class N1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        if(N == 0) {
            System.out.println(0);
            System.exit(0);
        }

        StringTokenizer book = new StringTokenizer(read.readLine());
        int box = 0, cnt = 1;
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(book.nextToken());

            if(box + cur > M) {
                box = cur;
                cnt++;
            } else {
                box += cur;
            }
        }

        System.out.println(cnt);
    }
}