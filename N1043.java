package BOJ;

/*
지민이는 파티에 가서 이야기 하는 것을 좋아한다. 
파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다. 
지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다. 
당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다.
하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다. 
따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다. 
당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다. 
지민이는 이런 일을 모두 피해야 한다.

사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 
그리고 각 파티에 오는 사람들의 번호가 주어진다. 
지민이는 모든 파티에 참가해야 한다. 
이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.

첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.

둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다. 
진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다. 
사람들의 번호는 1부터 N까지의 수로 주어진다.

셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.

N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수, 각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.

첫째 줄에 문제의 정답을 출력한다.

4 3
0
2 1 2
1 3
3 2 3 4

3
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class N1043 {
    static int[] parent;

    static int n,m;
    static int ans = 0;

    static boolean know[];

    static ArrayList<Integer>party[];
    static ArrayList<Integer>people[];

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);

        know = new boolean[n+1];
        people = new ArrayList[n+1];
        party = new ArrayList[m];

        for(int i=1; i<=n; i++) {
            people[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            party[i] = new ArrayList<>();
        }
        
        t = br.readLine().split(" ");
        
        for(int i=1; i<t.length; i++) {
            know[Integer.parseInt(t[i])] = true;    // 이 사람들은 진실을 알고있다
        }
        
        
        for(int i=0; i<m; i++) {
            t = br.readLine().split(" ");
            for(int j=1; j<t.length; j++) {
                int tmp = Integer.parseInt(t[j]);
                party[i].add(tmp);      
                people[tmp].add(i);
            }
        }
        bfs();
    }
    public static void bfs() {
        Queue<Integer> q= new LinkedList<>();
        boolean visited [] = new boolean [m];
        
        for(int i=1; i<=n; i++) {
            if(know[i]) {   // 아는 사람들이 참여한 파티정보 
                for(int k=0; k<people[i].size(); k++) {
                    if(!visited[people[i].get(k)]) {
                        q.add(people[i].get(k));
                        visited[people[i].get(k)] = true;
                    }
                }
            }
        }
        
        
        while(!q.isEmpty()) {
            int a = q.poll();   // 파티번호
            
            
            for(int num : party[a]) {
                // num 이 참석한 파티정보
                for(int partyInfo : people[num]) {
                    if(!visited[partyInfo]) {
                        q.add(partyInfo);
                        visited[partyInfo] = true;
                    }
                }
            }
            
        }
        for(int i=0; i<m; i++) {
            if(!visited[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
