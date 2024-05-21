package BOJ;

/*
5학년은 다니기 싫은 아리는 4학년까지 졸업 학점을 채워 졸업할 수 있는지 궁금해졌다. 
아리가 졸업하려면 총 130학점 이상 들어야 하고, 그중 66학점 이상은 전공학점이어야 한다. 
아리는 현재 2021년 2학기까지 N학기를 마쳤고, 전공학점 A를 포함하여 총 B학점을 이수하였다. 
고민하던 아리는 학교 홈페이지에서 다음과 같은 공지가 올라온 것을 확인했다.

2022년 1학기부터 2026년 2학기까지 10개의 학기 동안 개설되는 과목의 수를 공지합니다.

2022년 1학기 : 전공과목 X1개, 비전공 과목 Y1개
2022년 2학기 : 전공과목 X2개, 비전공 과목 Y2개
2023년 1학기 : 전공과목 X3개, 비전공 과목 Y3개
 ⋮
2026년 2학기 : 전공과목 X10개, 비전공 과목 Y10개

2022년 1학기부터는 한 학기에 전공 수업과 비전공 수업을 포함하여 최대 6과목을 수강할 수 있습니다.

한 과목을 수강하게 되면 3학점을 얻게 되고, 그러므로 한 학기에 최대 18학점을 이수할 수 있습니다. 
참고하시기 바랍니다.

각 수업은 시간표가 서로 겹치지 않아서 아리는 원하는 수업을 모두 수강할 수 있다. 
아리는 최대한 빨리 졸업을 하고 싶어서 휴학을 하지 않는다. 
아리를 도와 아리가 전에 마쳤던 학기를 포함하여 총 8학기 안에 졸업할 수 있는지 확인하는 프로그램을 작성해보자.

세 정수 N(1 ≤ N ≤ 7), A(1 ≤ A ≤ 150), B(A ≤ B ≤ 150)이 주어진다.
다음 10개 줄에는 2022년 1학기부터 2026년 2학기까지 차례대로 학기에 개설되는 과목의 수가 주어지고, 한 줄에 한 학기의 전공과목 수 X(1 ≤ X ≤ 6), 비전공 과목 수 Y(1≤ Y ≤ 6)이 주어진다.

총 8학기 안에 졸업 조건을 맞출 수 있다면 "Nice"를, 불가능하다면 "Nae ga wae"를 출력한다.

7 60 120
4 3
3 4
1 6
4 3
3 4
1 6
4 3
3 4
1 6
6 6

Nice
 */

import java.io.*;
import java.util.StringTokenizer;

public class N23028 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int A = Integer.parseInt(stoi.nextToken());
        int B = Integer.parseInt(stoi.nextToken());

        for(int i = 0; i < 10; i++) {
            stoi = new StringTokenizer(read.readLine());
            int X = Integer.parseInt(stoi.nextToken());
            int Y = Integer.parseInt(stoi.nextToken());

            if(N >= 8) continue;

            int major = X <= 6 ? X : 6;
            int minor = 6 - major <= Y ? 6 - major : Y;

            A += major * 3;
            B += (major * 3 + minor * 3);
            
            N++;
        }

        // System.out.println(A +  " " + B);

        if(A >= 66 && B >= 130) System.out.println("Nice");
        else System.out.println("Nae ga wae");
    }
}