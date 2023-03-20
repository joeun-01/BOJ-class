package BOJ;

/*
유명 편의점 체인점 세븐25는 삼각 김밥을 전국에서 가장 싸게 판매하고 있다. 
이 회사의 직원들은 삼각 김밥의 가격을 전국 최저가를 유지하기 위해 매일 근처의 편의점을 방문한다. 
그리고 나서 세븐25의 삼각 김밥보다 싼 가격을 발견하면, 삼각 김밥의 가격을 그 가격으로 바꿔 최저가를 유지한다.

매일 아침, 점심, 저녁으로 삼각 김밥을 먹는 상근이와 정인이는 정말 세븐25가 제일 싼지 궁금해졌다. 
이들은 학교 근처에 있는 세븐 25와 세븐 25를 제외한 서로 다른 N개의 편의점 체인을 방문 할 것이다. 
이 편의점을 방문하면서 세븐25보다 싼 삼각김밥을 찾을 것이다. 
또, 전체 편의점에서 가장 싼 삼각 김밥은 어디인지 찾을 것이다.

어느 편의점의 삼각 김밥이 제일 싼지 고객들이 쉽게 알지 못하기 하기 위해서, 모든 편의점은 삼각 김밥의 가격을 다음과 같이 표시한다. 
"삼각 김밥 Y그램 당 X원"

상근이와 정인이는 삼각 김밥을 1,000그램 살 것이다.
세븐 25의 삼각 김밥 가격과, 다른 N개 편의점의 삼각 김밥 가격이 주어졌을 때, 1,000그램의 삼각 김밥을 가장 싸게 사려면 얼마면 되는지 구하는 프로그램을 작성하시오.
삼각 김밥은 여러 군데에서 돌아가면서 사도 되고, 세븐 25와 N개 편의점 이외의 다른 곳에서는 살 수 없다.

첫째 줄에 세븐25의 삼각 김밥 가격 정보 X와 Y가 주어진다. (Y그램 당 X원) (1 ≤ X ≤ 100, 1 ≤ Y ≤ 1,000)
둘째 줄에는 세븐25를 제외한 편의점의 개수 N이 주어진다. (1 ≤ N ≤ 100)
다음 N개의 줄에는 i번째 편의점의 삼각 김밥 가격 정보 Xi와 Yi가 주어진다. (Yi그램 당 Xi원) (1 ≤ Xi ≤ 100, 1 ≤ Yi ≤ 1,000)

첫째 줄에 삼각 김밥 1,000그램 가격의 최저가를 출력한다. 
정답과의 오차는 0.01까지 허용한다.

5 100
3
4 100
3 100
7 100

30.00
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N2783 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int X = Integer.parseInt(stoi.nextToken());
        int Y = Integer.parseInt(stoi.nextToken());

        float min = X / (float) Y * 1000;

        int N = Integer.parseInt(read.readLine());

        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());

            int gram = Integer.parseInt(stoi.nextToken());
            int won = Integer.parseInt(stoi.nextToken());

            float money = gram / (float) won * 1000;

            min = Math.min(min, money);
        }

        System.out.println(String.format("%.02f", min));
    }
}