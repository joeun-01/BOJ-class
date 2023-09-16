package BOJ;

/*
N개의 정수가 주어진다. 
이때, N개의 정수를 오름차순으로 정렬하는 프로그램을 작성하시오. 
같은 정수는 한 번만 출력한다.

첫째 줄에 수의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째에는 숫자가 주어진다. 
이 수는 절댓값이 1,000보다 작거나 같은 정수이다.

첫째 줄에 수를 오름차순으로 정렬한 결과를 출력한다. 
이때, 같은 수는 한 번만 출력한다.

10
1 4 2 3 1 4 2 3 1 2

1 2 3 4
 */

import java.io.*;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(stoi.nextToken());
            set.add(num);
        }

        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}