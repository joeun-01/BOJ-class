package BOJ;

/*
한슬이는 5와 8이 행운의 수라고 생각한다. 
그래서 한슬이는 각 자리가 5와 8로만 이뤄져 있는 수를 행운의 수라고 한다.

정수 수열 A, B, C가 주어졌을 때 세 수열에서 각각 하나의 정수를 골라서 만들 수 있는 서로 다른 행운의 수의 개수를 구해보자.

예를 들어 A = [1, 10, 100], B = [3, 53], C = [4, 54]라고 한다면, 행운의 수를 만드는 방법은 8 = 1 + 3 + 4, 58 = 1 + 3 + 54, 58 = 1 + 53 + 4와 같이 총 3가지가 있다. 
58은 2가지 방법으로 만들 수 있으니, 서로 다른 행운의 수의 개수는 8과 58, 총 2개이다.

첫째 줄에 테스트 케이스의 수가 주어진다.
각 테스트 케이스의 첫째 줄에 A의 크기 N이 주어지고, 둘째 줄에 수열 A의 원소가 주어진다. 
수열 A의 원소는 공백으로 구분되어 있다.
다음 셋째 줄에는 B의 크기 M, 넷째 줄에는 수열 B의 원소, 다섯째 줄에는 C의 크기 K, 여섯째 줄에는 C의 원소가 주어지며, 수열 A의 정보와 같은 형식으로 되어 있다.

수열의 크기는 50을 넘지 않는 양의 정수이고, 수열의 원소는 30,000보다 작거나 같은 양의 정수이다.

각각의 테스트 케이스마다 입력으로 주어진 수열을 이용해 만들 수 있는 서로 다른 행운의 수의 개수를 한 줄에 하나씩 출력한다.

2
6
100 1 10 100 1 1
7
3 53 53 53 53 53 53
6
4 54 4 54 4 54
1
47
1
500
1
33

2
0
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N9575 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());
        HashSet<Integer> set = new HashSet<>();

        while(T > 0) {
            int ANum = Integer.parseInt(read.readLine());
            int[] A = new int[ANum];
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            for(int i = 0; i < ANum; i++) {
                A[i] = Integer.parseInt(stoi.nextToken());
            }

            int BNum = Integer.parseInt(read.readLine());
            int[] B = new int[BNum];
            stoi = new StringTokenizer(read.readLine());
            for(int i = 0; i < BNum; i++) {
                B[i] = Integer.parseInt(stoi.nextToken());
            }

            int CNum = Integer.parseInt(read.readLine());
            int[] C = new int[CNum];
            stoi = new StringTokenizer(read.readLine());
            for(int i = 0; i < CNum; i++) {
                C[i] = Integer.parseInt(stoi.nextToken());
            }

            for(int i = 0; i < ANum; i++) {
                for(int j = 0; j < BNum; j++) {
                    for(int k = 0; k < CNum; k++) {
                        int sum = A[i] + B[j] + C[k];
                        
                        int divide = sum;
                        boolean possible = true;
                        while(divide > 0) {
                            int mod = divide % 10;
                            if(mod == 5 || mod == 8) {
                                divide /= 10;
                            } else {
                                possible = false;
                                break;
                            }
                        }

                        if(possible) set.add(sum);
                    }
                }
            }

            build.append(set.size()).append("\n");
            set.clear();
            T--;
        }

        System.out.println(build);
    }
}