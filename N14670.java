package BOJ;

/*
영정이는 병약하다. 
본인도 병약한 것을 알고 있기 때문에 언제든 먹을 수 있는 약을 상비해서 들고 다닌다. 
각 약들은 약의 이름과 필요한 증상이 적혀져 있으며 하나의 약은 하나의 증상만을 해결 할 수 있다. 
각각의 약은 모두 다른 이름을 가지고 있으며 서로 다른 증상을 해결함이 보장된다. 
영정이가 아픈 증상을 호소 할 때, 어떤 약들을 먹어야 하는지 출력 해 주자!

프로그램의 입력은 표준 입력으로 받는다. 
입력의 첫 줄에는 약의 종류의 개수 N이 입력된다. (1 ≤ N ≤ 100) 
그 다음 N개의 줄에는 각각 약의 효능과 약의 이름이 숫자로 주어진다. (0 ≤ Me, Mn ≤ 100) 
각 약의 이름과 효능은 다른 어떤 약의 이름, 효능과 중복되지 않음을 보장한다. 
다음 줄에는 영정이가 겪는 증상의 개수 R이 입력된다. (1 ≤ R ≤ 100) 
다음 R 줄에는 증상의 개수 Li 와 증상들 (S1, S2, … SL)이 주어진다 (1 ≤ Li ≤ N)

프로그램의 출력은 표준 출력으로 한다. 
R 개의 증상에 따라 먹어야 하는 약을 순서대로 출력한다. 
각각은 개행으로 구분한다. 
증상을 하나 이상 해결할 수 없을 경우 ‘YOU DIED’ 를 출력한다. 

3
1 3
4 2
99 1
4
1 1
2 4 99
3 4 1 99
1 5

3
2 1
2 3 1
YOU DIED
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N14670 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        int N = Integer.parseInt(read.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int effect = Integer.parseInt(stoi.nextToken());
            int name = Integer.parseInt(stoi.nextToken());

            map.put(effect, name);
        }

        int R = Integer.parseInt(read.readLine());
        for(int i = 0; i < R; i++) {
            StringTokenizer stoi = new StringTokenizer(read.readLine());
            int L = Integer.parseInt(stoi.nextToken());

            boolean solve = true;
            StringBuilder names = new StringBuilder();
            for(int j = 0; j < L; j++) {
                int effect = Integer.parseInt(stoi.nextToken());
                Object name = map.get(effect);

                // System.out.println(name);

                if(name == null) {
                    solve = false;
                    continue;
                }

                names.append(name).append(" ");
            }

            if(solve) build.append(names).append("\n");
            else build.append("YOU DIED\n");
        }

        System.out.println(build);
    }
}