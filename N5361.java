package BOJ;

/*
상근이는 망가진 전투 드로이드를 고치려고 하고 있다. 
전투 드로이드의 각 부품의 가격은 다음과 같다.

블래스터 라이플	$350.34
시각 센서	$230.90
청각 센서	$190.55
팔	$125.30
다리	$180.90

첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스는 음이 아닌 정수 다섯 개(A B C D E)로 이루어져 있다.

A: 필요한 블래스터 라이플의 개수
B: 필요한 시각 센서의 개수
C: 필요한 청각 센서의 개수
D: 필요한 팔의 수
E: 필요한 다리의 수

각 테스트 케이스 마다, 입력으로 주어진 부품을 모두 구매하는데 필요한 비용을 소수점 둘째 자리까지 출력한다. 
달러 표시도 출력해야 한다. 
정답은 1억보다 작거나 같다.

3
20 10 14 3 9
19 17 12 8 10
11 9 8 22 33

$13987.50
$15679.76
$16182.54
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N5361 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            float sum = 0;
            sum += Integer.parseInt(stoi.nextToken()) * 350.34;
            sum += Integer.parseInt(stoi.nextToken()) * 230.90;
            sum += Integer.parseInt(stoi.nextToken()) * 190.55;
            sum += Integer.parseInt(stoi.nextToken()) * 125.30;
            sum += Integer.parseInt(stoi.nextToken()) * 180.90;

            build.append("$" + String.format("%.2f", sum) + "\n");
        }

        System.out.println(build);
    }
}
