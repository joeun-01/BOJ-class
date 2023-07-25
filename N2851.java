package BOJ;

/*
슈퍼 마리오 앞에 10개의 버섯이 일렬로 놓여져 있다. 
이 버섯을 먹으면 점수를 받는다.

슈퍼 마리오는 버섯을 처음부터 나온 순서대로 집으려고 한다. 
하지만, 모든 버섯을 집을 필요는 없고 중간에 중단할 수 있다. 
중간에 버섯을 먹는 것을 중단했다면, 그 이후에 나온 버섯은 모두 먹을 수 없다. 
따라서 첫 버섯을 먹지 않았다면, 그 이후 버섯도 모두 먹을 수 없다.

마리오는 받은 점수의 합을 최대한 100에 가깝게 만들려고 한다.
버섯의 점수가 주어졌을 때, 마리오가 받는 점수를 출력하는 프로그램을 작성하시오.

총 10개의 줄에 각각의 버섯의 점수가 주어진다. 
이 값은 100보다 작거나 같은 양의 정수이다. 
버섯이 나온 순서대로 점수가 주어진다.

첫째 줄에 마리오가 받는 점수를 출력한다. 
만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택한다.

10
20
30
40
50
60
70
80
90
100

100
 */

import java.io.*;

public class N2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] mushroom = new int[10];
        for(int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(read.readLine()); 
        }

        int eat = 0, i = 0;
        while(i < 10) {
            if(eat + mushroom[i] >= 100) {
                if(100 - eat >= eat + mushroom[i] - 100) {
                    eat += mushroom[i];
                }

                break;
            }

            eat += mushroom[i];
            i++;
        }

        System.out.println(eat);
    }
}
