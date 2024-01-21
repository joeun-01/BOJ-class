package BOJ;

/*
김형택은 탑문고의 직원이다. 
김형택은 계산대에서 계산을 하는 직원이다. 
김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 
이 값은 1,000보다 작거나 같은 자연수이다. 
둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 
책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 
만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.

5
top
top
top
top
kimtop

top
 */

import java.io.*;
import java.util.TreeMap;

public class N1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        int max = 0;
        for(int i = 0; i < N; i++) {
            String book = read.readLine();
            int cnt = map.getOrDefault(book, 0) + 1;

            if(cnt > max) max = cnt;

            map.put(book, cnt);
        }

        for(String book : map.keySet()) {
            if(map.get(book) == max) {
                build.append(book);
                break;
            }
        }

        System.out.println(build);
    }
}