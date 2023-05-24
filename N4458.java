package BOJ;

/*
문장을 읽은 뒤, 줄의 첫 글자를 대문자로 바꾸는 프로그램을 작성하시오.

첫째 줄에 줄의 수 N이 주어진다. 다음 N개의 줄에는 문장이 주어진다. 각 문장에 들어있는 글자의 수는 30을 넘지 않는다. 모든 줄의 첫 번째 글자는 알파벳이다.

각 줄의 첫글자를 대문자로 바꾼뒤 출력한다.

5
powdered Toast Man
skeletor
Electra Woman and Dyna Girl
she-Ra Princess of Power
darth Vader

Powdered Toast Man
Skeletor
Electra Woman and Dyna Girl
She-Ra Princess of Power
Darth Vader
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N4458 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            String str = read.readLine();

            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            build.append(str + "\n");
        }

        System.out.println(build);
    }
}