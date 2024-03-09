package BOJ;

/*
이 대회의 채점 프로그램은 각 팀별로 시간 순서대로 쌓인 제출 로그를 분석하여 결과를 낸다. 
각각의 로그는 제출 시각, 문제 이름, 제출 결과(통과, 실패)를 포함하고 있다. 
예를 들어, 어떤 팀의 가상 제출 로그가 아래와 같다고 하자.

3 E right
10 A wrong
30 C wrong
50 B wrong
100 A wrong
200 A right
250 C wrong
300 D right

팀의 순위를 산정하기 위한 점수는 푼 문제 수를 우선으로, 푼 문제 수가 같다면 페널티를 기준으로 매겨진다. 
페널티는 푼 문제에 대해서만 매겨지며, 문제를 맞힌 시각 + 틀린 횟수*20으로 정해진다. 
만일 아무 문제도 풀지 못했다면 페널티는 0이다.

위의 예제에서, 우리는 이 팀이 세 개의 문제를 해결했음을 알 수가 있다. 
대회 시각 3분째에 첫 제출로 문제 E를 해결했으며, 문제 A에 대해서는 세 번을 제출하여 200분째에 정답을 받았고, 문제 D는 300분째에 한 번의 제출로 해결하였다. 
위 로그를 기반으로 산정한 페널티는 543이 되는데, 이는 E를 해결한 시각 3과 A를 해결한 시각 200, A를 두 번 틀린 페널티 40, D를 해결한 시각 300을 더한 값이다. 
문제 B와 C에 대해서도 제출 기록은 있지만, 해결하지 못했으므로 페널티에는 영향을 주지 않았다.

대회 룰에 따르면, 만일 팀이 어떤 문제를 해결했다면 그 문제에 대한 추가적인 제출은 모두 무시된다(따라서 로그에도 남지 않는다). 
제출 시각이 연속적으로 기록되지 않고 이산화되어있기 때문에, 같은 시각에 여러 제출이 있을 수도 있다. 
하지만 제출 자체는 시간 순으로 이루어졌으므로, 같은 시각에 같은 문제를 제출한 로그가 남아 있다면 마지막 제출을 제외한 모든 제출은 오답이었을 것이다.

두 번째 예시로, 아래의 제출 로그를 보자.

7 H right
15 B wrong
30 E wrong
35 E right
80 B wrong
80 B right
100 D wrong
100 C wrong
300 C right
300 D wrong

위 팀은 4개의 문제를 해결했으며, 총 페널티는 502가 된다. 
이는 H번에 대해 7, E번에 대해 35+20, B번에 대해 80+40, C번에 대해 300+20을 합산한 값이다.

로그가 n줄에 걸쳐 주어진다. (0 ≤ n ≤ 100)
각 로그는 공백으로 구분된 세 파트로 이루어지며, 정수 m, 문제 이름, 결과를 의미한다. (0 ≤ m ≤ 300, 문제 이름은 알파벳 대문자, 결과는 "right" 또는 "wrong")
로그는 제출 시각이 감소하지 않는 순서로 주어지며, 동일한 시각에 제출된 로그가 여러 개일 수도 있다.
모든 로그가 주어진 뒤 마지막 줄엔 정수 -1 하나가 주어진다.

푼 문제 수와 총 걸린 시간(페널티 포함)을 출력한다.

3 E right
10 A wrong
30 C wrong
50 B wrong
100 A wrong
200 A right
250 C wrong
300 D right
-1

3 543
 */

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N11531 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> wrong = new HashMap<>();
        HashSet<String> right = new HashSet<>();
        int penalty = 0;

        while(true) {
            String str = read.readLine();

            if(str.equals("-1")) break;
            StringTokenizer stoi = new StringTokenizer(str);

            int time = Integer.parseInt(stoi.nextToken());
            String problem = stoi.nextToken();
            String result = stoi.nextToken();

            if(result.equals("right")) {
                if(right.add(problem)) {
                    penalty += time;
                    penalty += wrong.getOrDefault(problem, 0) * 20;
                }

            } else if(result.equals("wrong")) {
                wrong.put(problem, wrong.getOrDefault(problem, 0) + 1);
            }
        }

        System.out.print(right.size() + " ");
        System.out.println(penalty);
    }
}