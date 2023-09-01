package BOJ;

/*
버스 운전수 비와이 씨가 운전하는 버스(verse아님 ㅎ)는 N개의 정거장을 거친 후 종착역에 도착한다. 
각 정거장은 내릴 인원수와 올라탈 인원수가 정해져 있다. 
종착역에 도착하면 버스에 타고 있던 모든 사람이 내린다.

첫 줄에 출발역과 종착역을 제외한 정거장의 수 N(1 ≤ N ≤ 100,000)과 출발역에서 탑승하는 사람의 수 K(1 ≤ K ≤ 10,000)가 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 줄마다 i번째 정거장에서 탑승하는 인원 A와 하차하는 인원 B가 주어진다. (0 ≤ A, B ≤ 10,000)

종착역에 도착했을 때, 버스 운전수의 이름을 출력해라.

3 2
10 3
21 8
0 15

비와이
 */

import java.io.*;
import java.util.StringTokenizer;

public class N14645 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer busStop = new StringTokenizer(read.readLine());
            
            int A = Integer.parseInt(busStop.nextToken());
            int B = Integer.parseInt(busStop.nextToken());

            K = K + A - B;
        }

        System.out.println("비와이");
    }
}