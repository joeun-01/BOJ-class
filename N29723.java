package BOJ;

/*
올해 고3인 브실이는 세계 최고의 명문 대학 브실대학(브론즈실버대학)에 가기 위해서 자신의 현재 점수를 토대로 입시 전략을 세우려고 한다. 
브실대학에서는 특정 과목들의 성적의 합을 통해 서류 전형의 합격여부를 결정한다고 한다. 
그러나 브실대학에서는 어떤 과목이 서류 평가에 반영되는지 모두 알려주지 않고 일부만 알려주는 사악한 학교다. 
브실대학에서 요구하는 과목 수와 반영된다고 공개된 과목들이 주어질 때, 브실이가 얻을 수 있는 최소 점수와 최대 점수를 구해보자.

단, 공개된 과목과 비공개된 과목은 브실이가 수강한 과목에 모두 포함되어 있으며, 과목은 중복되지 않는다.

첫 번째 줄에 브실이가 수강한 과목 수 N과 브실대학에서 요구하는 과목 수 M, 그리고 브실대학에서 공개한 과목 수 K가 공백으로 구분되어 주어진다. 
(1 \<= K <= M <= N <= 10,000) 

그다음 N줄에 걸쳐 브실이가 수강한 과목 이름 s_i과 정수 점수 p_i가 공백으로 구분되어 주어진다. 
s_i는 영어 소문자로만 이루어져 있다. (3 <= |s_i| <= 20; 0 <= p_i <= 100) 

그다음 K줄에 걸쳐 브실대학에서 공개한 과목 이름 t_i가 주어진다. 
t_i는 영어 소문자로만 이루어져 있다. (3 <= |t_i| <= 20) 

브실이가 얻을 수 있는 최소 점수와 최대 점수를 공백으로 구분하여 출력한다.

6 3 2
calculus 100
probability 70
physics 50
chemistry 80
python 90
algorithm 100
physics
python

210 240
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N29723 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());
        int K = Integer.parseInt(stoi.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer info = new StringTokenizer(read.readLine());
            String subject = info.nextToken();
            int score = Integer.parseInt(info.nextToken());

            map.put(subject, score);
        }

        int score = 0;
        for(int i = 0; i < K; i++) {
            String subject = read.readLine();
            score += map.get(subject);
            
            map.remove(subject);
        }

        int[] scores = new int[N - K];
        int i = 0;
        for(String key : map.keySet()) {
            scores[i] = map.get(key);
            i++;
        }      
        
        Arrays.sort(scores);

        int min = score, max = score;
        for(i = 0; i < M - K; i++) {
            min += scores[i];
            max += scores[scores.length - i - 1];
        }

        System.out.println(min + " " + max);
    }
}