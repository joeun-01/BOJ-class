package BOJ;

/*
동현이는 볼링을 사랑하는 훌륭한 프로그래머다. 
오늘도 볼링을 치고 싶은 동현이는 자신의 볼링공 컬렉션을 보면서 어떤 볼링공을 가져갈지 고민에 빠졌다. 
동현이는 매일의 컨디션에 따라 아주 미세한 무게까지 컨트롤하고 싶기 때문에 다양한 무게의 볼링공이 매우 많다. 
볼링공을 관리하는 사물함에는 사물함 안에 들어 있는 볼링공들의 무게가 적혀 있고, 하나의 사물함에 여러 개의 볼링공이 들어갈 수 있다. 
동현이는 오로지 볼링에만 집중하고 싶기 때문에 볼링공 관리는 여러분에게 맡기기로 했다.
동현이의 요청에 따라 볼링공을 관리해 보자!

요청은 다음과 같다.
1 x w: x번 사물함에 w 무게의 볼링공을 넣는다.
2 w: w 무게를 가진 볼링공이 들어 있는 사물함의 번호를 출력한다.
동현이의 볼링공은 무게가 모두 다르기 때문에 2번 요청의 답은 항상 하나만 존재한다.

2번 요청이 들어올 때, w 무게를 가진 볼링공은 무조건 어딘가에 존재한다.

첫 번째 줄에 요청의 개수 M(1 <= M <= 500,000)이 주어진다.
두 번째 줄부터 이어지는 M개의 줄에 요청이 주어진다.

1 x w: x번 사물함에 w 무게의 볼링공을 넣는다. (1 <= x <= 1,000,000, x는 정수), (1 <= w <= 10^9, w는 정수)
2 w: w 무게를 가진 볼링공이 들어 있는 사물함의 번호를 출력한다. (1 <= w <= 10^9, w는 정수)
2번 요청이 들어올 때, w 무게를 가진 볼링공은 무조건 어딘가에 존재한다.
2번 요청은 최소 1번 이상 들어온다.

2번 요청이 들어올 때 사물함의 번호를 출력한다.

5
1 5 900
1 7 300
1 15 100
2 300
2 100

7
15
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N28446 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            String option = stoi.nextToken();

            if(option.equals("1")) {
                int locker = Integer.parseInt(stoi.nextToken());
                long weight = Integer.parseInt(stoi.nextToken());

                map.put(weight, locker);
            } else if(option.equals("2")) {
                long weight = Integer.parseInt(stoi.nextToken());
                build.append(map.get(weight)).append("\n");
            }
        }

        System.out.println(build);
    }
}