package BOJ;

/*
오른쪽 그림과 같은 핸드폰 자판이 있다. 이 자판을 이용하여 어떤 영어 메시지를 치려고 할 때, 걸리는 최소 시간을 구하는 프로그램을 작성하시오.

단, 1번은 누를 경우에는 공백이 찍힌다고 하자. 그리고 만약에 AC라는 문자를 치려 한다면 A를 치고 난 후 일정 시간을 기다린 후 C를 치면 된다.

하나의 문자를 입력하려면, 버튼을 눌러야 한다. 버튼을 누르면 버튼에 쓰여 있는 문자가 입력되며, 버튼을 누를 때 마다 다음 문자로 바뀌게 된다. 예를 들어, 2를 누르면 A, 2번 누르면 B, 3번 누르면 C이다. 공백을 연속으로 누를 때는 기다릴 필요가 없다.

첫째 줄에 p와 w가 주어진다. (1 ≤ p, w ≤ 1,000) p는 버튼을 한번 누르는데 걸리는 시간이고, w는 AC와 같은, 같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간을 의미한다. 그리고 둘째 줄에는 적을 문자열이 주어진다. 단, 이 문자열의 길이는 1000보다 작고, 맨 앞과 맨 뒤에 공백이 들어오는 경우는 없다. 문자열은 알파벳 대문자와 띄어쓰기만으로 이루어져 있다.

첫째 줄에 메시지를 적는데 걸리는 시간을 출력한다.

2 10
ABBAS SALAM

72
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N2037 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int p = Integer.parseInt(stoi.nextToken());  // 버튼을 한 번  누르는데 걸리는 시간
        int w = Integer.parseInt(stoi.nextToken());  // 같은 숫자인 문자를 연속으로 찍기 위해 걸리는 시간

        String press = read.readLine();

        // 1은 공백
        int[] index = {3, 6, 9, 12, 15, 19, 22, 26};
        HashMap<Integer, Integer> range = new HashMap<>();
        
        int j = 0;
        for(int i = 1; i <= 26; i++) {
            if(i > index[j]) j++;
            range.put(i, j + 1);
        }

        int time = 0, prev = 0;
        for(int i = 0; i < press.length(); i++) {
            char now = press.charAt(i);

            if(now == ' ') {
                time += p;
                prev = 0;

                continue;
            }

            int order = 27 - (91 - (int) now);
            if(prev == range.get(order)) time += (p + w);
            else time += p;

            j = order - 1;
            while(range.get(j) == range.get(order)) {
                time += p;
                j--;
            }

            prev = range.get(order);
        }

        System.out.println(time);
    }
}
