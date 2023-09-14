package BOJ;

/*
백준이는 작년 전국 대학생 프로그래밍 대회 동아리 연합(이하 전대프연) 회의에 불참했기 때문에, 올해 회장으로 선출되었다.

전대프연 회장은 오프라인 대회를 가을에 1회 개최해야 한다. 
백준이는 대회를 개최할 주말을 마음대로 고를 수 있고, 회원들이 머무를 호텔을 찾아야 한다. 
전대프연의 자금 사정은 넉넉하지 않기 때문에, 되도록 싼 호텔을 찾아야 한다.

여행의 총 비용은 예산을 초과하면 안 된다. 
모든 회원은 같은 호텔에서 머물러야 한다. 
작년에 모든 회원이 같은 호텔에 머무르지 않았고, 이로인해 대재앙이 일어났다. 
일부 회원은 길을 잃어버렸고, 아직까지 그들을 다시 본 사람은 없다. 

첫째 줄에 참가자의 수 1 ≤ N ≤ 200, 예산 1 ≤ B ≤ 500000, 호텔의 수 1 ≤ H ≤ 18, 고를 수 있는 주의 개수 1 ≤ W ≤ 13이 주어진다. 
다음 줄부터 각 호텔의 정보가 주어지며, 호텔의 정보는 두 줄로 이루어져 있다. 
첫 번째 줄에는 그 호텔의 일인당 숙박비용 1 ≤ p ≤ 10000이 주어지고, 둘째 줄에는 i번째 주에 투숙 가능한 인원 0 ≤ a ≤ 1000이 주어진다.

첫째 줄에 대회를 개최할 수 있으면 최소 비용을 출력하고, 없으면 "stay home"을 출력한다.

3 1000 2 3
200
0 2 2
300
27 3 20

900
 */

import java.io.*;
import java.util.StringTokenizer;

public class N5046 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());  // 참가 인원
        int B = Integer.parseInt(stoi.nextToken());  // 예산
        int H = Integer.parseInt(stoi.nextToken());  // 호텔 수
        int W = Integer.parseInt(stoi.nextToken());  // 주의 개수

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < H; i++) {
            int cost = Integer.parseInt(read.readLine()); // 인당 숙박 비용

            StringTokenizer area = new StringTokenizer(read.readLine());
            for(int j = 0; j < W; j++) {
                int people = Integer.parseInt(area.nextToken());
                
                if(N <= people) {
                    if(N * cost <= B) {
                        min = Math.min(min, N * cost);
                    }
                }
            }
        }

        if(min != Integer.MAX_VALUE) System.out.println(min);
        else System.out.println("stay home");
    } 
}  
