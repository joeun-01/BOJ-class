package BOJ;

/*
수빈이는 동생과 숨바꼭질을 하고 있다. 
수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
수빈이는 걷거나 순간이동을 할 수 있다. 
만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. 
N과 K는 정수이다.

수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

5 17

4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class N1697 {
    static int length;
    static int second[][];
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        StringTokenizer input = new StringTokenizer(read.readLine());
        int me = Integer.parseInt(input.nextToken());
        int sister = Integer.parseInt(input.nextToken());

        if(me < sister) {
            length = Math.max(me, sister) * 2 + 1;

            second = new int[length][length];
    
            for(int i = Math.min(me, sister); i <= Math.max(me, sister); i++) {
                second[i][i + 1] = 1;
                second[i + 1][i] = 1;
    
                second[i][i * 2] = 1;
                second[i * 2][i] = 1;
    
                if(i != 0) {
                    second[i][i - 1] = 1;
                    second[i - 1][i] = 1;
                }
            }
    
            build.append(BFS(me, sister));
        } else {
            build.append(me - sister);
        }

        System.out.println(build);
    }

    public static int BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visit[] = new boolean[length]; 
        int depth[] = new int[length];

        queue.add(start);

        visit[start] = true;
        depth[start] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(node != 0 && !visit[node - 1]) {
                queue.add(node - 1);

                visit[node - 1] = true;
                depth[node - 1] = depth[node] + 1;
            }

            if(!visit[node + 1]) {
                queue.add(node + 1);

                visit[node + 1] = true;
                depth[node + 1] = depth[node] + 1;
            }
            
            if(!visit[node * 2]) {
                queue.add(node * 2);

                visit[node * 2] = true;
                depth[node * 2] = depth[node] + 1;
            }
        }

        return depth[end];
    }
}
