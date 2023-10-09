package BOJ;

/*
승엽이는 자신의 감정을 표현하기 위해서 종종 문자 메시지에 이모티콘을 넣어 보내곤 한다. 
승엽이가 보내는 이모티콘은 세 개의 문자가 붙어있는 구조로 이루어져 있으며, 행복한 얼굴을 나타내는 :-) 와 슬픈 얼굴을 나타내는 :-( 가 있다.

혜성이는 승엽이의 이모티콘을 귀여운 척이라고 생각해 매우 싫어하므로, 승엽이의 문자가 오면 전체적인 분위기만 판단해서 알려주는 프로그램을 작성하고 싶다.

첫 줄에 최소 1개에서 최대 255개의 문자들이 입력된다.

출력은 다음 규칙에 따라 정해진다.
어떤 이모티콘도 포함되어 있지 않으면, none 을 출력한다.
행복한 이모티콘과 슬픈 이모티콘의 수가 동일하게 포함되어 있으면, unsure 를 출력한다.
행복한 이모티콘이 슬픈 이모티콘보다 많이 포함되어 있으면, happy 를 출력한다.
슬픈 이모티콘이 행복한 이모티콘보다 많이 포함되어 있으면, sad 를 출력한다.

How are you :-) doing :-( today :-)?

happy
 */

import java.io.*;
import java.util.HashMap;

public class N10769 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> emoji = new HashMap<>();
        emoji.put(":-)", 0);
        emoji.put(":-(", 0);


        String str = read.readLine();
        if(str.length() >= 3) {
            for(int i = 1; i < str.length() - 1; i++) {
                if(str.charAt(i - 1) == ':' && str.charAt(i) == '-' && str.charAt(i + 1) == ')') {
                    emoji.put(":-)", emoji.get(":-)") + 1);
                } else if(str.charAt(i - 1) == ':' && str.charAt(i) == '-' && str.charAt(i + 1) == '(') {
                    emoji.put(":-(", emoji.get(":-(") + 1);
                }
            }

            int happy = emoji.get(":-)");
            int sad = emoji.get(":-(");

            if(happy == 0 && sad == 0) System.out.println("none");
            else if(happy == sad) System.out.println("unsure");
            else if(happy > sad) System.out.println("happy");
            else System.out.println("sad");
        } else {
            System.out.println("none");
        }
    }   
}