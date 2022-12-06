package BOJ;

/*
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 
이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. 
N, M은 500,000 이하의 자연수이다.
듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

듣보잡의 수와 그 명단을 사전순으로 출력한다.

3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton

2
baesangwook
ohhenrie
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer input = new StringTokenizer(read.readLine());

        int listen = Integer.parseInt(input.nextToken());
        int see = Integer.parseInt(input.nextToken());

        HashMap<String, Boolean> listenList = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < listen; i++) {
            listenList.put(read.readLine(), true);
        }

        System.out.println();

        for(int i = 0; i < see; i++) {
            String name = read.readLine();
            
            if(listenList.getOrDefault(name, false)) {
                list.add(name);
            }
        }

        Collections.sort(list);
        build.append(list.size() + "\n");

        for(int i = 0; i < list.size(); i++) {
            build.append(list.get(i) + "\n");
        }

        System.out.println(build);
    }
}
