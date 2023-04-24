package BOJ;

/*
영식이와 친구들이 원형으로 모여서 시계방향으로 1부터 N까지 적혀있는 자리에 앉는다. 
영식이와 친구들은 공 던지는 게임을 하기로 했다. 
게임의 규칙은 다음과 같다.

일단 1번 자리에 앉은 사람이 공을 받는다. 
그리고 나서 공을 다른 사람에게 던진다. 
다시 공을 받은 사람은 다시 공을 던지고, 이를 계속 반복한다. 
한 사람이 공을 M번 받았으면 게임은 끝난다. (지금 받은 공도 포함하여 센다.) 
공을 M번보다 적게 받은 사람이 공을 던질 때, 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.

공을 총 몇 번 던지는지 구하는 프로그램을 작성하시오.

첫째 줄에 N, M, L이 입력으로 들어온다. 
N은 3보다 크거나 같고, 50보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다. 
L은 N-1보다 작거나 같은 자연수이다.

첫째 줄에 공을 몇 번 던지는지 횟수를 출력한다.

5 3 2

10
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());
        int L = Integer.parseInt(stoi.nextToken());

        int[] cnt = new int[N + 1];

        cnt[1] = 1;
        int cur = 1, ball = 0;
        while(true) {
            if(cnt[cur] == M) break;

            if(cnt[cur] % 2 == 0) {
                cur = cur - L;

                if(cur <= 0) cur += N;
            } else {
                cur = cur + L;
                
                if(cur > N) cur -= N;
            }

            cnt[cur]++;
            ball++;
        }

        System.out.println(ball);
    }
}
