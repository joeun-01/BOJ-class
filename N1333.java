package BOJ;

/*
얼마전, Day Of Mourning의 새 앨범이 나왔고, 강토는 이 앨범을 들으려고 한다.

이 앨범에는 총 노래가 N곡이 들어있고, 모든 노래의 길이는 L초이다. 
그리고, 노래와 노래 사이에는 5초 동안 아무 노래도 들리지 않는 조용한 구간이 있다.

강토가 앨범의 첫 곡을 듣는 순간이 0초이다. 
그리고 그 0초부터 강토의 전화벨이 울리기 시작한다. 
전화벨은 D초에 1번씩 울리며, 한 번 울릴 때 1초동안 울린다.

강토는 락 스피릿을 진심으로 느끼기 위해서 볼륨을 매우 크게 하고 듣기 때문에, 노래가 나오는 중에는 전화벨 소리를 듣지 못한다.

만약, 전화벨이 노래가 시작되는 순간 울린다면, 강토는 전화를 받지 못한다. 
또, 전화벨이 노래가 끝나는 순간 같이 끝난다면, 강토는 전화를 받을 수 없다.

강토는 앨범을 1번만 듣는다. 
즉, 모든 앨범 수록곡을 다 듣고 난 후에는 전화벨을 들을 수 있다.

강토가 전화벨을 들을 수 있는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

첫째 줄에 세 정수 N, L, D가 공백을 사이에 두고 주어진다.

첫째 줄에 강토가 전화벨을 들을 수 있는 가장 빠른 시간을 출력한다.

1 ≤ N ≤ 20
1 ≤ L ≤ 180
1 ≤ D ≤ 20

2 5 7

7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());  // 노래 개수
        int L = Integer.parseInt(stoi.nextToken());  // 노래 길이
        int D = Integer.parseInt(stoi.nextToken());  // 전화벨 주기

        int time = D;
        while(true) {
            if(time > N * (L + 5) - 1) {
                System.out.println(time);
                break;
            }

            if(time % (L + 5) >= L && time % (L + 5) <= L + 4) {
                System.out.println(time);
                break;
            }

            time += D;
        }
    }
}
