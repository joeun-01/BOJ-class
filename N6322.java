package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6322 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int idx = 1;
        while(true) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            
            double a = Integer.parseInt(stoi.nextToken());
            double b = Integer.parseInt(stoi.nextToken());
            double c = Integer.parseInt(stoi.nextToken()); 

            if(a == 0 && b == 0 && c == 0) break;

            build.append("Triangle #" + idx + "\n");

            if(a == -1) {                
                if(b >= c) {
                    build.append("Impossible.\n");
                    
                    idx++;
                    build.append("\n");
                    continue;
                }
                
                a = Math.pow(c, 2) - Math.pow(b, 2);
                build.append("a = " + String.format("%.3f", Math.sqrt(a)) + "\n");
            } else if(b == -1) {           
                if(a >= c) {
                    build.append("Impossible.\n");

                    idx++;
                    build.append("\n");
                    continue;
                }

                b = Math.pow(c, 2) - Math.pow(a, 2);
                build.append("b = " + String.format("%.3f", Math.sqrt(b)) + "\n");

            } else if(c == -1) {
                c = Math.pow(a, 2) + Math.pow(b, 2);
                build.append("c = " + String.format("%.3f", Math.sqrt(c)) + "\n");
            }
            
            idx++;
            build.append("\n");
        }

        System.out.println(build);
    }
}