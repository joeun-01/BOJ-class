package BOJ;

/*
몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 
집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.

첫째 줄에는 집합 A의 원소의 개수 n(A)와 집합 B의 원소의 개수 n(B)가 빈 칸을 사이에 두고 주어진다. 
(1 ≤ n(A), n(B) ≤ 500,000)이 주어진다. 
둘째 줄에는 집합 A의 원소가, 셋째 줄에는 집합 B의 원소가 빈 칸을 사이에 두고 주어진다. 
하나의 집합의 원소는 2,147,483,647 이하의 자연수이며, 하나의 집합에 속하는 모든 원소의 값은 다르다.

첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 
다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 
집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.

4 3
2 5 11 7
9 7 4

3
2 5 11
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int As = Integer.parseInt(stoi.nextToken());
        int Bs = Integer.parseInt(stoi.nextToken());

        HashSet<String> setA = new HashSet<>();
        stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < As; i++) {
            setA.add(stoi.nextToken());
        }

        HashSet<String> setB = new HashSet<>();
        stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < Bs; i++) {
            setB.add(stoi.nextToken());
        }

        int cnt = 0;
        TreeSet<Integer> tree = new TreeSet<>();
        for(String num : setA) {
            if(!setB.contains(num)) {
                cnt++;
                tree.add(Integer.parseInt(num));
            }
        }

        if(cnt == 0) {
            System.out.println(cnt);
        } else {
            System.out.println(cnt);

            for(int num : tree) {
                build.append(num).append(" ");
            }
            System.out.println(build);
        }
    }   
}