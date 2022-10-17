package BOJ;

import java.util.Scanner;

public class N1654 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int k = input.nextInt();
            long n = input.nextInt();
    
            int[] list = new int[k];
    
            int i, max = 0;
            for(i = 0; i < k; i++) {
                list[i] = input.nextInt();
                max = Math.max(max, list[i]);  
            }
    
            /*
             * 최대 길이는 제일 긴 랜선 값으로
             * 랜선 평균 길이로 하면 안되는 이유 : 제일 긴 랜선으로 모든 걸 해결할 수도 있음
             * - 답이 평균 길이보다 클 수도 있다는 뜻
             */
    
            long high = max, low = 1;
            long length = 0;
    
            /*
             * 종료 조건은 low가 high를 넘지 않을 때까지
             * 이러면 무한반복 안걸리나 ??
             * 왜 안걸리지?
             */
    
            while(low <= high) {
                long mid = (high + low) / 2;  // 중간값 구하기
    
                int num = 0;
                for(i = 0; i < list.length; i++) {
                    // 중간값으로 랜선을 잘라서 길이가 되는지 확인
                    num += list[i] / mid;  
                }
    
                System.out.println(high + " " + low + " " + mid);
    
                if(num < n) {
                    high = mid - 1;
                } else {
                    if(mid > length) length = mid;
                    low = mid + 1;
                }
            }
    
            System.out.println(length);
        } finally {
            input.close();
        }
    }
}
