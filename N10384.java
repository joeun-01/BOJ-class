package BOJ;

/*
팬그램은 모든 알파벳을 적어도 한 번씩을 사용한 영어 문장을 말한다.
다음은 유명한 팬그램 중 하나이다.
The quick brown fox jumps over a lazy dog

더블 팬그램은 모든 알파벳을 적어도 두 번씩은 사용한 문장을 말하고,
트리플 팬그램은 모든 알파벳을 적어도 세 번씩은 사용한 문장을 말한다.
더 이어나갈 수도 있겠지만 시간상 여기까지만 하도록 하겠다.

입력은 여러 줄의 테스트케이스들로 이루어진다.
첫째 줄에 테스트케이스의 수 n이 주어진다.
각 테스트케이스는 영어 소문자와 대문자, 특수기호들로 이루어진다.

각 케이스마다 한 줄에 하나씩 다음 중 하나를 출력한다.

팬그램이 아닐 경우 - Not a pangram
팬그램일 경우 - Pangram!
더블 팬그램일 경우 - Double pangram!!
트리플 팬그램일 경우 - Triple pangram!!!
트리플 팬그램일 경우에는 자연스럽게 팬그램과 더블 팬그램이 되지만, Triple pangram!!!만을 출력한다. 
더블 팬그램도 마찬가지이다.

3
The quick brown fox jumps over a lazy dog.
The quick brown fox jumps over a laconic dog.
abcdefghijklmNOPQRSTUVWXYZ-zyxwvutsrqpon   2013/2014      MLKJIHGFEDCBA

Case 1: Pangram!
Case 2: Not a pangram
Case 3: Double pangram!!
 */

import java.io.*;
import java.util.HashMap;

public class N10384 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        HashMap<Character, Integer> letter = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String str = read.readLine().toUpperCase();

            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(65 <= (int)c && (int) c <= 90) {
                    letter.put(c, letter.getOrDefault(c, 0) + 1);
                }
                
            }

            // System.out.println();

            int min = Integer.MAX_VALUE;
            for(char key : letter.keySet()) {
                min = Math.min(min, letter.get(key));
                // System.out.println(key + " " + min);
            }

            if(letter.size() < 26) min = 0;

            if(min == 0) build.append("Case " + i + ": " + "Not a pangram\n");
            else if(min == 1) build.append("Case " + i + ": " + "Pangram!\n");
            else if(min == 2) build.append("Case " + i + ": " + "Double pangram!!\n");
            else if(min <= 3) build.append("Case " + i + ": " + "Triple pangram!!!\n");

            letter.clear();
        }

        System.out.println(build);
    }
}
