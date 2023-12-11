package BOJ;

/*
재현이가 키우는 앵무새 포포와 레몬이는 그동안 새끼들을 참 많이도 낳았다. 
그렇게 태어난 앵무새들을 관찰하며 재현이는 앵무새들의 색에 간단한 규칙이 있다는 것을 발견했다. 
그것은 바로 자식 앵무새의 몸통 색은 아빠 새의 몸통 색과 꼬리 색, 엄마 새의 몸통 색과 꼬리 색 중 하나이며 꼬리 색도 마찬가지로 이 넷 중 하나의 색으로 정해진다는 것이다.

아빠 새의 몸통 색과 꼬리 색, 엄마 새의 몸통 색과 꼬리 색이 주어질 때 가능한 자식 앵무새의 몸통 색과 꼬리색의 모든 쌍을 사전 순으로 출력하라. (단, 중복되는 몸통 색, 꼬리 색의 쌍은 출력하지 않는다.)

첫 번째 줄에 아빠 새의 몸통 색과 꼬리 색이 주어진다.
두 번째 줄에 엄마 새의 몸통 색과 꼬리 색이 주어진다.
각각의 색은 1자 이상 20자 이내의 알파벳 소문자로 이루어진 문자열로 주어지며, 같은 색이 중복되어 나타날 수 있다.

자식 새의 몸통 색과 꼬리 색의 쌍을 한 줄에 하나씩 사전 순으로 출력한다. 
사전 순으로 출력하라는 말은 몸통 색이 다르다면 몸통 색의 사전 순으로, 몸통 색이 같다면 꼬리 색의 사전 순으로 출력하라는 것을 의미한다.

blue purple
green green

blue blue
blue green
blue purple
green blue
green green
green purple
purple blue
purple green
purple purple
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N28445 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        TreeSet<String> color = new TreeSet<>();

        StringTokenizer dad = new StringTokenizer(read.readLine());
        color.add(dad.nextToken());
        color.add(dad.nextToken());

        StringTokenizer mom = new StringTokenizer(read.readLine());
        color.add(mom.nextToken());
        color.add(mom.nextToken());

        // System.out.println(color);

        int size = color.size();
        String[] result = new String[size];
        for(int i = 0; i < size; i++) {
            result[i] = color.pollFirst();
        }

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                build.append(result[i]).append(" ").append(result[j]).append("\n");
            }
        }

        System.out.println(build);
    }
}