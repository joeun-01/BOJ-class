package BOJ;

/*
군대에 간 푸앙이는 4교대 근무를 서게 된다. 
근무 시간대는 08:00~12:00, 12:00~18:00, 18:00~22:00, 22:00~08:00 으로 각각 4, 6, 4, 10시간의 근무로 구성되어 있다.

푸앙이와 동기들은 근무 시간이 최대한 공평하게 배분되기를 원한다. 
그래서 근무표 전체에서 각 인원의 근무 시간이 12시간 이하로 차이 나게 해서 최대 50주 치 근무표를 짜려고 한다.

푸앙이는 원래 똑똑해서 이 정도는 한눈에 계산이 가능했지만 어째서인지 푸앙이는 계산이 불가능해졌다. 
푸앙이를 위해서 대신 근무표가 공평한지 계산해주자.

첫 번째 줄에 주의 개수인 N이 입력된다. (1 <= N <= 50) 

둘째 줄부터 근무표가 주어진다. 
각 주는 4개의 줄로 표현되며, 그중 첫째 줄은 각 날의 08:00~12:00에 근무하는 사람의 이름 또는 '-', 둘째 줄은 12:00~18:00, 셋째 줄은 18:00~22:00, 넷째 줄은 22:00~08:00을 나타낸다. 
'-'는 근무자가 없음을 의미한다. 
근무자의 이름은 모두 알파벳 소문자로 이루어져 있고 20글자를 넘지 않는다.

각 날에는 4개의 시간대에 모두 근무자가 있거나 모두 근무자가 없다. 
예를 들어 12:00~18:00에만 근무자가 있는 날은 없다.

근무표에 적히지 않은 근무자는 없으며, 근무자 수는 최대 100명이다.

근무표가 공평하면 “Yes”를 아니면 “No”를 출력한다. 
단, 아무도 근무하지 않을 경우 공평한 것으로 간주한다.

4
- - - - - pangyo puang
- - - - - sally boss
- - - - - leonard brown
- - - - - edward edward
puang pangyo choco leonard cony leonard choco
cony edward cony leonard moon puang edward
choco boss puang brown brown pangyo cony
choco edward puang cony moon choco boss
brown moon moon sally pangyo puang choco
pangyo edward boss sally moon cony pangyo
brown puang james moon cony choco choco
sally brown sally puang james moon sally
leonard pangyo - - - - -
boss choco - - - - -
moon edward - - - - -
moon sally - - - - -

No
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N25593 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        HashMap<String, Integer> table = new HashMap<>(); 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 4; j++) {
                StringTokenizer stoi = new StringTokenizer(read.readLine());

                while(stoi.hasMoreTokens()) {
                    String name = stoi.nextToken();
                
                    if(!name.equals("-")) {
                        switch (j) {
                            case 0:
                                table.put(name, table.getOrDefault(name, 0) + 4);
                                break;
    
                            case 1:
                                table.put(name, table.getOrDefault(name, 0) + 6);
                                break;
    
                            case 2:
                                table.put(name, table.getOrDefault(name, 0) + 4);
                                break;
    
                            case 3:
                                table.put(name, table.getOrDefault(name, 0) + 10);
                                break;
                        
                            default:
                                break;
                        }
                    }
                }   
            }
        }

        // System.out.println(table);

        if(table.size() == 0) {
            System.out.println("Yes");
            System.exit(0);
        }

        int min = Integer.MAX_VALUE, max = 0;
        for(String names : table.keySet()) {
            int time = table.get(names);

            if(time < min) min = time;
            if(time > max) max = time;
        }

        if(max - min <= 12) System.out.println("Yes");
        else System.out.println("No");
    }
}