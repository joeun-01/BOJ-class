package BOJ;

/*
병현이는 지은이에게 문자 A, B, C, D, E, F, G, H 로 쓰여진 편지를 날마다 보내는데, 컴퓨터로 보내는 비밀편지로, 한 문자마다 0 또는 1인 숫자 여섯 개를 사용하여 보낸다. 
둘 사이의 약속은 다음과 같다.

A 000000
B 001111
C 010011
D 011100
E 100110
F 101001
G 110101
H 111010

병현이가 어느 날 001111000000011100 을 보내면 지은이는 이것을 BAD로 이해하게 된다. 
그런데 둘 사이에 약속이 잘 만들어져 있기 때문에, 통신에 문제가 생겨서 한 문자를 표시하는 여섯 숫자 중 어느 한 숫자만 틀리게 오는 경우, 지은이는 원래 보내려는 문자를 알아 낼 수가 있다.
예를 들어 지은이가 000100을 받았을 때, A와 숫자 한자만 다르고, 다른 문자들과는 각각 숫자 두 자 이상이 다르므로 지은이는 이것이 A라고 알아보게 된다.

다만 111111과 같이 모든 문자의 표현과 숫자 두 자 이상이 다른 경우에는 무슨 문자인지 알 수가 없게 된다. 
예를 들어 지은이가 011111000000111111000000111111 을 받았을 때, BA 다음에 알아 볼 수 없는 문자가 나오는데. 이 경우 이런 것이 처음 나오는 문자의 위치인 3을 출력한다.

지은이가 받은 편지를 보고 문자들을 알아내어 출력하거나, 모르는 문자가 있는 경우, 이것이 처음 나오는 위치를 출력하는 프로그램을 작성하시오.

첫줄에는 보낸 문자의 개수(10개 보다 작다.)가 입력된다. 
다음 줄에는 문자의 개수의 여섯 배 만큼의 숫자 입력이 주어진다.

주어진 입력에서 지은이가 이해한 문자들을 출력하거나, 모르는 문자가 나오는 경우 그런 것이 처음 나오는 위치를 출력한다.

3
001111000000011100

BAD
 */

import java.io.*;
import java.util.HashMap;

public class N2596 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        read.readLine();
        String password = read.readLine();

        HashMap<String, Character> letter = new HashMap<>();
        letter.put("000000", 'A');
        letter.put("001111", 'B');
        letter.put("010011", 'C');
        letter.put("011100", 'D');
        letter.put("100110", 'E');
        letter.put("101001", 'F');
        letter.put("110101", 'G');
        letter.put("111010", 'H');

        String decrypt = "";
        boolean success = true;
        int index = 0;
        for(int i = 0; i < password.length(); i += 6) {
            String word = password.substring(i, i + 6);
            if(letter.containsKey(word)) {
                decrypt += letter.get(word);
            } else {
                int min = Integer.MAX_VALUE;
                for(String key : letter.keySet()) {
                    int wrong = 0;
                    for(int j = 0; j < key.length(); j++) {
                        if(key.charAt(j) != word.charAt(j)) wrong++;
                    }

                    min = Math.min(wrong, min);
                    if(min == 1) {
                        decrypt += letter.get(key);
                        break;
                    };
                }

                if(min > 1) {
                    success = false;

                    index = i / 6 + 1;
                    break;
                }
            }
        }

        if(success) System.out.println(decrypt);
        else System.out.println(index);
    }
}
