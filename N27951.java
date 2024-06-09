package BOJ;

/*
경기과학고등학교에는 아주 무시무시한 부서 하나가 있다. 
그 부서의 이름은 바로 '자치부'이다. 
'자치부'가 하는 주된 역할 중 하나는 아침에 지정된 기숙사에 들어가서 방의 정리 정돈 상태를 확인하고 검사하는 일이다. 
은호는 자치부의 일원으로서 기숙사 호실들을 모두 점검하게 되었다. 
근데, 은호가 점검하는 호실마다 옷들이 너저분하게 깔려있었고 심각하게 어질러져 있었다. 
이에 은호는 기숙사 대청소 날을 만들어 기숙사 옷들을 모두 정리하려고 한다.

은호가 경곽의 옷걸이 조사해 보았더니 총 세 가지 종류가 있었다. 
하나는 상의만 걸 수 있는 옷걸이, 또 다른 하나는 하의만 걸 수 있는 옷걸이, 마지막 하나는 상의와 하의 모두 걸 수 있는 옷걸이다. 
하나의 옷걸이에는 하나의 상의 또는 하의만 걸 수 있음을 유의하자.

은호는 기숙사 옷들을 정리하기 전에 옷걸이가 모든 옷을 걸기에 부족하지는 않은지 조사하고자 한다. 
은호는 경곽 기숙사에 있는 상의와 하의의 개수, 그리고 옷걸이의 개수와 그 종류를 모두 조사했다. 
놀랍게도 옷걸이의 개수와 옷의 개수는 같았다. 
다만, 옷이 너무 많았기 때문에 은호는 프로그램을 이용해 모든 옷을 정리할 수 있는지 없는지 구하고자 한다. 
또 만약 정리할 수 있으면, 어떻게 걸면 옷을 모두 정리할 수 있는지 알고 싶어 한다.

은호는 건표와 급한 약속이 있어서 이 프로그램 구현을 여러분에게 맡기고 갔다. 
은호를 대신해서 프로그램을 짜주자.

첫째 줄에는 옷걸이의 개수 N이 주어진다.
둘째 줄에는 N개의 정수가 주어진다. i번째 정수 Ai는 옷걸이의 종류를 나타낸다.

1은 상의 걸이를, 2는 하의 걸이를, 3은 모두 걸 수 있는 옷걸이를 나타낸다.

마지막 줄에는 두 정수 U, D가 주어진다. U는 상의의 개수, D는 하의의 개수이다. U+D=N 임이 보장된다.

첫째 줄에 주어진 상의와 하의를 옷걸이에 모두 걸 수 있으면 'YES'를, 아니면 'NO'를 출력한다.
만약 모두 걸 수 있다면 둘째 줄에 각 옷걸이에 어떻게 걸었는지를 길이가 N인 문자열 형태로 출력한다.

문자열에서 i번째 문자는 i번째 옷걸이에 건 의상의 종류를 나타내며, 'U'인 경우 상의를, 'D'인 경우 하의를 걸었음을 나타낸다. (작은따옴표는 출력하지 않는다.)
문자는 모두 대문자로 출력해야 한다.

5
3 3 3 3 3
2 3

YES
UUDDD
 */

import java.io.*;
import java.util.*;

public class N27951 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] hangers = new int[N];
        for(int i = 0; i < N; i++) {
            int hanger = Integer.parseInt(stoi.nextToken());
            hangers[i] = hanger;
        }

        stoi = new StringTokenizer(read.readLine());
        int up = Integer.parseInt(stoi.nextToken());
        int down = Integer.parseInt(stoi.nextToken());

        char[] answer = new char[N];
        Arrays.fill(answer, 'N');

        for(int i = 0; i < N; i++) {
            if(hangers[i] == 1) {
                if(up > 0) {
                    answer[i] = 'U';
                    up--;
                }
            } else if(hangers[i] == 2) {
                if(down > 0) {
                    answer[i] = 'D';
                    down--;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(answer[i] == 'N') {
                if(hangers[i] == 3) {
                    if(up > 0) {
                        answer[i] = 'U';
                        up--;
                    } else if(down > 0) {
                        answer[i] = 'D';
                        down--;
                    }
                } else {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        if(up > 0 || down > 0) {
            System.out.println("NO");
        } else {
            for(char letter : answer) {
                build.append(letter);
            }

            System.out.println("YES");
            System.out.println(build);
        }
    }
}