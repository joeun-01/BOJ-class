package BOJ;

/*
Misfits 아카데미는 문제아들을 위한 치유 시간을 도입했습니다. 
그 중 한 가지 활동은 아이들이 타인에 대해 예의를 갖출 수 있도록 고안되었으며, 내용은 아래와 같습니다.

아이들은 원형으로 앉은 뒤 종이 위에 자신의 이름을 적습니다. 
다음 각자의 종이를 자기 왼편으로 전달합니다. 
종이를 전달받았으면, 종이 맨 위에 쓰인 이름을 가진 아이에 대해 좋은 메시지를 써줍니다. 
"너는 멋져.", "도와줘서 고마워"같은 말들을요. 
메시지는 종이 아래쪽에 적으며, 적은 뒤에는 종이를 접어 가립니다. 
다음으로 종이를 왼편으로 넘기고 같은 활동을 반복합니다. 
자신의 이름이 맨 위에 적힌 종이를 받으면 활동을 종료하고 각자 다른 아이들이 자기에게 남긴 메시지들을 읽어봅니다.

하지만 가끔 "넌 너무 말이 많아.", "니 옷 후져."처럼 제멋대로 글을 쓰는 아이들이 있습니다. 
이런 글을 읽게 되면 기분이 좋지 않겠죠? 이런 말을 한 아이를 알려주세요!

입력은 번호를 가진 그룹들로 이루어져 있습니다.
그룹의 번호는 1부터 시작하며 1씩 증가합니다. 
각 그룹의 입력은 참여한 아이들의 수 n(5 ≤ n ≤ 20)이 한 줄에 주어지면서 시작됩니다. 
다음 n 줄에 걸쳐 위 활동을 끝마친 종이 n장이 입력됩니다. 
n 줄의 순서는 아이들이 앉아있고 종이를 넘기던 순서와 같습니다. 
예를 들어 첫 번째 줄에 해당하는 아이는 두 번째 줄에 해당하는 아이에게 종이를 넘겼고, 마지막 줄에 해당하는 아이는 첫 번째 줄에 해당하는 아이에게 종이를 넘겼습니다.

각 줄은 종이 맨 위의 이름으로 시작합니다. 
다음으로 공백을 사이에 두고 종이에 적힌 메시지가 종이 위에서부터 아래로 순서대로 쓰입니다. 
문제를 간단하게 하기 위해 좋은 메시지는 'P'로, 나쁜 메시지는 'N'으로 표기합니다. 
이름은 60글자 이하의 알파벳 소문자 또는 대문자로 이루어져 있습니다.

마지막 줄에 '0'이 입력되면서 입력이 종료됩니다. 
'0'은 처리하지 않습니다.

그룹 번호를 "Group 1"과 같이 출력함으로써 출력을 시작합니다. 
그 다음 줄부터 누가(A) 누구(B)에게 나쁜 말을 했는지 "A was nasty about B"로 한 줄씩 출력합니다. 
나쁜 말이 여러 개라면, 입력받은 순서대로─첫 번째 종이부터, 왼쪽에서 오른쪽으로─출력합니다. 
아무도 나쁜 말을 하지 않았다면 "Nobody was nasty"를 출력합니다.
각 그룹을 빈 줄로 구분합니다.

5
Ann P N P P
Bob P P P P
Clive P P P P
Debby P N P P
Eunice P P P P
6
Zheng P P P P P
Yeng P P P P P
Xiao P P P P P
Will P P P P P
Veronica P P P P P
Utah P P P P P
0

Group 1
Debby was nasty about Ann
Bob was nasty about Debby

Group 2
Nobody was nasty
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1384 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int group = 1;
        while(true) {
            int n = Integer.parseInt(read.readLine());
            if(n == 0) break;
            
            build.append("Group " + group + "\n");

            ArrayList<String> name = new ArrayList<>();
            boolean[][] letter = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer stoi = new StringTokenizer(read.readLine());
                String receiver = stoi.nextToken();
                name.add(receiver);

                int idx = i - 1;
                while(stoi.hasMoreTokens()) {
                    idx = (idx < 0) ? n - 1 : idx;

                    //System.out.println(i + " " + idx + "\n");

                    if(stoi.nextToken().equals("N")) {
                        letter[i][idx] = true;
                    }
                    idx--;
                }
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                int j = i - 1;
                while(true) {
                    j = (j < 0) ? n - 1 : j;
                    if(i == j) break;

                    if(letter[i][j]) {
                        build.append(name.get(j) + " was nasty about " + name.get(i) + "\n");
                        cnt++;
                    }
                    j--;
                }
            }

            if(cnt == 0) build.append("Nobody was nasty\n");

            build.append("\n");
            group++;
        }

        System.out.println(build);
    }
}
