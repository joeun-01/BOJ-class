package BOJ;

/*
빈 박스 N개가 한 줄로 놓여져 있고, 박스에 책 M개를 넣으려고 한다. 
박스는 1번부터 N번까지 번호가 매겨져 있고, 책도 1번부터 M번까지 번호가 매겨져 있다. 
다음은 책을 박스에 넣는 방법이며, 가장 처음에는 1번 박스의 앞에 있고, 손에는 1번 책을 들고 있다.

1. 현재 책이 현재 박스에 들어가지 않으면, 3번으로 간다. 아니면 2번으로 간다.
2. 현재 책을 현재 박스에 넣는다. 다음 책을 손에 집고 1번으로 간다.
3. 현재 박스를 다른 쪽으로 치운 다음에, 테이프로 못 열게 봉인한다. 다음 박스를 앞으로 가져오고 1번으로 간다.

i번 박스의 용량은 Ai이고, j번 책의 크기는 Bj이다. 
책의 크기와 박스에 들어있는 책의 크기의 합이 박스의 용량을 넘지 않으면 책을 박스에 넣을 수 있다.

위의 방법대로 책을 넣었을 때, 전체 박스의 낭비된 용량의 합을 구하는 프로그램을 작성하시오. 
박스의 낭비된 용량은 박스의 용량에서 박스에 들어있는 책의 크기의 합을 뺀 값이다.

입력으로 주어진 박스와 책의 순서를 변경하면 안된다.

첫째 줄에 박스의 개수 N, 책의 개수 M이 주어진다. 
둘째 줄에는 박스의 용량 A1, A2, ..., AN이 주어지고, 셋째 줄에는 B1, B2, ..., BM이 주어진다.

첫째 줄에 전체 박스의 낭비된 용량의 합을 출력한다.

1 ≤ N, M ≤ 50
1 ≤ Ai, Bj ≤ 1,000
문제에 주어진 방법으로 모든 책을 박스에 넣을 수 있는 경우만 입력으로 주어진다.

3 3
5 5 5
5 5 5

0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1434 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        StringTokenizer box = new StringTokenizer(read.readLine());
        StringTokenizer book = new StringTokenizer(read.readLine());

        int waste = 0, fill = 0;
        int current = 0;

        int[] box_wei = new int[N + 1];
        for(int i = 0; i < N; i++) {
            box_wei[i] = Integer.parseInt(box.nextToken());
        }

        for(int i = 0; i < M; i++) {
            int book_wei = Integer.parseInt(book.nextToken());

            if(fill + book_wei <= box_wei[current]) {
                fill += book_wei;
            } else {
                waste += (box_wei[current] - fill);
                fill = 0;

                current++;

                while(true) {
                    if(fill + book_wei <= box_wei[current]) {
                        fill += book_wei;
                        break;
                    } else {
                        waste += (box_wei[current] - fill);
                        fill = 0;

                        current++;
                    }
                }
            }
        }

        waste += box_wei[current] - fill;
        for(int i = current + 1; i < N; i++) {
            waste += box_wei[i];
        }

        System.out.println(waste);
    }
}