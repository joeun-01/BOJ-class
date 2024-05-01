package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N28014 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        StringTokenizer stoi = new StringTokenizer(read.readLine());

        int[] height = new int[N];
        for(int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(stoi.nextToken());
        }

        int cnt = 1, prev = height[0];
        for(int i = 1; i < N; i++) {
            if(prev > height[i]) {
                prev = height[i];
                continue;
            } else {
                prev = height[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}