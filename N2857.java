package BOJ;

/*
5명의 요원 중 FBI 요원을 찾는 프로그램을 작성하시오.

FBI요원은 요원의 첩보원명에 FBI가 들어있다. 

5개 줄에 요원의 첩보원명이 주어진다. 
첩보원명은 알파벳 대문자, 숫자 0~9, 대시 (-)로만 이루어져 있으며, 최대 10글자이다.

첫째 줄에 FBI 요원을 출력한다. 
이때, 해당하는 요원이 몇 번째 입력인지를 공백으로 구분하여 출력해야 하며, 오름차순으로 출력해야 한다. 
만약 FBI 요원이 없다면 "HE GOT AWAY!"를 출력한다.

N-FBI1
9A-USKOK
I-NTERPOL
G-MI6
RF-KGB1

1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            String name = read.readLine();

            if(name.contains("FBI")) build.append((i + 1) + "\n");
        }

        if(build.length() == 0) build.append("HE GOT AWAY!");

        System.out.println(build);
    }
}
