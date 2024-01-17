package BOJ;

/*
마트료시카는 속이 비어있는 인형이다. 
성빈이는 N개의 마트료시카를 가지고 있다. 
i번째 마트료시카의 크기는 a_i이고, 마트료시카 속은 모두 비어있다.

성빈이는 남아 있는 마트료시카 중에서 i번째와 j번째(i != j) 마트료시카를 고른 뒤에 i번째 마트료시카를 j번째 마트료시카 속에 넣을 수 있다. 
단, j번째 마트료시카의 속이 비어있어야 하고, i번째 마트료시카보다 j번째 마트료시카가 더 커야 한다. 
합친 후에는 남아 있는 마트료시카의 개수가 한 개 줄어든다.

성빈이는 마트료시카를 최대한 합쳐서 정리하려고 한다. 
성빈이가 마트료시카를 잘 합친다면 남아 있는 마트료시카의 최소 개수는 얼마일까?

첫째 줄에 마트료시카의 개수 N(1 <= N <= 1000)이 주어진다.
둘째 줄에 정수 a_1, a_2, ... , a_N이 주어진다. 
a_i(1 <= a_i <= 10^9)는 i번째 마트료시카의 크기이다.

남아있는 마트료시카의 최소 개수를 출력한다.

3
1 2 3

1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            array.add(Integer.parseInt(stoi.nextToken()));
        }

        Collections.sort(array);

        int cnt = 1;
        int min = 0, idx = 0;
        while(!array.isEmpty()) {
            if(idx >= array.size()) {
                min = 0;
                idx = 0;
                cnt++;
            }

            int cur = array.get(idx);
            if(cur > min) {
                min = cur;
                array.remove(idx);

                idx--;
            }

            idx++;
        }

        System.out.println(cnt);
    }
}