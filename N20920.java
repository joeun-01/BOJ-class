package BOJ;

/*
화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 
그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 
화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.

자주 나오는 단어일수록 앞에 배치한다.
해당 단어의 길이가 길수록 앞에 배치한다.
알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.
 
$M$보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가 
$M$이상인 단어들만 외운다고 한다. 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.

첫째 줄에는 영어 지문에 나오는 단어의 개수 N과 외울 단어의 길이 기준이 되는 M이 공백으로 구분되어 주어진다. (1 <= N <= 100,000, 1 <= M <= 10)

둘째 줄부터 N+1번째 줄까지 외울 단어를 입력받는다. 
이때의 입력은 알파벳 소문자로만 주어지며 단어의 길이는 10을 넘지 않는다.

단어장에 단어가 반드시 1개 이상 존재하는 입력만 주어진다.

화은이의 단어장에 들어 있는 단어를 단어장의 앞에 위치한 단어부터 한 줄에 한 단어씩 순서대로 출력한다.

7 4
apple
ant
sand
apple
append
sand
sand

sand
apple
append
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class N20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String word = read.readLine();
            if(word.length() < M) continue;
            
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // map에서 단어들을 가져와서 ArrayList에 저장
        List<String> words = new ArrayList<>(map.keySet());
        
        // List를 우선순위를 통해 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });
        
        // 정렬된 단어들을 출력
        for (String word : words) {
            build.append(word).append("\n");
        }

        System.out.println(build);
    }
}