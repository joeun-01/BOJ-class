package BOJ;

/*
Al의 초콜릿 망고 회사는 방문자들이 2d 단지에 얼마나 많은 초콜릿 망고가 있는지 추측할 수 있는 웹 사이트를 갖고 있다. 
방문자들은 1부터 99까지의 수를 추측한 후 "제출" 버튼을 누르는데, 안타깝게도 서버로부터 응답시간이 종종 길어져 방문자들이 이성을 잃은 나머지 "제출"을 연타하는 사태가 발생한다. 
이게 우리가 해결해야 할 문제다.
ACM의 직원을 도와 연타된 중복을 걸러보자.

각 줄마다 처음으로 정수 N(0 < N ≤ 25)이 주어진다.  
그 다음 N개에 걸쳐 1부터 99 사이의 수가 주어진다.
마지막 줄에 입력의 끝을 알리는 0이 주어진다.

각 케이스마다 한 줄씩 연속하는 중복을 제거한 원래의 제출 상태를 출력한다.
각 줄의 마지막에는 한 칸을 띄고 '$' 표시가 붙는다.

5 1 22 22 22 3
4 98 76 20 76
6 19 19 35 86 86 86
1 7
0

1 22 3 $
98 76 20 76 $
19 35 86 $
7 $
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N4592 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String str = "";
        while(!(str = read.readLine()).equals("0")) {
            StringTokenizer stoi = new StringTokenizer(str);

            int N = Integer.parseInt(stoi.nextToken());
            int[] submit = new int[N];

            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                submit[i] = Integer.parseInt(stoi.nextToken());
                
                if(i == 0) {
                    list.add(submit[i]);
                    continue;
                }
            
                if(submit[i] != submit[i - 1]) {
                    list.add(submit[i]);
                }
            }

            for(int i = 0; i < list.size(); i++) {
                build.append(list.get(i) + " ");
            }
            build.append("$\n");
        }

        System.out.println(build);
    }
}
