package BOJ;

/*
어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.

첫째 줄에 반에 있는 학생의 수 n이 주어진다. (1 ≤ n ≤ 100)
다음 n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 
이름은 그 학생의 이름이며, 최대 15글자로 이루어져 있다. 
dd mm yyyy는 생일 일, 월, 연도이다. (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1 ≤ dd ≤ 31) 
주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.
이름이 같거나, 생일이 같은 사람은 없다.

첫째 줄에 가장 나이가 적은 사람의 이름, 둘째 줄에 가장 나이가 많은 사람 이름을 출력한다.

5
Mickey 1 10 1991
Alice 30 12 1990
Tom 15 8 1993
Jerry 18 9 1990
Garfield 20 9 1990

Tom
Jerry
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(read.readLine());
        TreeSet<String> birth = new TreeSet<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            String name = stoi.nextToken();
            int day = Integer.parseInt(stoi.nextToken());
            int month = Integer.parseInt(stoi.nextToken());
            int year = Integer.parseInt(stoi.nextToken());

            String birthday = year + String.format("%02d", month) + String.format("%02d", day);
            birth.add(birthday + "," + name);
        }

        // System.out.println(birth);

        StringTokenizer first = new StringTokenizer(birth.pollLast(), ",");
        first.nextToken();
        System.out.println(first.nextToken());

        StringTokenizer second = new StringTokenizer(birth.pollFirst(), ",");
        second.nextToken();
        System.out.println(second.nextToken());
    }
}