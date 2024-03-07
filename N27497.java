package BOJ;

/*
스타는 알파벳 블록을 일렬로 조립하여 문자열을 만드는 게임을 만들었다. 
각 블록에는 문자 하나가 적혀 있으며 게임에는 각각 다음 기능을 수행하는 세 개의 버튼이 있다.

- 문자열 맨 뒤에 블록 추가
- 문자열 맨 앞에 블록 추가
- 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
게임은 처음에 빈 문자열로 시작하며 빈 문자열일 때 문자열을 구성하는 블록 중 가장 나중에 추가된 블록을 제거하는 버튼을 누를 경우 아무런 동작도 하지 않는다. 
버튼을 누른 횟수와 누른 버튼이 순서대로 주어질 때 완성된 문자열을 구하여라.

첫째 줄에 버튼을 누른 횟수 N이 주어진다. (1 <= N <= 1,000,000) 

둘째 줄부터 N개의 줄에는 버튼을 누른 순서대로 누른 버튼에 대한 정보를 주며 아래와 같은 형식으로 주어진다.

1 c : 문자열 맨 뒤에 c가 적힌 블록 추가
2 c : 문자열 맨 앞에 c가 적힌 블록 추가
3 : 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
c는 알파벳 대문자 또는 소문자로 주어진다.

완성된 문자열을 출력한다. 
완성된 문자열이 빈 문자열인 경우 0을 출력한다.

5
1 a
2 b
1 c
3
3

a
 */

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class N27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        Deque<String> dqeue = new LinkedList<>();
        Stack<Boolean> direction = new Stack<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            char button = stoi.nextToken().charAt(0);
            
            if(button == '1') {
                dqeue.addLast(stoi.nextToken());
                direction.push(false);
            } else if(button == '2') {
                dqeue.addFirst(stoi.nextToken());
                direction.push(true);
            } else if(button == '3') {
                if(!dqeue.isEmpty()) {
                    if(direction.pop()) dqeue.pollFirst();
                    else dqeue.pollLast();
                }
            }

            // System.out.println(dqeue);
        }

        if(dqeue.isEmpty()) {
            build.append(0);
        } else {
            for(String letter : dqeue) {
                build.append(letter);
            }
        }

        System.out.println(build);
    }
}