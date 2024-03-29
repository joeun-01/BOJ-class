package BOJ;

/*
영어에서는 어떤 글자가 다른 글자보다 많이 쓰인다. 예를 들어, 긴 글에서 약 12.31% 글자는 e이다.
어떤 글이 주어졌을 때, 가장 많이 나온 글자를 출력하는 프로그램을 작성하시오.

첫째 줄부터 글의 문장이 주어진다. 
글은 최대 50개의 줄로 이루어져 있고, 각 줄은 최대 50개의 글자로 이루어져 있다. 
각 줄에는 공백과 알파벳 소문자만 있다. 
문장에 알파벳은 적어도 하나 이상 있다.

첫째 줄에 가장 많이 나온 문자를 출력한다. 여러 개일 경우에는 알파벳 순으로 앞서는 것부터 모두 공백없이 출력한다.

english is a west germanic
language originating in england
and is the first language for
most people in the united
kingdom the united states
canada australia new zealand
ireland and the anglophone
caribbean it is used
extensively as a second
language and as an official
language throughout the world
especially in common wealth
countries and in many
international organizations

a
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.io.IOException;

public class N1371 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> alpha = new HashMap<>();
        for(int i = 0; i < 26; i++) {
            alpha.put((char) (i + 97), 0);
        }

        String str = "";
        int max = Integer.MIN_VALUE;
        while((str = read.readLine()) != null) { 
            for(int i = 0; i < str.length(); i++) {
                
                char key = str.charAt(i);
                if(key != ' ') {
                    int value = alpha.getOrDefault(key, 0) + 1;

                    alpha.put(key, value);

                    if(max < value) max = value;
                }
            }
        }

        String result = "";
        for(Character key : alpha.keySet()) {
            if(alpha.get(key) == max) result += key;
        }
        
        System.out.println(result);
    }
}