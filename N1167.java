package BOJ;

/*
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 
트리의 지름을 구하는 프로그램을 작성하시오.

트리가 입력으로 주어진다. 
먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 
정점 번호는 1부터 V까지 매겨져 있다.

먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 
예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 
각 줄의 마지막에는 -1이 입력으로 주어진다. 
주어지는 거리는 모두 10,000 이하의 자연수이다.

첫째 줄에 트리의 지름을 출력한다.

5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1

11
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException; 

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class Node {
    int next;
    int dist;

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }
}

public class N1167 {
    static int N;
    static List<Node>[] graph;
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(read.readLine());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());

            int node = Integer.parseInt(stoi.nextToken());

            while(stoi.hasMoreTokens()) {
                int next = Integer.parseInt(stoi.nextToken());

                if(next == -1) break;

                graph[node].add(new Node(next, Integer.parseInt(stoi.nextToken())));
            }
        }

        // 첫 번째 정점을 구함
        int goal = DFS(1, "first");

        // 첫 번째 정점에서 가장 먼 정점까지의 거리를 구함
        System.out.println(DFS(goal, "second"));
    }

    public static int DFS(int start, String mode) {
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        int goal = 0;
        int max = Integer.MIN_VALUE;
        
        stack.push(start);
        visited[start] = true;
    
        while(!stack.isEmpty()) {
            int node = stack.pop();

            for(int i = 0; i < graph[node].size(); i++) {
                int next = graph[node].get(i).next;
                if(!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    
                    dist[next] = dist[node] + graph[node].get(i).dist;
                    
                    // 가장 먼 정점 & 거리를 구함
                    if(dist[next] >= max) {
                        max = dist[next];
                        goal = next;
                    }
                }
            }
        }

        if(mode.equals("first")) return goal;
        else return max;
    }
}
