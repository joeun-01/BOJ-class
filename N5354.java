package BOJ;

/*
아래 예제 출력과 같은 J박스를 출력하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수가 주어진다. 
각 테스트 케이스는 한 줄로 이루어져 있고, 박스의 크기가 주어진다. 
박스의 크기는 10보다 작거나 같다.

각 테스트 케이스에 대해서, 입력으로 주어지는 크기의 J박스를 출력한다. 
박스와 박스 사이에는 빈 줄을 하나 출력한다.

3
3
5
4

###
#J#
###

#####
#JJJ#
#JJJ#
#JJJ#
#####

####
#JJ#
#JJ#
####
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N5354 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        for(int i = 0; i < N; i++) {
            int box = Integer.parseInt(read.readLine());

            for(int r = 0; r < box; r++) {
                for(int c = 0; c < box; c++) {
                    if(r == 0 || r == box - 1) build.append("#");
                    else {
                        if(c == 0 || c == box - 1) build.append("#");
                        else build.append("J");
                    }
                }

                build.append("\n");
            }
            
            build.append("\n");
        }

        System.out.println(build);
    }
}