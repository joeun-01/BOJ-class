package BOJ;

/*
사이클 단어는 어떤 단어를 원형 모양으로 차례대로 쓴 것이다. 
따라서, 어떤 단어를 이렇게 쓴 후에 임의의 단어를 고른다. 
그 후에 시계방향으로 차례대로 읽으면 그 것이 단어가 된다. 
만약에 단어 A와 단어 B가 있을 때, 단어 B를 원형으로 써서, 단어 A와 같이 읽을 수 있으면, 두 단어는 같은 단어이다. 
따라서, picture와 turepic은 같은 단어다.

N개의 단어가 주어졌을 때, 서로 다른 단어가 총 몇 개인지 구하는 프로그램을 작성하시오.

첫째 줄에 단어의 개수 N이 주어진다. 
둘째 줄부터 단어가 한 줄에 하나씩 주어진다. 
단어는 영어 소문자로만 이루어져 있다. 
N은 50보다 작거나 같은 자연수이며, 단어의 길이는 최대 50이다.

첫째 줄에 서로 다른 단어가 몇 개인지 출력한다.

5
picture
turepic
icturep
word
ordw

2
 */

import java.io.*;
import java.util.HashSet;

public class N1544 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            // 새로운 글자를 탐색
            String word = read.readLine();
            int wordLength = word.length();

            // 기존 Set에서 같은 글자가 있는지 확인
            int cnt = 0;
            for(String key : set) {
                int keyLength = key.length();
                if(wordLength != keyLength) {  // 글자 개수가 다르면 다른 글자
                    cnt++;
                    continue;
                }

                // 글자 개수가 같으면 원형으로 돌아가면서 같은지 확인
                int same = 0;  // 같은 글자의 개수
                for(int j = 0; j < wordLength; j++) {
                    // 먼저 같은 글자 위치를 찾음
                    if(key.charAt(0) == word.charAt(j)) {
                        // 찾으면 해당 위치에서부터 끝까지 검사
                        same = 0;
                        for(int k = j; k < j + wordLength; k++) {
                            if(key.charAt(k - j) == word.charAt(k % wordLength)) {
                                same++;
                            }
                        }
                    }

                    // 글자가 같다고 판단되면 break
                    if(same == wordLength) break;
                }

                // 같은 글자가 있으면 break;
                if(same == wordLength) break;

                cnt++;  // 같은 글자가 아니면 cnt++
            }

            // 기존 Set을 다 검사했을 때 같은 글자가 없으면 word를 Set에 추가함
            if(cnt == set.size()) set.add(word);
        }

        System.out.println(set.size());
    }
}