package BOJ;

/*
선영이는 집 호수에 반복되는 숫자가 있는 경우에는 그 집에 사는 사람에게 불운이 찾아온다고 믿는다.
따라서, 선영이는 838호나 1004호와 같이 한 숫자가 두 번 이상 들어있는 집에는 절대 살지 않을 것이다.

2050년, 선영이는 한국에서 가장 돈이 많은 사람이 되었다. 
그녀는 해변가에 새로운 호텔을 하나 지으려고 한다. 
하지만, 투숙객에게 불운이 찾아오는 것을 피하기 위해서 반복되는 숫자가 없게 방 번호를 만들려고 한다.

정부는 선영이의 호텔 방 번호는 N보다 크거나 같고, M보다 작거나 같아야 한다는 조건을 걸고 신축 허가를 내주었다. 선영이의 새 호텔에는 방이 최대 몇 개 있을 수 있을까? (두 방이 같은 방 번호를 사용할 수 없다)

입력은 여러 개의 테스트 케이스로 이루어져 있고, 한 줄이다. 각 줄에는 문제의 설명에 나와있는 N과 M이 주어진다. (1 ≤ N ≤ M ≤ 5000)

각각의 테스트 케이스에 대해서 N보다 크거나 같고, M보다 작거나 같은 수 중에서 반복되는 숫자가 없는 것의 개수를 출력한다.

87 104
989 1022
22 25
1234 1234

14
0
3
1
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N5671 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String str = "";
        HashSet<Character> set = new HashSet<>(); 
        while((str = read.readLine()) != null) {
            StringTokenizer stoi = new StringTokenizer(str);
            int N = Integer.parseInt(stoi.nextToken());
            int M = Integer.parseInt(stoi.nextToken());

            int result = 0;
            for(int i = N; i <= M; i++) {
                String room = Integer.toString(i);

                for(int j = 0; j < room.length(); j++) {
                    char num = room.charAt(j);
                    set.add(num);
                }

                if(set.size() == room.length()) {
                    // System.out.println(room + ", " + set.toString());
                    result++;
                }

                set.clear();
            }

            build.append(result + "\n");
        }

        System.out.println(build);
    }
}