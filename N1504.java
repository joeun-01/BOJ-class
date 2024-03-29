package BOJ;

/*
방향성이 없는 그래프가 주어진다. 
세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 
또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 
하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 
1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 
둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 
다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1) 
임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.

첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 
그러한 경로가 없을 때에는 -1을 출력한다.

4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3

7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class N1504 {
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

    static int N;
    static int E;
    static int INF = 200000000;

    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        // 정점과 간선의 개수
        StringTokenizer input = new StringTokenizer(read.readLine());
        N = Integer.parseInt(input.nextToken());
        E = Integer.parseInt(input.nextToken());

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i = 0; i < E; i++) {
            StringTokenizer edge = new StringTokenizer(read.readLine());

            int start = Integer.parseInt(edge.nextToken());
            int end = Integer.parseInt(edge.nextToken());
            int weight = Integer.parseInt(edge.nextToken());

            // 양방향의 경우 양쪽 다 추가해주어야 함
            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        StringTokenizer mid = new StringTokenizer(read.readLine());
        int v1 = Integer.parseInt(mid.nextToken());
        int v2 = Integer.parseInt(mid.nextToken());  

        int first = find(v1, v2);
        int second = find(v2, v1);

        if(first >= INF && second >= INF) System.out.println(-1);
        else System.out.println(Math.min(first, second));
    }

    public static int[] dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(); 
        
        int[] cost = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(cost, INF);

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

        return cost;
    }

    public static int find(int first, int second) {
        /**
         * 1 -> v1 -> v2 -> 최종으로 가는 경우
         * 1 -> v2 -> v1 -> 최종으로 가는 경우
         */ 

        int total = 0;        

        int[] fistCost = dijkstra(1);   
        total += fistCost[first];

        int[] secondCost = dijkstra(first);
        total += secondCost[second];

        int[] thirdCost = dijkstra(second);
        total += thirdCost[N];

        return total;
    }
}
