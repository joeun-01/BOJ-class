package BOJ;

/*
 * 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
 * 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 
 * 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
 * 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 * M개의 수에 대한 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class N1920 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int n = input.nextInt();
            ArrayList<Integer> nList = new ArrayList<>();
    
            int i;
            for(i = 0; i < n; i++) {
                nList.add(input.nextInt());
            }
    
            Collections.sort(nList);
    
            int m = input.nextInt();
            int[] mList = new int[m]; 
    
            for(i = 0; i < m; i++) {
                mList[i] = input.nextInt();
            }
    
            for(i = 0; i < m; i++) {
                if(check(nList, mList[i], n - 1, 0)) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        } finally {
            input.close();
        }

    }

    public static boolean check(ArrayList<Integer> nList, int m, int high, int low) {
        while(low <= high) {
            int mid = (high + low) / 2;

            if(nList.get(mid) == m) {
                return true;
            }

            // System.out.println(nList.get(mid) );

            if(nList.get(mid) < m) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
