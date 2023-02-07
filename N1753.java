package BOJ;

/*
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 
단, 모든 간선의 가중치는 10 이하의 자연수이다.

첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 
모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 
셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. 
u와 v는 서로 다르며 w는 10 이하의 자연수이다. 
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 
시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

0
2
3
7
INF
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1753 {
    static class Node implements Comparable<Node> {
        int next;
        int dist;

        Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return this.dist - n.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        // 정점과 간선의 개수
        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(stoi.nextToken());
        int e = Integer.parseInt(stoi.nextToken());

        // 시작 노드
        int start = Integer.parseInt(read.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 간선의 정보
        for(int i = 0; i < e; i++) {
            stoi = new StringTokenizer(read.readLine());

            int u = Integer.parseInt(stoi.nextToken());
            int v = Integer.parseInt(stoi.nextToken());
            int w = Integer.parseInt(stoi.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        // dijkstra 알고리즘
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(cost, 3000000);

        queue.add(new Node(start, 0));
        cost[start] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(visited[node.next]) continue;
            visited[node.next] = true;

            for(Node next : graph.get(node.next)) {
                if(cost[next.next] > cost[node.next] + next.dist) {
                    cost[next.next] = cost[node.next] + next.dist;
                    queue.add(new Node(next.next, cost[next.next]));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(cost[i] >= 3000000) {
                build.append("INF \n");
            } else {
                build.append(cost[i] + "\n");   
            }
        }

        System.out.println(build);
    }
}
