package BOJ;

/*
워드, 한글, 메모장과 같은 워드 프로세서에서 인쇄를 할 때, 페이지 범위를 직접 입력하여 지정할 수 있다. 
예를 들면, 다음과 같이 입력할 수 있다.

10-15,25-28,8-4,13-20,9,8-8

사용자는 위처럼 인쇄하고자 하는 범위를 콤마로 구분하여 입력할 수 있다.

각 인쇄 범위는 양의 정수 하나 또는 하이픈(-)로 구분된 두 양의 정수이다. 
수 두 개로 이루어진 범위에서 앞의 수를 low, 뒤의 수를 high라고 한다. 
만약, low > high인 경우에는 이 범위는 인쇄하지 않는다. 
또, 인쇄 범위가 문서의 범위를 넘어가는 경우에는 출력할 수 있는 페이지만 출력한다. 
페이지 번호는 1부터 시작한다.

인쇄 범위는 겹칠 수 있다. 
겹치는 페이지는 여러 번 인쇄하는 것이 아니고, 한 번만 인쇄해야 한다. (위의 예제에서 13, 14, 15는 두 범위에 포함된다)

인쇄 범위가 주어졌을 때, 출력해야 하는 페이지의 수를 구하는 프로그램을 작성하시오.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 문서의 총 페이지 수가 주어진다. 
둘째 줄에는 인쇄 범위가 문제 설명에 나온 형식과 같이 주어진다. 
입력의 마지막에는 0이 하나 주어진다. 
문서는 많아야 1000페이지이고, 인쇄 범위의 길이는 1000글자를 넘지 않는다.

각 테스트 케이스에 대해서, 출력해야 하는 페이지의 수를 출력한다.

30
10-15,25-28,8-4,13-20,9,8-8
19
10-15,25-28,8-4,13-20,9,8-8
0

17
12
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N4821 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            int page = Integer.parseInt(read.readLine());
            if(page == 0) break;

            HashSet<Integer> set = new HashSet<>();

            StringTokenizer stoi = new StringTokenizer(read.readLine(), ",");
            while(stoi.hasMoreTokens()) {
                StringTokenizer range = new StringTokenizer(stoi.nextToken(), "-");

                if(range.countTokens() == 1) {
                    int low = Integer.parseInt(range.nextToken());
                    if(low <= page) set.add(low);
                } else {
                    int low = Integer.parseInt(range.nextToken());
                    int high = Integer.parseInt(range.nextToken());

                    // System.out.println(low + " " + high);

                    if(low > high || low > page) continue;
                    if(high > page) high = page;

                    for(int i = low; i <= high; i++) {
                        set.add(i);
                    }
                }

                // System.out.println(set.size());

            }

            build.append(set.size() + "\n");
        }

        System.out.println(build);
    }
}
