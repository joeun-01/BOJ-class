package BOJ;

/*
N마리의 청설모가 1번부터 N번까지 순서대로 시계 방향으로 원을 이루면서 앉아있다. 
타노스는 손을 튕겨서 순서대로 두 번째 청설모를 제거해 왔는데, 옆 나라의 수학자 요세푸스도 이미 그 방식을 사용해 왔다는 것을 알자 기분이 상했다. 
그래서 타노스는 새롭게 청설모를 제거하는 방식을 고안했다.

시작은 1번 청설모를 첫 번째 청설모로 한다. 
타노스가 손을 튕기면 첫 번째 청설모부터 시계 방향으로 K마리의 청설모가 선택된다. 
이후 첫 번째 청설모를 제외한 2, ... , K번째 청설모가 번호가 증가하는 순서대로 제거되고 첫 번째 청설모만 살아남는다. 
단, 남아 있는 청설모가 K마리보다 적으면 첫 번째 청설모를 제외한 모든 청설모가 제거된다. 
제거된 후 남아있는 청설모가 2마리 이상일 경우 첫 번째 청설모의 오른쪽 청설모가 첫 번째 청설모가 되고, 제거하는 과정을 다시 진행한다. 
이 과정은 청설모가 1마리 남을 때까지 계속된다.

N, K가 주어질 때 마지막으로 남는 청설모의 번호를 구하여라.

첫째 줄에 정수 N과 K가 공백을 사이에 두고 주어진다. (2 <= N, K <= 10^{6})

마지막으로 남는 청설모의 번호를 출력한다.

5 4

5
 */

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N28066 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deque.push(i);
        }

        int size = deque.size();
        while(size != 1) {
            if(size < K) {
                System.out.println(deque.pollFirst());;
            }

            size = deque.size();
        }
    }
}
