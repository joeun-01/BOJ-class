package BOJ;

/*
N장의 카드가 좌우 일렬로 놓여있다. 
각 카드에는 하나의 정수가 적혀있는데, 왼쪽에서 i번째 카드에 적혀있는 정수는 Ai다. (1 ≤ i ≤ N)

여러분은 N장의 카드 중 몇 장을 골라 제거할 수 있다. 
이때, 제거되지 않은 카드의 순서는 유지된다.

예를 들어, N = 5, A = [3, 1, 4, 1, 5]라고 하자. 
여러분이 두 번째와 다섯 번째 카드를 제거한다면, 남은 카드들에 적혀있는 수들은 왼쪽부터 차례대로 3, 4, 1이 된다. 
즉, 남은 카드들 중 왼쪽에서 세 번째 카드에 적혀있는 수는 1이 된다.

몇 장의 카드를 골라 제거한 후, 남은 카드들 중 왼쪽에서 x번째 카드에 적혀있는 수가 정확히 x라면, 그 카드를 제자리 카드라고 부르자. 
모든 남은 카드가 제자리 카드라면, 제자리 상태가 되었다고 하자.

예를 들어, N = 8, A = [6, 1, 2, 3, 2, 4, 5, 10]라고 하자. 
여러분이 첫 번째, 다섯 번째, 여덟 번째 카드를 제거하면, 남은 카드들에 적혀있는 수들은 차례대로 1, 2, 3, 4, 5가 된다. 
이때, 모든 남은 카드는 제자리 카드가 되며, 따라서 제자리 상태가 되었다.

만약, N = 6, A = [3, 4, 6, 10, 2, 5]라면, 제자리 상태가 되기 위해서는 모든 카드를 제거하여 남은 카드가 하나도 없도록 해야 한다.
모든 카드를 제거하면 항상 제자리 상태가 됨에 유의하라.

최소 몇 장의 카드를 제거해야 제자리 상태가 되는지 계산하는 프로그램을 작성하라.

첫 번째 줄에 정수 N이 주어진다.
두 번째 줄에 N개의 정수 A1, ... , AN이 차례대로 주어진다.

첫 번째 줄에 답을 출력한다.

1
1

0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N25400 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(stoi.nextToken()));
        }

        int idx = 0, cnt = 0;
        while(idx < list.size()) {
            if(list.get(idx) == idx + 1) {
                idx++;
            } else {
                list.remove(idx);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}