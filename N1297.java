package BOJ;

/*
김탑은 TV를 사러 인터넷 쇼핑몰에 들어갔다. 
쇼핑을 하던 중에, TV의 크기는 그 TV의 대각선의 길이로 나타낸다는 것을 알았다. 
하지만, 김탑은 대각선의 길이가 같다고 해도, 실제 TV의 크기는 다를 수도 있다는 사실에 직접 TV를 보러갈걸 왜 인터넷 쇼핑을 대각선의 길이만 보고있는지 후회하고 있었다.
인터넷 쇼핑몰 관리자에게 이메일을 보내서 실제 높이와 실제 너비를 보내달라고 했지만, 관리자는 실제 높이와 실제 너비를 보내지 않고 그것의 비율을 보내왔다.

TV의 대각선 길이와, 높이 너비의 비율이 주어졌을 때, 실제 높이와 너비의 길이를 출력하는 프로그램을 작성하시오.

첫째 줄에 TV의 대각선 길이 D, TV의 높이 비율 H, TV의 너비 비율 W이 공백 한 칸을 사이에 두고 주어진다.

첫째 줄에 TV의 높이와 TV의 너비를 공백 한 칸을 이용해서 구분지은 후 출력한다. 
만약, 실제 TV의 높이나 너비가 소수점이 나올 경우에는 그 수보다 작으면서 가장 큰 정수로 출력한다. (예) 1.7 -> 1

5 ≤ D ≤ 1,000
1 ≤ H ≤ 99
2 ≤ W ≤ 100
H < W
D, H, W는 정수

52 9 16

25 45
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int D = Integer.parseInt(stoi.nextToken());  // 대각선
        int H = Integer.parseInt(stoi.nextToken());  // 높이 비율
        int W = Integer.parseInt(stoi.nextToken());  // 너비 비율

        // H의 제곱 + W의 제곱 = D의 제곱
        float ratio = D / (float) Math.sqrt(H * H + W * W);

        build.append((int) Math.floor(H * ratio));
        build.append(" ");
        build.append((int) Math.floor(W * ratio));

        System.out.println(build);
    }
}