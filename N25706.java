package BOJ;

/*
길이가 N미터인 직선 자전거 도로가 있다. 
도로는 길이가 1미터인 N개의 칸으로 구분되어 있고, 가장 왼쪽에 있는 칸부터 순서대로 1번 칸, 2번 칸, …, N번 칸이다.

도로의 각 칸에는 점프대가 설치되어 있을 수 있다. 
i(1 ≤ i ≤ N)번 칸에 설치된 점프대의 높이를 hi라고 하자. 
높이가 hi인 점프대를 밟으면 그 어떤 요인과도 관계없이 다음 hi칸 위를 비행한 뒤 그다음 칸에 착지한다. 
다음 예시를 확인해 보자.

자전거를 타고 1번 칸에서 출발해 앞으로 달리면 다음과 같은 일들이 순서대로 일어난다.

1. 1번 칸에 점프대가 없으므로 2번 칸으로 주행한다.
2. 2번 칸에 높이가 1인 점프대가 있어 3번 칸 위를 비행하여 4번 칸에 착지한다.
3. 4번 칸에 높이가 2인 점프대가 있어 5, 6번 칸 위를 비행하여 7번 칸에 착지한다.
4. 7번 칸에 점프대가 없으므로 8번 칸으로 주행한다.
5. 8번 칸에 높이가 3인 점프대가 있어 9번 칸 위를 비행하여 저 멀리 나아간다. (만일 도로가 충분히 길었다면 가상의 12번 칸에 착지하였을 것이다.)

시은이는 각 칸에서 자전거를 타고 출발해 앞으로 달릴 때, 도로 위 몇 개의 칸을 밟게 될지 알아보려 한다. 
하지만 N개의 칸에 대해 일일이 실험해 보는 건 너무 수고스럽고 귀찮은 일이 아닌가? 
다음과 같은 표를 만들고 열심히 머리를 굴리던 시은이는 깨달음을 얻었다. 
오른쪽에 있는 칸의 답을 활용해 왼쪽에 있는 칸의 답을 쉽게 구할 수 있다는 것이다!

출발한 칸	답	밟는 칸
1	5	1, 2, 4, 7, 8
2	4	2, 4, 7, 8
3	4	3, 4, 7, 8
4	3	4, 7, 8
5	3	5, 7, 8
6	3	6, 7, 8
7	2	7, 8
8	1	8
9	1	9
점프대가 없는 1번 칸의 답은 바로 다음 2번 칸의 답에 1을 더한 것과 같다. 
높이 1의 점프대가 있는 2번 칸의 답은 한 칸을 건너뛴 4번 칸의 답에 1을 더한 것과 같다. 
다른 칸들도 같은 방식으로 답을 구할 수 있다. 
특히 도로를 벗어나게 되는 8번 칸과 9번 칸의 답은 1(각각 밟는 칸이 8번, 9번뿐이다) 임을 확인하자.

여러분이 할 일은 이 놀라운 사실을 이용해 시은이의 궁금증을 해결하는 프로그램을 만드는 것이다. 
이 사실을 이용하지 않으면 채점 결과로 시간초과를 받을 수 있으니 되도록이면 이용해 보자.

첫번째 줄에 도로의 길이 N이 주어진다.
두번째 줄에 1번 칸부터 N번 칸까지 순서대로 각 칸에 설치된 점프대의 높이가 공백을 구분으로 주어진다. 
단, 점프대가 없는 칸은 0이 주어진다.

1번 칸부터 N번 칸까지 순서대로, 각 칸에서 자전거를 타고 앞으로 달리면 총 몇 개의 칸을 밟게 되는지 출력한다. 
각 출력은 공백으로 구분한다.

9
0 1 0 2 1 0 0 3 0

5 4 4 3 3 3 2 1 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N25706 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] height = new int[N];
        for(int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(stoi.nextToken());
        }

        int[] DP = new int[N + 1];
        for (int i = N; i > 0; i--) {
            int nextIndex = i + height[i - 1] + 1;
            if (nextIndex <= N) {
                DP[i] = DP[nextIndex] + 1;
            } else {
                DP[i] = 1;
            }
        }
        
        for(int i = 1; i <= N; i++) {
            build.append(DP[i]).append(" ");
        }

        System.out.println(build);
    }
}