package BOJ;

/*
 * 프린터 기기는 여러분이 인쇄하고자 하는 문서를 인쇄 명령을 받은 ‘순서대로’, 즉 먼저 요청된 것을 먼저 인쇄한다. 
 * 여러 개의 문서가 쌓인다면 Queue 자료구조에 쌓여서 FIFO - First In First Out - 에 따라 인쇄가 되게 된다. 
 * 하지만 상근이는 새로운 프린터기 내부 소프트웨어를 개발하였는데, 이 프린터기는 다음과 같은 조건에 따라 인쇄를 하게 된다.
 * 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
 * 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 
 * 그렇지 않다면 바로 인쇄를 한다.
 * 예를 들어 Queue에 4개의 문서(A B C D)가 있고, 중요도가 2 1 4 3 라면 C를 인쇄하고, 다음으로 D를 인쇄하고 A, B를 인쇄하게 된다.
 * 
 * 현재 Queue에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내는 것이다.
 * 예를 들어 위의 예에서 C문서는 1번째로, A문서는 3번째로 인쇄되게 된다.
 * 
 * 
 * 첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
 * 테스트케이스의 첫 번째 줄에는 문서의 개수 N(1 ≤ N ≤ 100)과, 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)이 주어진다. 
 * 이때 맨 왼쪽은 0번째라고 하자. 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다. 
 * 중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.
 * 
 * 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다. 
 * 
 * 입력 
 * 3  테스트 케이스
 * 1 0  문서 개수, 몇 번째에 있는지
 * 5 
 * 4 2
 * 1 2 3 4
 * 6 0
 * 1 1 9 1 1 1
 * 
 * 출력 
 * 1
 * 2
 * 5
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N1966 {
    // 도대체 어디에서 indexOutBound가 나오는 건지 도저히 .. 모르겠음 내가 풀 때는 다 잘 되는데 ;; 
    private static ArrayList<Integer> queue = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int test = input.nextInt();  // 테스트 케이스 개수
            int[] result = new int[test];
    
            int i;
            for(i = 0; i < test; i++) {
                int num = input.nextInt();  // 파일 개수
                int location = input.nextInt();  // 알고자 하는 파일 위치
    
                ArrayList<Integer> sort = new ArrayList<>();
    
                int j;
                for(j = 0; j < num; j++) {  // 각 서류의 중요도
                    sort.add(input.nextInt());
                    enqueue(sort.get(j));
                }
    
                Collections.sort(sort, Collections.reverseOrder());  // max를 맨 앞으로
    
                int cnt = 0;
    
                while(true) {
                    int remove = dequeue();  // front를 dequeue
    
                    if(remove != sort.get(0)) {  // max가 아니면 다시 넣어줌
                        enqueue(remove);
    
                        if(location == 0) {  // 지켜보는 애가 맨 앞이었던 경우
                            location = queue.size() - 1;  // location을 맨 뒤로
                        } else {
                            location--;  // 앞이 제거됐기 때문에 location - 1
                        }
                        
                    } else {  // max인 경우 정렬 리스트에서 제거 - 더 이상 필요없는 max 값
                        sort.remove(0);
                        cnt++;
    
                        if(location == 0) {  // 지켜보는 애가 맨 앞이었던 경우
                            if(location == 0) break;
                        } else {
                            location--;  // 앞이 제거됐기 때문에 location - 1
                        }
                    }
    
                    // System.out.println(queue);
                }
    
                result[i] = cnt;
            }
    
            for(i = 0; i < test; i++) {
                System.out.println(result[i]);
            }
        } finally {
            input.close();
        }

    }

    public static void enqueue(int value) {
        queue.add(value);

        // System.out.println("Enqueue : " + queue.get(queue.size() - 1));
    }

    public static int dequeue() {
        int value = queue.get(0);
        queue.remove(0);
            
        // System.out.println("Dequeue : " + value);
        return value;
    }
}