package BOJ;

/*
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.

첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
V부터 방문된 점을 순서대로 출력하면 된다.

4 5 1
1 2
1 3
1 4
2 4
3 4

1 2 4 3
1 2 3 4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Stack;

public class N1260 {
    static int[][] graph;  // 그래프 

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(read.readLine());

        int N = Integer.parseInt(input.nextToken());  // 노드 개수
        int M = Integer.parseInt(input.nextToken());  // 간선 개수
        int start = Integer.parseInt(input.nextToken());  // 시작 노드

        graph = new int[N + 1][N + 1];

        for(int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(read.readLine());

            int first = Integer.parseInt(line.nextToken());
            int second = Integer.parseInt(line.nextToken());

            // 양방향 연결이기 때문에 둘 다 1로 바꿔줌 = 연결이 되어있다는 뜻
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        DFS(N, start);
        BFS(N, start);
    }

    public static void DFS(int n, int start) {
        StringBuilder build = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[n + 1];

        visit[start] = true;
        stack.push(start);

        build.append(start + " ");

        while(!stack.isEmpty()) {
            int node = stack.peek();

            for(int i = 1; i < visit.length; i++) {
                if(!visit[i] && graph[node][i] == 1) {
                    visit[i] = true;
                    stack.push(i);

                    build.append(i + " ");
                    break;
                }

                if(i == visit.length - 1) stack.pop();
            }
        }

        System.out.println(build);
    }

    public static void BFS(int n, int start) {
        StringBuilder build = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();  // 큐
        boolean[] visit = new boolean[n + 1];  // 방문 체크 배열

        // 시작점 방문 표시 & 삽입
        visit[start] = true;
        queue.add(start);

        build.append(start + " ");

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int i = 1; i < visit.length; i++) {
                if(!visit[i] && graph[node][i] == 1) {
                    // 방문하지 않았고 연결된 노드일 경우 방문 표시 & 삽입
                    visit[i] = true;
                    queue.add(i);

                    build.append(i + " ");
                }
            }
        }

        System.out.println(build);
    }
}
