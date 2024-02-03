package BOJ;

/*
여러 명의 학생이 식사하기 위하여 학교 식당을 향해 달려가고 있다. 학교 식당에 도착한 학생은 식당 입구에 줄을 서서 대기한다. 학교 식당에 먼저 도착한 학생이 나중에 도착한 학생보다 식당 입구의 앞쪽에서 대기한다. 식사는 1인분씩 준비된다. 식사 1인분이 준비되면 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식당으로 들어가서 식사를 시작한다. 식사를 시작한 학생은 항상 식사를 마친다.

학교 식당에서는 두 가지 메뉴가 제공되고 각각의 학생은 두 가지 메뉴 중에서 본인이 좋아하는 메뉴를 결정한 상태다. 학생이 학교 식당에 도착하고 식사가 준비되는 n개의 정보가 저장된 S가 주어진다. S에 저장된 첫 번째 정보부터 n번째 정보까지 순서대로 처리한 경우, 본인이 좋아하는 메뉴를 먹은 학생 목록 A와 본인이 좋아하지 않는 메뉴를 먹은 학생 목록 B와 학교 식당에 도착하였으나 식사를 하지 못한 학생 목록 C를 출력하자.

S에 저장된 n개의 식당 정보는 아래 두 가지 유형으로 구분된다. 첫 번째가 유형 1, 두 번째가 유형 2다.

1 a b: 학생 번호가 양의 정수 a이고 좋아하는 메뉴 번호가 양의 정수 b인 학생 1명이 학교 식당에 도착하여 식당 입구의 맨 뒤에 줄을 서기 시작한다.
2 b: 메뉴 번호가 양의 정수 b인 식사 1인분이 준비되어 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식사를 시작한다.

식사 1인분이 준비될 때는 식당 입구에서 대기 중인 학생이 항상 존재한다. 식당 입구에 줄을 서서 대기하였으나 식사가 준비 안 된 학생은 식사를 못 한다.

첫 번째 줄에 n이 주어진다.
두 번째 줄부터 n개의 줄에 걸쳐 한 줄에 하나의 정보가 주어진다. 각 정보는 유형 1, 2중 하나이다.

첫 번째 줄에 학생 목록 A에 있는 학생 번호를 빈칸을 사이에 두고 오름차순으로 출력한다.
두 번째 줄에 학생 목록 B에 있는 학생 번호를 빈칸을 사이에 두고 오름차순으로 출력한다.
세 번째 줄에 학생 목록 C에 있는 학생 번호를 빈칸을 사이에 두고 오름차순으로 출력한다.
학생 목록에 학생이 없는 경우 학생 번호 대신 None을 출력한다.

1 ≤ n ≤ 500,000
S에는 유형 1, 유형 2만 저장되어 있다.
1 ≤ a ≤ n, 모든 양의 정수 a의 값은 서로 다르다.
b는 1 또는 2이다.

6
1 2 1
1 1 1
2 1
1 3 2
2 2
2 2

2 3
1
None
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N26043 {
    public static class Info {
        int menu;
        int num;

        public Info(int menu, int num) {
            this.menu = menu;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());
        
        Queue<Info> queue = new LinkedList<>();
        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();
        TreeSet<Integer> C = new TreeSet<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int option = Integer.parseInt(stoi.nextToken());

            if(option == 1) {
                int menu = Integer.parseInt(stoi.nextToken());
                int num = Integer.parseInt(stoi.nextToken());
                queue.add(new Info(num, menu));
            } else if(option == 2) {
                Info front = queue.poll();
                int menuNow = Integer.parseInt(stoi.nextToken());

                if(front.menu == menuNow) A.add(front.num);
                else B.add(front.num);
            }
        }

        while(!queue.isEmpty()) {
            C.add(queue.poll().num);
        }

        int ASize = A.size();
        int BSize = B.size();
        int CSize = C.size();

        if(ASize == 0) build.append("None\n");
        else {
            for(int num : A) {
                build.append(num).append(" ");
            }
            build.append("\n");
        }

        if(BSize == 0) build.append("None\n");
        else {
            for(int num : B) {
                build.append(num).append(" ");
            }
            build.append("\n");
        }

        if(CSize == 0) build.append("None\n");
        else {
            for(int num : C) {
                build.append(num).append(" ");
            }
            build.append("\n");
        }

        System.out.println(build);
    }
}