package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11034 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        String str = "";
        while((str = read.readLine()) != null) {
            StringTokenizer stoi = new StringTokenizer(str);

            int A = Integer.parseInt(stoi.nextToken());
            int B = Integer.parseInt(stoi.nextToken());
            int C = Integer.parseInt(stoi.nextToken());

            int cnt = 0;
            while(true) {
                if(A + 1 == B && B + 1 == C) break;

                if(B - A < C - B) {
                    A = B;
                    B = B + 1;
                } else {
                    C = B;
                    B = C - 1;
                }

                cnt++;
            }

            build.append(cnt).append("\n");
        }

        System.out.println(build);
    }
}