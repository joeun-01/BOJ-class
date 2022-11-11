package BOJ;

/*
 * 명령은 총 여섯 가지이다.
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * 
 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 
 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 * 
 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 * 
 * 15
 * push 1
 * push 2
 * front
 * back
 * size
 * empty
 * pop
 * pop
 * pop
 * size
 * empty
 * pop
 * push 3
 * empty
 * front
 * 
 * 1
 * 2
 * 2
 * 0
 * 1
 * 2
 * -1
 * 0
 * 1
 * -1
 * 0
 * 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());

        int[] queue = new int[10000];
        int front = -1, back = -1;

        int i;
        for(i = 0; i < num; i++) {
            String commend = read.readLine();

            if(commend.contains("push")) {
                String[] split = commend.split(" ");
                back++;
                queue[back] = Integer.parseInt(split[1]);
            } else if(commend.equals("pop")) {
                if(front == back) {
                    build.append("-1\n");
                } else {
                    front++;
                    build.append(queue[front] + "\n");
                }
            } else if(commend.equals("size")) {
                build.append(back - front + "\n");
            } else if(commend.equals("empty")) {
                if(front == back) {
                    build.append("1\n");
                } else {
                    build.append("0\n");
                }
            } else if(commend.equals("front")) {
                if(front == back) {
                    build.append("-1\n");
                } else {
                    build.append(queue[front + 1] + "\n");
                }
            } else if(commend.equals("back")) {
                if(front == back) {
                    build.append("-1\n");
                } else {
                    build.append(queue[back] + "\n");
                }
            }
        }

        System.out.println(build);
    }   
}
