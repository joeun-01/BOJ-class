package BOJ;

/*
2학년이 된 김한양은 한양대학교의 3대 관문 중 하나인 전문학술영어를 수강하게 됐다. 
그런데, 갑자기 올해부터는 전학영이 2인1조 팀플로 진행된다는 공지가 떴다. 
팀 구성은 자유이지만, 7수를 한 김한양은 나이가 너무 많아 다들 같은 팀이 되기 싫어한다. 
따라서, 마지막에 남은 한 명과 같이 해야 한다.

학생들은 모두 자신의 최애의 팀원을 찾기로 했다. 
김한양을 제외한 N명의 학생들은 일렬로 선 다음, 가장 앞에 선 학생부터 자신의 최애의 팀원을 한 명씩 찾아간다. 
최애의 팀원을 찾는 방법은 다음과 같다.

가장 앞에 선 학생은 뒤돌아 서서 나머지 학생들을 마주본다. 
마주보고 있는 학생들 중 가장 앞 사람(즉, 현재 팀원을 찾고 있는 학생과 가장 가까운 학생)이 자신의 팀원이면 둘이 손을 잡고 떠난다. 
만약, 자신의 팀원이 아니면 "패스"를 외친다. 
"패스"를 외치면 팀원 후보 중 가장 앞 사람은 한 바퀴 돌아서 다시 줄의 맨 끝에 서면 된다. 
가장 앞에 선 학생의 학번 마지막 두 자리가 X일 때, 이 학생의 팀원은 X-1명의 학생을 패스시키고 만난 X번째 학생이다.

이 과정을 반복하며 학생들은 차례차례 손을 잡고 나갈 것이며, 마지막으로 남은 사람이 김한양의 최애의 팀원이 된다. 
김한양의 최애의 팀원을 찾기 위한 여정을 도와주자.

첫 번째 줄에 정수 N(1 ≤ N ≤ 1,000)이 주어진다. (단, N은 홀수이다.)

이후 2부터 N+1번째 줄까지 일렬로 서 있는 학생들의 이니셜과 학번의 마지막 두 자리가 공백으로 구분되어 주어진다. 
이니셜은 대문자 알파벳 한 글자에서 최대 세 글자까지 주어진다. 
학번이 00인 경우는 없고, 십의 자리가 0인 경우는 표시하지 않는다.

김한양의 최애의 팀원의 이니셜을 출력한다.

5
A 3
B 2
C 8
D 5
E 4

B
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N29813 {
    public static class Student {
        String initial;
        int studentNum;

        public Student(String initial, int studentNum) {
            this.initial = initial;
            this.studentNum = studentNum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        Queue<Student> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            String initial = stoi.nextToken();
            int studentNum = Integer.parseInt(stoi.nextToken());

            queue.add(new Student(initial, studentNum));
        }

        while (!(queue.size() == 1)) {
            Student front = queue.poll();

            int studentNum = front.studentNum;
            while(studentNum > 1) {
                queue.add(queue.poll());
                studentNum--;
            }

            queue.poll();
        }

        System.out.println(queue.poll().initial);
    }
}