package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
용모는 유치원에서 아이들을 위해 자원봉사를 하고 있다.

오늘의 활동은 구슬 N개를 줄로 이어 팔찌를 만드는 것이다. 
각 구슬에는 서로 다른 수가 하나씩 적혀 있는데, 두 구슬 사이를 잇는 줄의 길이는 두 구슬에 적힌 수들의 차의 절댓값이 되어야 한다. 
선생님은 이 활동을 통해 아이들이 뺄셈을 즐겁게 배우길 기대하고 있다.

용모는 아이들에게 완성된 팔찌의 견본을 보여주는 역할을 맡았다. 
선생님은 똑똑한 용모에게 N개의 구슬을 건네주며, N개의 구슬로 팔찌를 만들되 줄을 가능한 적게 사용할 것을 부탁하였다. 
하지만 자원봉사를 너무 열심히 하느라 지친 용모는 필요한 줄의 최소 길이를 구할 방법이 생각나질 않았다. 
여러분이 용모 대신 N개의 구슬로 팔찌를 만드는데 필요한 줄의 최소 길이를 구해주자.

첫 번째 줄에 구슬의 개수 N이 주어진다.
두 번째 줄에 각 구슬에 적힌 수 N개가 공백으로 구분되어 차례로 주어진다.

N개의 구슬을 모두 사용하여 조건에 맞게 팔찌를 만들 때 사용하는 줄의 길이의 최솟값을 출력한다.

3 ≤ N ≤ 1,000
1 ≤ 구슬에 적힌 수 ≤ 109
각 구슬에 적힌 수는 모두 다르다.

5
7 9 5 1 3

16
 */

public class N25707 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] rings = new int[N];
        for(int i = 0; i < N; i++) {
            rings[i] = Integer.parseInt(stoi.nextToken());
        }

        Arrays.sort(rings);

        Deque<Integer> deque = new LinkedList<>();
        deque.add(rings[N - 1]);

        int sum = 0;
        for(int i = N - 2; i >= 0; i--) {
            if(deque.getFirst() - rings[i] < deque.getLast() - rings[i]) {
                sum += deque.getFirst() - rings[i];
                deque.addFirst(rings[i]);
            } else {
                sum += deque.getLast() - rings[i];
                deque.addLast(rings[i]);
            }

            for(int num : deque) {
                System.out.print(num + " ");
            }

            System.out.println();
        }

        System.out.println(sum);
    }
}