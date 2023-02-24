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
import java.util.Arrays;
import java.io.IOException;

public class N2448 {
    static char[][] star;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        N = Integer.parseInt(read.readLine());

        int total = 2 * N - 1;
        int middle = N;

        // System.out.println(total + " " + middle);

        star = new char[N] [total];
        for (char[] i : star) Arrays.fill(i, ' ');

        print(0, middle - 1, N);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < total; j++) {
                build.append(star[i][j]);
            }
            build.append("\n");
        }

        System.out.println(build);
    }

    public static void print(int row, int middle, int N) {
        if(N == 3) {        
            // 1번째 줄
            star[row][middle] = '*';
            // 2번째 줄
            star[row + 1][middle - 1] = '*';
            star[row + 1][middle + 1] = '*';
            // 3번째 줄
            for(int i = middle - 2; i <= middle + 2; i++) {
                star[row + 2][i] = '*';
            }

            return;
        }

        N = N / 2;
        print(row, middle, N);
        print(row + N, middle - N, N);
        print(row + N, middle + N, N);
    }
}
