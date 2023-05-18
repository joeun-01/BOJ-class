package BOJ;

/*
부산사이버대학교 학생 성택이는 엄마의 의뢰를 받아 주어진 문자열이 현관문 비밀번호에 사용 가능한지 알아내야 한다. 
성택이는 공부해야 하므로 우리가 도와주자!

사용할 수 있는 비밀번호의 규칙은 다음과 같다.

비밀번호는 6자리 이상 9자리 이하여야 한다.
예를 들어, 123124는 올바른 비밀번호이고, 1202727161은 잘못된 비밀번호이다. 
문자열이 주어졌을 때 현관문 비밀번호로 사용할 수 있는지 판단하자.

첫째 줄에 문자열의 총개수 N이 주어진다.
둘째 줄부터 N개의 줄에 걸쳐 숫자, 영어 대소문자로만 구성된 문자열이 주어진다.

줄마다 사용할 수 있는 비밀번호면 yes, 그렇지 않으면 no를 출력한다.

1 ≤ N ≤ 1000
문자열의 길이는 1자리 이상 20자리 이하이다.

3
1245125
asdij
120318739721

yes
no
no
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            String str = read.readLine();

            if(str.length() > 5 && str.length() < 10) {
                build.append("yes\n");
            } else {
                build.append("no\n");
            }
        }

        System.out.println(build);
    }
}