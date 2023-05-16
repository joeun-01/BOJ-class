package BOJ;

/*
알파벳 대문자로 구성되어있는 문자열 S가 주어졌을 때, S에 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 구하는 프로그램을 작성하시오.

문자열 S가 “ABCDEFGHIJKLMNOPQRSTUVW” 일 때, S에 등장하지 않는 알파벳 대문자는 X, Y, Z이다. X의 아스키 코드 값은 88, Y는 89, Z는 90이므로 이 아스키 코드 값의 합은 267이다.

알파벳 대문자의 아스키 코드 값은 다음과 같다.

A	B	C	D	E	F	G	H	I	J	K	L	M	N	O	P	Q	R	S	T	U	V	W	X	Y	Z
65	66	67	68	69	70	71	72	73	74	75	76	77	78	79	80	81	82	83	84	85	86	87	88	89	90

입력은 T개의 테스트 데이터로 구성된다. 
입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
각 테스트 데이터는 한 줄로 구성되어 있고, 문자열 S가 주어진다.
S는 알파벳 대문자로만 구성되어 있고, 최대 1000글자이다.

각 테스트 데이터에 대해, 입력으로 주어진 문자열 S에 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 한 줄에 하나씩 출력한다.

2
ABCDEFGHIJKLMNOPQRSTUVW
A

267
1950
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        for(int i = 0; i < T; i++) {
            boolean[] cnt = new boolean[26];
            String str = read.readLine();

            for(int j = 0; j < str.length(); j++) {
                char alpha = str.charAt(j);
                cnt[alpha - 65] = true;
            }

            int sum = 0;
            for(int j = 0; j < 26; j++) {
                if(!cnt[j]) sum += (j + 65);
            }

            build.append(sum + "\n");
        }

        System.out.println(build);
    }
}