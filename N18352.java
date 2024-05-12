package BOJ;

import java.io.*;
import java.util.*;

public class N18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());
        int X = Integer.parseInt(stoi.nextToken());

        List<LinkedList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new LinkedList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            stoi = new StringTokenizer(read.readLine());
            int A = Integer.parseInt(stoi.nextToken());
            int B = Integer.parseInt(stoi.nextToken());

            list.get(A).add(B);
        }       

        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] depth = new int[N + 1];

        queue.add(X);
        isVisited[X] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for(int next : list.get(node)) {
                if(!isVisited[next]) {
                    queue.add(next);
                    depth[next] = depth[node] + 1;
                    isVisited[next] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(depth[i] == K) {
                build.append(i).append("\n");
            }
        }

        if(build.length() == 0) System.out.println(-1);
        else System.out.print(build);
    }
}