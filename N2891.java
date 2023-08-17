package BOJ;

/*
2890번을 보면 알겠지만, 상근이는 카약 대회를 개최했다. 
그런데, 갑자기 엄청난 강풍이 경기장에 불었고, 일부 카약이 부서졌다. 
경기는 5분 안에 시작해야 하는 상황이다.

다행히 일부 팀은 혹시 모를 사태에 대비해서 카약을 하나 더 경기장에 들고 왔다. 
카약은 매우 무겁고 운반하기 어렵다. 
따라서, 자신의 바로 다음이나 전에 경기하는 팀에게만 카약을 빌려주려고 한다. 
즉, 팀 4는 여분의 카약을 3이나 5에게만 빌려줄 수 있다. 
다른 팀에게서 받은 카약은 또 다른 팀에게 빌려줄 수 없다. 
또, 카약을 하나 더 가져온 팀의 카약이 손상되었다면, 여분의 카약으로 경기에 출전하게되고, 이 카약은 다른 팀에게 빌려줄 수 없다.

카약이 부서진 팀과 하나 더 가져온 팀이 주어진다. 
카약을 적절히 빌렸을 때 출발하지 못하는 팀의 최솟값은 몇 팀인지 구하는 프로그램을 작성하시오.

첫째 줄에 팀의 수 N, 카약이 손상된 팀의 수 S, 카약을 하나 더 가져온 팀의 수 R이 주어진다. (2 ≤ N ≤ 10, 1 ≤ S, R ≤ N)
둘째 줄에는 카약이 손상된 팀의 번호가 주어진다.
팀 번호는 중복되지 않는다.
셋째 줄에는 카약을 하나 더 가져온 팀의 번호가 주어진다. 
팀 번호는 중복되지 않는다.

첫째 줄에 출발을 할 수 없는 팀의 최솟값을 출력한다.

5 2 1
2 4
3

1
 */

import java.io.*;
import java.util.StringTokenizer;

public class N2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int S = Integer.parseInt(stoi.nextToken());
        int R = Integer.parseInt(stoi.nextToken());

        // 손상된 경우 : -1, 일반 : 0, 여분이 있는 경우 : 1
        int[] kayak = new int[N + 1];
        
        StringTokenizer ship = new StringTokenizer(read.readLine());
        for(int i = 0; i < S; i++) {
            int repair = Integer.parseInt(ship.nextToken());
            kayak[repair] = -1;
        }

        StringTokenizer more = new StringTokenizer(read.readLine());
        for(int i = 0; i < R; i++) {
            int surplus = Integer.parseInt(more.nextToken());

            if(kayak[surplus] == -1) kayak[surplus] = 0;
            else kayak[surplus] = 1;
        }

        int result = 0;
        for(int i = 1; i <= N; i++) {
            if(kayak[i] == -1) {
                if(i - 1 > 0 && kayak[i - 1] == 1) {
                    kayak[i - 1] = 0;
                    continue;
                }
                if(i + 1 <= N && kayak[i + 1] == 1) {
                    kayak[i + 1] = 0;
                    continue;
                }

                result++;
            }
        }

        System.out.println(result);
    }
}