package BOJ;

/*
서양 음악의 음계는 12음으로 이루어져 있다.
A A# B C C# D D# E F F# G G#

이 12음은 무한히 반복된다. 
G#보다 높은음은 A이다.

한 음과 인접한 음은 반음 관계이다. 
#는 "사프"라고 읽으며, 음을 반음 높였다는 뜻이다. 
"A#"은 A를 반음 높인 음이라는 뜻이다.

플랫은 반음 내린다는 뜻이다. 
이 문제에서는 'b'로 표현한다.

#와 b를 이용한다면, 같은 음을 여러 가지 이름으로 부를 수 있다. 
A#과 Bb는 같은 음이다. 
B#은 C와 같으며, Fb는 E와 같다.

조옮김은 편곡에서 중요한 일 중 하나이다. 
조옮김이란 어떤 곡의 모든 음을 동일한 반음 개수만큼 올리거나 낮추는 작업이다. 
조옮김 작업을 했을 때, 모든 인접합 음의 반음 개수(음정 관계)는 작업을 하기 전과 같아야 한다.

어떤 곡이 주어졌을 때, 조옮김을 하는 프로그램을 작성하시오.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 어떤 곡의 음의 순서가 주어진다. 
음과 음은 하나 또는 그 이상의 공백으로 구분되어 있다. 
다음 줄에는 조옮김해야 하는 값이 주어진다. 
이 값이 양수일 경우 그 값만큼 위로 옮겨야 하고, 음수일 경우 아래로 옮겨야 한다.
입력의 마지막 줄에는 "***"이 주어진다.

각 테스트 케이스에 대해서, 조옮김한 결과를 출력한다. 
출력하는 음은 문제 설명에 나와있는 12개 음에 나와있는 음이어야 한다.

C# E Db G#
1
D E# D A
-1
***

D F D A
C# E C# G#
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N4732 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        String[] noteA = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
        
        ArrayList<String> note = new ArrayList<>();
        for(int i = 0; i < noteA.length; i++) {
            note.add(noteA[i]);
        }    
        
        while(true) {
            String start = read.readLine();

            if(start.equals("***")) break;

            StringTokenizer stoi = new StringTokenizer(start);

            int[] save = new int[stoi.countTokens()];
            int idx = 0;
            while(stoi.hasMoreTokens()) {
                String str = stoi.nextToken();
                save[idx] = note.indexOf(str);

                // 12개의 계이름 안에 들지 않을 때
                if(save[idx] == -1) {
                    if(str.charAt(1) == '#') {
                        save[idx] = note.indexOf(str.substring(0, 1)) + 1;
                    } else if(str.charAt(1) == 'b') {
                        save[idx] = note.indexOf(str.substring(0, 1)) - 1;
                    }
                }

                idx++;
            }

            int move = Integer.parseInt(read.readLine());

            for(int i = 0; i < save.length; i++) {
                int moveIdx = (((save[i] + move) % 12) < 0) ? (12 + (save[i] + move) % 12) : ((save[i] + move) % 12);
                // System.out.println(moveIdx);
                build.append(note.get(moveIdx) + " ");
            }

            build.append("\n");
        }
        
        System.out.println(build);
    }
}
