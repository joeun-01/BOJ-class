package BOJ;

/*
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

첫째 줄에 연결 요소의 개수를 출력한다.

6 5
1 2
2 5
5 1
3 4
4 6

2
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.LinkedList;
import java.util.Queue;

public class N11724 {
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer data = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(data.nextToken());
        int M = Integer.parseInt(data.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer input = new StringTokenizer(read.readLine());

            int u = Integer.parseInt(input.nextToken());
            int v = Integer.parseInt(input.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                BFS(i);
                count++;
            }
        }

        System.out.print(count);

    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 1; i < visited.length; i++) {
                if(!visited[i] && graph[node][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
