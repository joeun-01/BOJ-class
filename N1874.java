package BOJ;

/*
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 
 * 이를 계산하는 프로그램을 작성하라.
 * 
 * 스택과 스택에서 뽑은 순서대로 늘어놓는 리스트가 있는 것
 * 
 * 예제 입력
 * 8 4 3 6 8 7 5 2 1
 * 
 * 예제 출력
 * + + + + - - + + - + + - - - - -
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N1874 {
    public static void main(String[] agrs) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int num = Integer.parseInt(read.readLine());

        ArrayList<Integer> numList = new ArrayList<>();  // 받은 수열

        int[] stack = new int[num];
        int top = -1;

        int i;
        for(i = 0; i < num; i++) {
            numList.add(Integer.parseInt(read.readLine()));
        }

        ArrayList<Integer> finalList = new ArrayList<>();
        
        int start = 0;
        while(true) {
            if(numList.size() == 0) break;
            
            if(numList.get(0) >= start) {
                for(i = start + 1; i <= numList.get(0); i++) {
                    top++;
                    stack[top] = i;

                    build.append("+\n");
                } 
                
                start = numList.get(0);
            }
             
            // 현재 top에 있는 값이 list에 넣어야 할 값보다 크면 더 이상 과정을 진행할 수 없음
            if(stack[top] > numList.get(0)) break;

            if(stack[top] == numList.get(0)) {  // 현재 top에 있는 숫자가 넣어야 할 값인 경우
                finalList.add(stack[top]);
                
                top--;
                numList.remove(0);

                build.append("-\n");
            }
        }

        if(numList.size() == 0) {
            System.out.println(build);
        } else {
            System.out.println("NO");
        }
    }
}
