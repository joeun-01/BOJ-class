package BOJ;

/*
찬우는 스택을 배운 뒤 자료구조 과목과 사랑에 빠지고 말았다.

자료구조 과목만을 바라보기로 다짐한 찬우는 나머지 과목의 교과서 N권을 방 구석에 M개의 더미로 아무렇게나 쌓아 두었다. 
하지만 중간고사가 다가오자 더 이상 자료구조만 공부할 수는 없었고, 결국 찬우는 팽개쳤던 나머지 과목의 교과서를 정리하고 번호순으로 나열하려 한다.

N권의 교과서는 각각 1부터 N까지의 번호가 매겨져 있다. 
찬우는 각 더미의 맨 위에 있는 교과서만 꺼낼 수 있으며, 반드시 교과서를 꺼낸 순서대로 나열해야 하기 때문에 번호순으로 나열하기 위해서는 1번, 2번, … N - 1번, N번 교과서 순으로 꺼내야 한다. 
교과서를 올바르게 나열할 수 없다면 중간고사 공부를 때려치겠다는 찬우를 위해 번호순으로 나열할 수 있는지 여부를 알려주는 프로그램을 작성해 주자.

첫째 줄에 교과서의 수 N, 교과서 더미의 수 M이 주어진다.
둘째 줄부터 2 X M줄에 걸쳐 각 더미의 정보가 주어진다.

i번째 더미를 나타내는 첫 번째 줄에는 더미에 쌓인 교과서의 수 k_i가 주어지며, 두 번째 줄에는 k_i개의 정수가 공백으로 구분되어 주어진다.

각 정수는 교과서의 번호를 나타내며, 아래에 있는 교과서의 번호부터 주어진다.
교과서의 번호는 1부터 N까지의 정수가 한 번씩만 등장한다.

올바른 순서대로 교과서를 꺼낼 수 있다면 Yes를, 불가능하다면 No를 출력한다.

4 2
2
3 1
2
4 2

Yes
 */

import java.io.*;
import java.util.StringTokenizer;

public class N23253 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        boolean possible = true;
        for(int i = 0; i < M; i++) {
            int K = Integer.parseInt(read.readLine());
            stoi = new StringTokenizer(read.readLine());

            int previus = Integer.parseInt(stoi.nextToken());
            for(int j = 0; j < K - 1; j++) {
                int cur = Integer.parseInt(stoi.nextToken());
                
                if(cur > previus) possible = false;
                previus = cur;
            }
        }

        if(possible) System.out.println("Yes");
        else System.out.println("No");
    }
}