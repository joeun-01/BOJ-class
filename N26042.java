package BOJ;

/*
여러 명의 학생이 식사하기 위하여 학교 식당을 향해 달려가고 있다. 
학교 식당에 도착한 학생은 식당 입구에 줄을 서서 대기한다. 
학교 식당에 먼저 도착한 학생이 나중에 도착한 학생보다 식당 입구의 앞쪽에서 대기한다. 
식사는 1인분씩 준비된다. 
식사 1인분이 준비되면 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식당으로 들어가서 식사를 시작한다. 
식사를 시작한 학생은 항상 식사를 마친다.

학생이 학교 식당에 도착하고 식사가 준비되는 n개의 정보가 저장된 A가 주어진다. 
A에 저장된 첫 번째 정보부터 n번째 정보까지 순서대로 처리한 다음, 식당 입구에 줄을 서서 대기하는 학생 수가 최대가 되었던 순간의 학생 수와 이때 식당 입구의 맨 뒤에 대기 중인 학생의 번호를 출력하자. 
대기하는 학생 수가 최대인 경우가 여러 번이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력하자.

A에 저장된 n개의 정보는 아래 두 가지 유형으로 구분된다. 
첫 번째가 유형 1, 두 번째가 유형 2이다.

1 a: 학생 번호가 양의 정수 a인 학생 1명이 학교 식당에 도착하여 식당 입구의 맨 뒤에 줄을 서기 시작한다.
2: 식사 1인분이 준비되어 식당 입구의 맨 앞에서 대기 중인 학생 1명이 식사를 시작한다.
식사 1인분이 준비될 때는 식당 입구에서 대기 중인 학생이 항상 존재한다. 
식당 입구에 줄을 서서 대기하였으나 식사가 준비 안 된 학생은 식사를 못 한다.

첫 번째 줄에 n이 주어진다.
다음 줄부터 n개의 줄에 걸쳐 한 줄에 하나의 정보가 주어진다. 
주어지는 정보는 유형 1, 2중 하나이다.

첫 번째 정보부터 n번째 정보까지 순서대로 처리한 다음, 식당 입구에 줄을 서서 대기하는 학생 수가 최대가 되었던 순간의 학생 수와 이때 식당 입구의 맨 뒤에 대기 중인 학생의 번호를 빈칸을 사이에 두고 순서대로 출력한다. 
대기하는 학생 수가 최대인 경우가 여러 번이라면 맨 뒤에 줄 서 있는 학생의 번호가 가장 작은 경우를 출력한다.

1 ≤ n ≤ 100,000
A에는 유형 1, 유형 2만 저장되어 있다.
1 ≤ a ≤ n, 모든 양의 정수 a의 값은 서로 다르다.

5
1 2
1 1
2
1 3
2

2 1
 */

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N26042 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        Deque<Integer> queue = new LinkedList<>();
        int size = 0, behind = 1000000, maxSize = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int option = Integer.parseInt(stoi.nextToken());

            if(option == 1) {
                queue.addLast(Integer.parseInt(stoi.nextToken()));
                size++;
            } else if(option == 2) {
                queue.pollFirst();
                size--;
            }

            if(size == maxSize) {
                behind = Math.min(behind, queue.getLast());
            } else if(size > maxSize) {
                maxSize = size;
                behind = queue.getLast();
            }
        }

        System.out.println(maxSize + " " + behind);
    }
}