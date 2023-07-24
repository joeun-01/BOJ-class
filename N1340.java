package BOJ;

/*
문빙이는 새해를 좋아한다. 
하지만, 이제 새해는 너무 많이 남았다. 
그래도 문빙이는 새해를 기다릴 것이다.

어느 날 문빙이는 잠에서 깨면서 스스로에게 물었다. 
“잠깐, 새해가 얼마나 남은거지?”

이 문제에 답하기 위해서 문빙이는 간단한 어플리케이션을 만들기로 했다. 
연도 진행바라는 것인데, 이번 해가 얼마나 지났는지를 보여주는 것이다.

오늘 날짜가 주어진다. 
이번 해가 몇%지났는지 출력하는 프로그램을 작성하시오.

첫째 줄에 Month DD, YYYY HH:MM과 같이 주어진다. 
Month는 현재 월이고, YYYY는 현재 연도이다. 
숫자 네자리이다.
DD, HH, MM은 모두 2자리 숫자이고, 현재 일, 시, 분이다.

Month는 January, February, March, April, May, June, July, August, September, October, November, December 중의 하나이고, 연도는 1800보다 크거나 같고, 2600보다 작거나 같다. 
항상 올바른 날짜와 시간만 입력으로 주어진다.

첫째 줄에 문제의 정답을 출력한다. 절대/상대 오차는 10-9까지 허용한다.

May 10, 1981 00:31

35.348363774733635
 */

import java.io.*;
import java.util.StringTokenizer;

public class N1340 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        
        String month = stoi.nextToken();
        int day = Integer.parseInt(stoi.nextToken().substring(0, 2));
        int year = Integer.parseInt(stoi.nextToken());
        
        StringTokenizer time = new StringTokenizer(stoi.nextToken(), ":");
        int hour = Integer.parseInt(time.nextToken());
        int minute = Integer.parseInt(time.nextToken());

        


    }
}