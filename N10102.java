package BOJ;

import java.io.*;

public class N10102 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        int V = Integer.parseInt(read.readLine());
        String vote = read.readLine();

        int first = 0, second = 0;
        for(int i = 0; i < V; i++) {
            if(vote.charAt(i) == 'A') first++;
            else second++;
        }

        if(first == second) System.out.println("Tie");
        else if(first > second) System.out.println("A");
        else if(first < second) System.out.println("B");
    }
}
