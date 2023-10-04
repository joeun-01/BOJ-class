package BOJ;

/*
어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)
입력의 마지막엔 -1이 주어진다.

테스트케이스 마다 한줄에 하나씩 출력해야 한다.
n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).
이때, 약수들은 오름차순으로 나열해야 한다.
n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.

6
12
28
-1

6 = 1 + 2 + 3
12 is NOT perfect.
28 = 1 + 2 + 4 + 7 + 14
 */

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class N9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(read.readLine());

            if(N == -1) break;

            int sum = 0;
            boolean possible = true;
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 1; i < (N / 2 + 1); i++) {
                if(N % i == 0) {
                    if(!set.contains(i)) {
                        sum += i;
                        set.add(i);
                    }
                    
                    if(i == 1) continue;

                    if(!set.contains(N / i)) {
                        sum += (N / i);
                        set.add(N / i);
                    }

                    if(N < sum) {
                        possible = false;
                        break;
                    }
                }
            }

            if(sum < N) possible = false;

            if(possible) {
                build.append(N + " = ");
                Iterator<Integer> iter = set.iterator();

                while(iter.hasNext()) {
                    if(iter.hasNext()) build.append(iter.next() + " + ");
                    else build.append(iter.next());
                }

                build.delete(build.length() - 3, build.length());
            } else {
                build.append(N + " is NOT perfect.");
            }

            build.append("\n");
            set.clear();
        }

        System.out.println(build);
    }
}
