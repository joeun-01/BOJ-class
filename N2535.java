package BOJ;

/*
최근 아시아 지역의 학생들만 참여하는 정보 올림피아드 대회가 만들어졌다. 
이 대회는 온라인으로 치러지기 때문에 각 나라에서 이 대회에 참여하는 학생 수의 제한은 없다. 

참여한 학생들의 성적순서대로 세 명에게만 금, 은, 동메달을 수여한다. 
단, 동점자는 없다고 가정한다. 
그리고 나라별 메달 수는 최대 두 개다.

예를 들어, 대회 결과가 다음의 표와 같이 주어졌다고 하자.

참가국	학생번호	점수
1	1	230
1	2	210
1	3	205
2	1	100
2	2	150
3	1	175
3	2	190
3	3	180
3	4	195

이 경우, 금메달 수상자는 1번 국가의 1번 학생이고, 은메달 수상자는 1번 국가의 2번 학생이며, 동메달 수상자는 3번 국가의 4번 학생이다. 
(1번 국가의 3번 학생의 성적이 동메달 수여자보다 높지만, 나라 별 메달 수가 두 개 이하 이므로 1번 국가 3번 학생은 동메달을 받을 수 없다.)
대회 결과가 입력으로 주어질 때, 메달 수상자를 결정하여 출력하는 프로그램을 작성하시오.

첫 번째 줄에는 대회참가 학생 수를 나타내는 N이 주어진다. 
단, 3 ≤ N ≤ 100이다. 
두 번째 줄부터 N개의 줄에는 각 줄마다 한 학생의 소속 국가 번호, 학생 번호, 그리고 성적이 하나의 빈칸을 사이에 두고 주어진다. 
단, 국가 번호는 1부터 순서대로 하나의 정수로 주어지며, 각 학생번호는 각 나라별로 1부터 순서대로 하나의 정수로 주어진다.
점수는 0 이상 1000 이하의 정수이고, 동점자는 없다고 가정한다. 
입력으로 제공되는 국가는 적어도 두 나라 이상이다.

메달을 받는 학생들을 금, 은, 동메달 순서대로 한 줄에 한 명씩 출력한다. 
즉, 첫 번째 줄에는 금메달 수상자를, 두 번째 줄에는 은메달 수상자를, 세 번째 줄에는 동메달 수상자를 출력한다. 
하나의 줄에는 소속국가 번호와 학생 번호를 하나의 빈칸을 사이에 두고 출력한다. 

9
1 1 230
1 2 210
1 3 205
2 1 100
2 2 150
3 1 175
3 2 190
3 3 180
3 4 195

1 1
1 2
3 4
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2535 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        int[][] array = new int[N][3];
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            int country = Integer.parseInt(stoi.nextToken());
            int student = Integer.parseInt(stoi.nextToken());
            int score = Integer.parseInt(stoi.nextToken());

            array[i][0] = country;
            array[i][1] = student;
            array[i][2] = score;
        }

        Arrays.sort(array, (s1, s2) -> {
            return s2[2] - s1[2];
        });

        // for(int i = 0; i < N; i++) {
        //     System.out.println(array[i][0] + " " + array[i][1] + " " + array[i][2]);
        // }

        int[] count = new int[N + 1];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(cnt == 3) break;
            
            if(count[array[i][0]] < 2) {
                count[array[i][0]]++;

                build.append(array[i][0] + " " + array[i][1] + "\n");
                cnt++;
            }
        }

        System.out.println(build);
    }
}