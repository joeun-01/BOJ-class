package BOJ;

/*
영선회사는 야근이 매우 잦은 회사이다. 
다행히도 야근수당을 챙겨 주기는 하는데, 사장 nein은 매우 악덕한 사장이기 때문에 최대한 야근 수당을 안 챙겨주려 한다.

영선회사이 야근인지 확인하는 방법은 다음과 같다. 
매우 이른 아침부터 퇴근시간까지 출입기록이 주어진다. 
만약, 들어간 기록은 없는데, 나온 기록이 있다면 회사에서 야근을 한 것으로 기록된다. 
또한 회사에 들어갔는데, 퇴근시간까지 나오지 않는다면, 이 또한 야근을 하는 것으로 기록된다. 
출입기록에 따라서 두 기준 다 만족할 수도 있는데, 이는 야근을 두 번 한 것으로 인정된다. 
하지만, 회사에 계속 있었지만 나오거나 들어가지를 않아 출입기록이 없다면 야근을 한 것으로 인정하지 않는다.

그리고 이 출입기록에는 치명적인 단점이 있는데, 동명이인을 구별하지 못한다는 것이다. 
이름이 같은 경우, 같은 사람으로 인식하며, 둘다 회사에 남아있거나 들어간 기록 없이 나온 기록이 있는 식으로, 명확히 보이는 경우에만 복수로 야근이 인정된다.

영선회사의 오늘의 출입기록이 주어진다. 
이 기록을 바탕으로 모든 직원의 야근 횟수의 합을 출력하시오.

첫째 줄에는 출입기록의 개수 q가 주어진다.( 1≤q≤100,000)

다음 q줄에는 이름 s와 들어간지 나간지에 대한 정보 p가 주어지는데, p는 ‘+’일 때 들어간 것이고, ‘-‘일 때 나간 것이다. 
이름의 길이는 30자를 넘지 않는다. 
이름은 소문자로만 이루어져 있다.

출입기록을 바탕으로 모든 직원의 야근 횟수의 합을 출력하시오.

7
nein +
nein -
nein -
nein -
nein +
nein +
nein +

5
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N14402 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        HashMap<String, Boolean> enter = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            String name = stoi.nextToken();
            char record = stoi.nextToken().charAt(0);

            if(enter.get(name) == null) {
                if(record == '+') {
                    enter.put(name, true);
                } else {
                    enter.put(name, false);
                    cnt++;
                }

                continue;
            }

            // System.out.print(enter + " ");

            if(record == '+') {
                if(enter.get(name)) cnt++;
                else enter.put(name, true);
            } else if(record == '-') {
                if(enter.get(name)) enter.put(name, false);
                else cnt++;
            }
        }

        for(String name : enter.keySet()) {
            if(enter.get(name)) cnt++;
        }

        System.out.println(cnt);
    }
}