package BOJ;

/*
N개의 숫자로 구분된 각각의 마을에 한 명의 학생이 살고 있다.

어느 날 이 N명의 학생이 X (1 ≤ X ≤ N)번 마을에 모여서 파티를 벌이기로 했다. 
이 마을 사이에는 총 M개의 단방향 도로들이 있고 i번째 길을 지나는데 Ti(1 ≤ Ti ≤ 100)의 시간을 소비한다.

각각의 학생들은 파티에 참석하기 위해 걸어가서 다시 그들의 마을로 돌아와야 한다. 
하지만 이 학생들은 워낙 게을러서 최단 시간에 오고 가기를 원한다.

이 도로들은 단방향이기 때문에 아마 그들이 오고 가는 길이 다를지도 모른다. 
N명의 학생들 중 오고 가는데 가장 많은 시간을 소비하는 학생은 누구일지 구하여라.

첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000), X가 공백으로 구분되어 입력된다. 
두 번째 줄부터 M+1번째 줄까지 i번째 도로의 시작점, 끝점, 그리고 이 도로를 지나는데 필요한 소요시간 Ti가 들어온다. 
시작점과 끝점이 같은 도로는 없으며, 시작점과 한 도시 A에서 다른 도시 B로 가는 도로의 개수는 최대 1개이다.

모든 학생들은 집에서 X에 갈수 있고, X에서 집으로 돌아올 수 있는 데이터만 입력으로 주어진다.

첫 번째 줄에 N명의 학생들 중 오고 가는데 가장 오래 걸리는 학생의 소요시간을 출력한다.

4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

10
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.IOException; 

public class N1238 {
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
    static int X;

    static ArrayList<ArrayList<Node>> street = new ArrayList<>();
    static ArrayList<ArrayList<Node>> reverse = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수와 단방향 도로의 수, 마을의 위치
        StringTokenizer input = new StringTokenizer(read.readLine());
        N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());

        X = Integer.parseInt(input.nextToken());

        for(int i = 0; i <= N; i++) {
            street.add(new ArrayList<Node>());
            reverse.add(new ArrayList<Node>());
        }         

        // 거리 데이터 넣기
        for(int i = 0; i < M; i++) {
            StringTokenizer dist = new StringTokenizer(read.readLine());

            int start = Integer.parseInt(dist.nextToken());
            int end = Integer.parseInt(dist.nextToken());
            int cost = Integer.parseInt(dist.nextToken());

            street.get(start).add(new Node(end, cost));
            reverse.get(end).add(new Node(start, cost));
        }


        int[] fromX = dijkstra(street);

        for(int i = 0; i < fromX.length; i++) {
            System.out.println(fromX[i]);
        }
        int[] toX = dijkstra(reverse);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> list) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] cost = new int[N + 1];
        boolean[] visited = new boolean[N + 1]; 

        for(int i = 0; i <= N; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        queue.add(new Node(X, 0));
        cost[X] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(visited[node.next]) continue;
            visited[node.next] = true;

            for(Node next : list.get(node.next)) {                    
                cost[next.next] = Math.min(cost[next.next], cost[next.next] + next.dist);
                queue.add(next);
            }
        }

        return cost;
    }

}
