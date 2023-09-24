package BOJ;

/*
상근이는 마라톤 학원을 운영하고 있다. 
학원의 수강생은 총 K명으로, 다가오는 마라톤 대회에 참가하기 위해 연습을 하고 있다.

마라톤 대회가 끝나고, 기록이 6시간 이하인 경우는 마라톤 완주 인증서를 받게 된다. 
상근이는 인증서를 받은 수강생 중에 가장 기록이 좋은 사람에게 특별상을 주려고 한다.

마라톤 대회의 결과가 주어졌을 때, 인증서를 받는 수강생의 수와 특별상을 받은 수강생을 구하는 프로그램을 작성하시오.

첫째 줄에 테스트 케이스의 개수 T ≤ 10가 주어진다.

각 테스트 케이스의 첫째 줄에는 수강생의 수 K가 주어진다. (1 < K ≤ 100) 
둘째 줄에는 수강생의 참가 번호가 공백으로 구분되어져서 주어진다. 
참가 번호는 백만을 넘지 않는 양의 정수이며, 겹치지 않는다. 
셋째 줄에는 대회의 참가자 수 N이 주어진다. (K < N ≤ 1 000) 
다음 N개 줄에는 각 참가자의 마라톤 결과를 나타내는 세 정수가 주어진다. 
첫 번째 정수는 참가 번호이고, 두 번째 정수와 세 번째 정수는 그 사람의 기록(시와 분)이다. 
분은 59보다 작거나 같은 음이 아닌 정수이고, 시는 23보다 작거나 같은 음이 아닌 정수이다. 
참가자가 대회를 중간에 포기한 경우에는 시와 분이 -1으로 주어진다.

항상 대회 인증서를 받은 수강생이 존재한다.

각 테스트 케이스마다 가장 기록이 좋은 수강생의 번호와 인증서를 받은 수강생의 수를 출력한다.
가장 기록이 좋은 수강생이 여러명인 경우에는 입력으로 먼저 들어오는 것을 출력한다.

2
4
123 456 999 73
6
111 5 3
456 -1 -1
123 4 59
73 6 0
520 -1 -1
999 6 0
5
3 5 2 7 1
10
5 8 3
4 6 20
9 4 10
10 5 20
1 6 1
2 4 20
3 4 20
6 4 20
7 4 15
8 4 10

123 3
7 3
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N9339 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(read.readLine());
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(read.readLine());  // 수강생 수

            HashMap<Integer, String> studentMap = new HashMap<>();
            StringTokenizer student = new StringTokenizer(read.readLine());
            for(int j = 0; j < K; j++) {
                studentMap.put(Integer.parseInt(student.nextToken()), "");
            }

            int N = Integer.parseInt(read.readLine());  // 참가자 수

            int total = 0, great = 0;
            for(int j = 0; j < N; j++) {
                StringTokenizer attend = new StringTokenizer(read.readLine());
                int num = Integer.parseInt(attend.nextToken());
                int hour = Integer.parseInt(attend.nextToken());
                int minute = Integer.parseInt(attend.nextToken());

                if(hour == -1 && minute == -1) continue;

                if(studentMap.containsKey(num)) {
                    String nowRecord = String.format("%02d", hour) + ":" + String.format("%02d", minute);
                    studentMap.put(num, nowRecord);

                    if(hour < 6 || (hour == 6 && minute == 0)) {
                        total++;

                        String greatRecord = studentMap.getOrDefault(great, "06:01");
                        if(nowRecord.compareTo(greatRecord) < 0) {
                            great = num;
                        }
                    }
                }
            }

            System.out.println(great + " " + total);
        }
    }
}
