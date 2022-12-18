package BOJ;

/*
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. 
AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 
이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 수의 순서를 뒤집는 함수이고, D는 첫 번째 수를 버리는 함수이다. 
배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 
예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 
예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 수를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. 
p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 
만약, 에러가 발생한 경우에는 error를 출력한다.

4
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]

[2,1]
error
[1,2,3,5,8]
error
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class N5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());

        for(int i = 0; i < num; i++) {
            String func = read.readLine();

            // int size = Integer.parseInt(read.readLine()); 노란색을 없애기 위한 주석 처리

            StringTokenizer token = new StringTokenizer(read.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            while(token.hasMoreTokens()) {
                deque.add(Integer.parseInt(token.nextToken()));
            }

            boolean reverse = false;
            boolean error = false;
            
            for(int j = 0; j < func.length(); j++) {
                String letter = func.substring(j, j + 1);
                if(letter.equals("R")) {  
                    // 배열 뒤집기
                    reverse = !reverse;
                } else if(letter.equals("D")) {  
                    if(deque.size() == 0) {
                        build.append("error\n");
                        error = true;
                        break;
                    } else {
                        // 첫 번째 수 빼기
                        if(reverse) {  // 뒤집힌 상태
                            deque.removeLast();
                        } else {  // 원래 상태
                            deque.removeFirst();
                        }
                    }
                }
            }
// 1 2    front = 0 back = 1  front = 1 back = 1
            if(!error) {
                if(reverse) {  // 뒤집힌 상태면 거꾸로 출력
                    build.append("[");
                    while(deque.size() != 0) {
                        build.append(deque.pollLast());
                        
                        if(deque.size() != 0) build.append(",");
                    }
                    build.append("]\n");
                } else {  // 뒤집힌 상태가 아니라면 똑바로 출력
                    build.append("[");
                    while(deque.size() != 0) {
                        build.append(deque.pollFirst());
                        
                        if(deque.size() != 0) build.append(",");
                    }
                    build.append("]\n");
                }
            }
        }
        
        System.out.println(build);
    }
}
