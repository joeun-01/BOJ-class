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

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N1874 {
    private static int top = -1;
    
    private static ArrayList<Integer> stack = new ArrayList<>();  // 스택
    private static ArrayList<Integer> list = new ArrayList<>();  // 후에 나열할 배열

    private static ArrayList<Integer> sorted;

    public static void main(String[] agrs) {
        Scanner input = new Scanner(System.in);

        long limit = input.nextInt();

        ArrayList<Integer> numList = new ArrayList<>();  // 받은 수열
        sorted = (ArrayList<Integer>) numList.clone();  // 받은 수열 오름차순 정렬

        int i;
        for(i = 0; i < limit; i++) {
            numList.add(input.nextInt());
        }

        Collections.sort(sorted);  // 오름차순으로 입력해야 하기 때문에 정렬
        
        while(true) {
            int j = 0;
            i = 0;
            while(true) {
                // 자기보다 작은 숫자들을 무조건 먼저 넣어주어야 함
                if(numList.get(i) >= sorted.get(j)) {
                    push(sorted.get(j), limit);
                    j++;
                } else break;
            }
    
            i = 0;
            while(true) {
                if(stack.get(top) == numList.get(i)) {
                    pop();
                } else break;
            }
    
            if(sorted.size() == 0) {
                if(stack.get(top) > numList.get(list.size() - 1)) System.out.println("NO");
            }
    
        }        
        

    }

    public static void push(int value, long limit) {
        if(!isFull(limit)) {
            top++;
            stack.add(top, value);
            
            sorted.remove(value);

            System.out.println("+ " + stack.get(0));
        } else System.out.println("Stack is full!");
    }

    public static void pop() {
        if(!isEmpty()) {
            list.add(stack.get(top));  // 제일 마지막에 넣은 애들 빼줌 (선입후출)
            top--; 

            System.out.println("- " + stack);
        } else System.out.println("Stack is empty!");
    }

    public static boolean isEmpty() {
        if(stack.size() == 0) return true;
        else return false;
    }

    public static boolean isFull(long limit) {
        if(stack.size() == limit - 1) return true;
        else return false;
    }
}
