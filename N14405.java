package BOJ;

/*
피카츄는 "pi", "ka", "chu"를 발음할 수 있다. 
따라서, 피카츄는 이 세 음절을 합친 단어만 발음할 수 있다. 
예를 들면, "pikapi"와 "pikachu"가 있다.

문자열 S가 주어졌을 때, 피카츄가 발음할 수 있는 문자열인지 아닌지 구하는 프로그램을 작성하시오.

첫째 줄에 문자열 S가 주어진다. 
문자열은 알파벳 소문자로 이루어진 문자열이며, 길이는 5000을 넘지 않는다.

문자열 S가 "pi", "ka", "chu"를 이어 붙여서 만들 수 있으면 "YES"를 아니면 "NO"를 출력한다.

pikapi

YES
 */

import java.io.*;

public class N14405 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = read.readLine();

        int i = 0;
        boolean possible = true;
        while(i < str.length()) {
            char letter = str.charAt(i);
            if(letter == 'p' && i + 2 <= str.length()) {
                if(str.substring(i, i + 2).equals("pi")) {
                    i += 2;
                } else {
                    possible = false;
                    break;
                }
            } else if(letter == 'k' && i + 2 <= str.length()) {
                if(str.substring(i, i + 2).equals("ka")) {
                    i += 2;
                } else {
                    possible = false;
                    break;
                }
            } else if(letter == 'c' && i + 3 <= str.length()) {
                if(str.substring(i, i + 3).equals("chu")) {
                    i += 3;
                } else {
                    possible = false;
                    break;
                }
            } else {
                possible = false;
                break;
            }
        }
        
        if(possible) System.out.println("YES");
        else System.out.println("NO");
    }
}