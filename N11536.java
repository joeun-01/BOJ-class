package BOJ;

/*
악독한 코치 주혁은 선수들을 이름 순으로 세우는 것을 좋아한다. 
더 악독한 것은 어떤 순서로 서야할지도 알려주지 않았다! 
선수들의 이름이 주어질 때 어떤 순서로 이루어져있는지 확인해보자.

첫째 줄에 N개의 이름이 주어진다. (2 ≤ N ≤ 20)

다음 N개의 줄에는 각 선수들의 이름이 주어진다. 
이름은 2 이상 12 이하의 대문자로만 이루어져있다. 
선수의 이름은 중복되지 않는다.

이름이 증가하는 순으로 나타나면 INCREASING, 감소하는 순이면 DECREASING을 한 줄에 출력한다. 
만약 위의 두 경우가 아니라면 NEITHER를 출력한다.

5
JOE
BOB
ANDY
AL
ADAM

DECREASING
 */

import java.io.*;

public class N11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        String[] names = new String[N];
        String result = "";
        boolean order = true;
        for(int i = 0; i < N; i++) {
            names[i] = read.readLine();

            if(i == 1) {
                if(names[0].compareTo(names[1]) < 0) result = "INCREASING";
                else if(names[0].compareTo(names[1]) > 0) result = "DECREASING";
            } else if(i > 0) {
                if(result.equals("INCREASING")) {
                    if(names[i - 1].compareTo(names[i]) > 0) {
                        order = false;
                    }
                } else if(result.equals("DECREASING")) {
                    if(names[i - 1].compareTo(names[i]) < 0) {
                        order = false;
                    }
                }
            }
        }

        if(order) System.out.println(result);
        else System.out.println("NEITHER");
    }
}
