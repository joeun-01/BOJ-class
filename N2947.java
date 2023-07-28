package BOJ;

/*
동혁이는 나무 조각을 5개 가지고 있다. 
나무 조각에는 1부터 5까지 숫자 중 하나가 쓰여져 있다. 
또, 모든 숫자는 다섯 조각 중 하나에만 쓰여 있다.

동혁이는 나무 조각을 다음과 같은 과정을 거쳐서 1, 2, 3, 4, 5 순서로 만들려고 한다.

1. 첫 번째 조각의 수가 두 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
2. 두 번째 조각의 수가 세 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
3. 세 번째 조각의 수가 네 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
4. 네 번째 조각의 수가 다섯 번째 수보다 크다면, 둘의 위치를 서로 바꾼다.
5. 만약 순서가 1, 2, 3, 4, 5 순서가 아니라면 1 단계로 다시 간다.

처음 조각의 순서가 주어졌을 때, 위치를 바꿀 때 마다 조각의 순서를 출력하는 프로그램을 작성하시오.

첫째 줄에 조각에 쓰여 있는 수가 순서대로 주어진다. 
숫자는 1보다 크거나 같고, 5보다 작거나 같으며, 중복되지 않는다. 
처음 순서는 1, 2, 3, 4, 5가 아니다.

두 조각의 순서가 바뀔때 마다 조각의 순서를 출력한다.

2 1 5 3 4

1 2 5 3 4
1 2 3 5 4
1 2 3 4 5
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] wood = new int[5];
        for(int i = 0; i < 5; i++) {
            wood[i] = Integer.parseInt(stoi.nextToken());
        }

        while(true) {
            for(int i = 0; i < 4; i++) {
                if(wood[i] > wood[i + 1]) {
                    int temp = wood[i];
                    wood[i] = wood[i + 1];
                    wood[i + 1] = temp;

                    for(int j = 0; j < 5; j++) {
                        build.append(wood[j] + " ");
                    }
                    build.append("\n");
                }
            }

            int right = 0;
            for(int i = 0; i < 5; i++) {
                if(wood[i] == i + 1) right++;
            }

            if(right == 5) break;
        }

        System.out.println(build);
    }
}
