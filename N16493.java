/*
철수는 한양대학교 도서관에서 책을 빌려놓고 까먹고 있다가 며칠 후 책을 반납해야 한다는 사실을 깨달았다. 
남은 기간 동안 최대한 많은 페이지를 읽고 연체없이 반납하고 싶다.

빌린 책은 여러 챕터로 구성된 에세이집인데 챕터들은 서로 독립적이다. 
즉, 어느 챕터를 읽기 위해 다른 챕터를 먼저 읽어야 할 필요가 없다. 
철수는 중간에 관두는 것을 못견디는 성격이라, 한 챕터를 읽기 시작하면 끝까지 봐야한다. 

남은 기간 N일과, 책의 각 챕터 당 그 챕터를 전부 읽는데 소요되는 일 수와 페이지 수가 주어질 때, N일간 읽을 수 있는 최대 페이지 수를 구하는 프로그램을 작성하라.

첫째 줄에 N(1 ≤ N ≤ 200)과 챕터의 수 M(1 ≤ M ≤ 20)이 주어진다. 
둘째 줄부터 각 챕터 당 읽는데 소요되는 일 수와 페이지 수가 주어진다. 
소요되는 일 수는 20보다 작거나 같은 자연수이고, 페이지 수는 300보다 작거나 같은 자연수이다.

읽을 수 있는 최대 페이지 수를 출력한다.

7 7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

260
 */

import java.io.*;
import java.util.*;

public class N16493 {
    public static class Chapter {
        int chapter;
        int day;
        int page;

        public Chapter(int chapter, int day, int page) {
            this.chapter = chapter;
            this.day = day;
            this.page = page;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        Chapter[] chapters = new Chapter[M];
        for(int i = 0; i < M; i++) {
            stoi = new StringTokenizer(read.readLine());

            int day = Integer.parseInt(stoi.nextToken());            
            int page = Integer.parseInt(stoi.nextToken());

            chapters[i] = new Chapter(i + 1, day, page);
        }

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int page = chapters[i - 1].page;
            int day = chapters[i - 1].day;

            for (int j = 0; j <= N; j++) {
                if (j < day) {  // 현재 챕터를 읽지 못하는 경우
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - day] + page);
                }
            }
        }

        System.out.println(dp[M][N]);
    }
}