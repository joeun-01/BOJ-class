package BOJ;

/*
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

P1 IOI
P2 IOIOI
P3 IOIOIOI
PN IOIOI...OI (O가 N개)
I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

S에 PN이 몇 군데 포함되어 있는지 출력한다.

1
13
OOIOIOIOIIOII

4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 

public class N5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());  // O 개수
        int S = Integer.parseInt(read.readLine());  // 글자 수

        String str = read.readLine();
        char[] array = str.toCharArray();

        int i = 1, result = 0, count = 0;
        while(i < S - 1) {
            if(array[i - 1] == 'I' && array[i] == 'O' && array[i + 1] == 'I') {
                count++;

                if(count == N) {
                    count--;
                    result++;
                }
                
                i += 2;
            }
            else {
                count = 0;
                i++;
            }
        }

        System.out.println(result);
    }
}
