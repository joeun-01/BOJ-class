package BOJ;

/*
Vigenere cipher이라는 암호화 방법은 암호화하려는 문장 (평문)의 단어와 암호화 키를 숫자로 바꾼 다음, 평문의 단어에 해당하는 숫자에 암호 키에 해당하는 숫자를 더하는 방식이다. 
이 방법을 변형하여 평문의 단어에 암호화 키에 해당하는 숫자를 빼서 암호화하는 방식을 생각해 보자.

예를 들어 암호화 키가 love이고, 암호화할 문장이 “nice day” 라면 다음과 같이 암호화가 이루어진다.

제시된 평문의 첫 번째 문자인 ‘n’은 해당 암호화 키 ‘l’의 알파벳 순서가 12 이므로 알파벳상의 순서에서 ‘n’보다 12앞의 문자인 ‘b’로 변형된다.
변형된 문자가 ‘a' 이전의 문자가 되면 알파벳 상에서 맨 뒤로 순서를 돌린다. 
예를 들면 평문의 세 번째 문자인‘c’는 알파벳 상에서 3 번째이고 대응하는 암호화키 ‘v'는 알파벳 순서 22로 ‘c'에서 22 앞으로 당기면 ‘a'보다 훨씬 앞의 문자이어야 하는데, ‘a’앞의 문자가 없으므로 ‘z’로 돌아가 반복되어 ‘g’가 된다. 
즉 평문의 문자를 암호화키의 문자가 알파벳 상에서 차지하는 순서만큼 앞으로 뺀 것으로 암호화한다.
평문의 문자가 공백 문자인 경우는 그 공백 문자를 그대로 출력한다.
이와 같은 암호화를 행하는 프로그램을 작성하시오.

첫째 줄에 평문이, 둘째 줄에 암호화 키가 주어진다.
평문은 알파벳 소문자와 공백문자(space)로만 구성되며, 암호화 키는 알파벳 소문자만으로 구성된다. 
평문의 길이는 공백까지 포함해서 30000자 이하이다.

첫 번째 줄에 암호문을 출력한다.

nice day
love

btgz oet
 */

import java.io.*;

public class N1718 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String origin = read.readLine();
        String key = read.readLine();

        char[] keys = key.toCharArray();
        for(int i = 0; i < origin.length(); i++) {
            if(origin.charAt(i) == ' ') {
                build.append(' ');
                continue;
            }

            int diff = (int) keys[i % key.length()] - 97 + 1;

            char secret;
            if((int) origin.charAt(i) - diff < 97) {
                int temp = 97 - ((int) origin.charAt(i) - diff);
                secret = (char) (123 - temp);
            } else {
                secret = (char) (origin.charAt(i) - diff);
            }

            build.append(secret);
        }

        System.out.println(build);
    }
}