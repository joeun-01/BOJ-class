package BOJ;

/*
N개의 도시가 있다. 
그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다. 
우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다. 
A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 
도시의 번호는 1부터 N까지이다.

첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다. 
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 
버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 
출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

4
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException; 

public class N1916 {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        int E = Integer.parseInt(read.readLine());

        ArrayList<ArrayList<Node>> street = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            street.add(new ArrayList<Node>());
        }

        for(int i = 0; i < E; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int u = Integer.parseInt(stoi.nextToken());
            int v = Integer.parseInt(stoi.nextToken());
            int w = Integer.parseInt(stoi.nextToken());

            street.get(u).add(new Node(v, w));
        }

        StringTokenizer result = new StringTokenizer(read.readLine());
        int start = Integer.parseInt(result.nextToken());
        int end = Integer.parseInt(result.nextToken());

        // 다익스트라 알고리즘
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        boolean[] visited = new boolean[N + 1];
        int[] cost = new int[N + 1];

        int INF = Integer.MAX_VALUE;
        Arrays.fill(cost, INF);

        queue.add(new Node(start, 0));
        cost[start] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(visited[node.v]) continue;
            visited[node.v] = true;

            for(Node next : street.get(node.v)) {
                if(cost[next.v] > cost[node.v] + next.w) {
                    cost[next.v] = cost[node.v] + next.w;
                    queue.add(new Node(next.v, cost[next.v]));
                }
            }
        }

        System.out.println(cost[end]);
    }
}