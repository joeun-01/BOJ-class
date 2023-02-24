package BOJ;

/*
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)

첫째 줄부터 N번째 줄까지 별을 출력한다.

24

                       *                        
                      * *                       
                     *****                      
                    *     *                     
                   * *   * *                    
                  ***** *****                   
                 *           *                  
                * *         * *                 
               *****       *****                
              *     *     *     *               
             * *   * *   * *   * *              
            ***** ***** ***** *****             
           *                       *            
          * *                     * *           
         *****                   *****          
        *     *                 *     *         
       * *   * *               * *   * *        
      ***** *****             ***** *****       
     *           *           *           *      
    * *         * *         * *         * *     
   *****       *****       *****       *****    
  *     *     *     *     *     *     *     *   
 * *   * *   * *   * *   * *   * *   * *   * *  
***** ***** ***** ***** ***** ***** ***** *****
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        int total = 2 * N - 1;
        int middle = N;

        // System.out.println(total + " " + middle);

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= total; j++) {
                // 경계선 구분
                if(j >= middle - i + 1 && j <= middle + i - 1) {
                    if(i % 3 == 0) {
                        if(i != 3 && j % 6 == 0) build.append(" ");
                        else build.append("*");
                    } else build.append("*");
                } else build.append(" ");
            }

            build.append("\n");
        }

        System.out.println(build);
    }
}
