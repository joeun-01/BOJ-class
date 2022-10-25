package BOJ;

/*
 * 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 
 * 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 
 * 단, N은 홀수라고 가정하자.
 * 
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
 * 
 * 첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
 * 둘째 줄에는 중앙값을 출력한다.
 * 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
 * 넷째 줄에는 범위를 출력한다.
 * 
 * 5 1 3 8 -2 2
 * 
 * 2 2 1 10
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class N2108 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int n = input.nextInt();

            ArrayList<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> cnt = new HashMap<>();
    
            int i, sum = 0;
            for(i = 0; i < n; i++) {
                list.add(input.nextInt());
    
                if(cnt.containsKey(list.get(i))) {
                    cnt.replace(list.get(i), cnt.get(list.get(i)) + 1);
                } else {
                    cnt.put(list.get(i), 0);
                }
    
                sum += list.get(i);
            }
    
            // 산술평균 출력
            System.out.println((int) Math.round((double) sum / n));
        
            // 중앙값 출력
            Collections.sort(list);
            System.out.println(list.get(n / 2));
    
            // 최빈값 출력  
            int max = 0;
            ArrayList<Integer> maxList = new ArrayList<>();
            for(int key : cnt.keySet()) {
                if(cnt.get(key) > max) {
                    max = cnt.get(key);
    
                    maxList.clear();
                    maxList.add(key);
                } else if(cnt.get(key) == max) {
                    maxList.add(key);
                }
            }
    
            Collections.sort(maxList);
            if(maxList.size() == 1) System.out.println(maxList.get(0));
            else System.out.println(maxList.get(1));
    
            // 범위 출력
            System.out.println(list.get(n - 1) - list.get(0));
        } finally {
            input.close();
        }
    }
}
