package BOJ;

/*
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 
 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 
 * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 
 * 수는 중복되지 않는다.
 * 
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 * 
 * 5 5 4 3 2 1
 * 1 2 3 4 5
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N2751 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            ArrayList<Integer> num = new ArrayList<>();

            int n = input.nextInt();
    
            int i;
            for(i = 0; i < n; i++) {
                num.add(input.nextInt());
            }
    
            Collections.sort(num);
    
            StringBuilder builder = new StringBuilder();
            
            for (i = 0; i < n; i++) {
                builder.append(num.get(i) + "\n");
            }
    
            System.out.println(builder);
        } finally {
            input.close();
        }
    }
}
