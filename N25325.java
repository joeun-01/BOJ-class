package BOJ;

/*
학생 이름이 공백으로 구분된 문자열 A가 주어진다. 
문자열 A에는 중복된 학생 이름이 존재하지 않는다. 
학생 이름은 알파벳 소문자로 이루어져 있다. 
각 학생이 좋아하는 학생의 학생 이름 목록이 공백으로 구분된 문자열로 주어진다. 
각 학생이 좋아하는 학생은 1명 이상 주어지고, 내가 나를 좋아하는 예는 없다. 
나를 좋아하는 학생이 많을수록 나의 인기도가 높다. 
인기도가 높은 학생부터 낮은 학생 순으로 학생 이름과 해당 학생을 좋아하는 학생 수를 출력하자. 
인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력하자.

첫 번째 줄에 학생 수 n이 주어진다.
두 번째 줄에 n명의 학생 이름이 공백으로 구분된 문자열 A가 주어진다.
다음 줄부터 n개의 줄에 걸쳐 한 줄에 한 학생의 정보가 주어진다. 
학생 정보는 문자열 A에 나온 학생 순서대로 주어진다. 
한 명의 학생 정보는 해당 학생이 좋아하는 학생 이름이 공백으로 구분된 문자열로 주어진다.

첫 번째 줄부터 n번째 줄까지 학생 이름과 해당 학생을 좋아하는 학생 수를 공백으로 구분하여 한 줄에 출력한다. 
인기도가 높은 학생부터 낮은 학생 순으로 출력하고, 인기도가 같은 경우 학생 이름 기준으로 오름차순으로 출력한다.

4
aaa bbb ccc ddd
bbb ddd
aaa ddd
aaa
aaa bbb

aaa 3
bbb 2
ddd 2
ccc 0
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        String[] name = new String[N];
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        for(int i = 0; i < N; i++) {
            String student = stoi.nextToken();
            map.put(student, 0);
            name[i] = student;
        }

        for(int i = 0; i < N; i++) {
            stoi = new StringTokenizer(read.readLine());
            while(stoi.hasMoreTokens()) {
                String student = stoi.nextToken();
                map.put(student, map.getOrDefault(student, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for (String key : keySet) {
            System.out.println(key + " " +map.get(key));
        }
    }
}