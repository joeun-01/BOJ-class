package BOJ;

/*
깊은 아마존 정글에 거대한 나무들에서 갈색 원숭이들이 매우 좋아하는 무화과가 열리고, 이 나무에는 향나무노린재들이 서식하고 있다.

나무 꼭대기에 도달하기 위해서 원숭이들은 매우 조심스럽게 나무에 올라가는 길을 찾아야한다. 
거대한 나무는 부서지기 쉬운 덩굴들이 있는데 이 덩굴들은 시소의 원리와 비슷하다. 
덩굴의 무게가 불균형 하면 그 덩굴은 끊어지며 그 원숭이들은 땅으로 떨어져버린다. 
원숭이들은 서로 협력하여 덩굴의 균형을 유지한다면 그들은 모두 무화과가 열리고 향나무노린재들이 서식하는 나무 꼭대기에 도달할 수 있다는 것을 발견했다.

덩굴은 두개의 덩굴로 나눠질 수 있는데 덩굴이 끊어지지 않기 위해서는 나눠진 두 덩굴은 같은 수의 원숭이들이 매달려 있어야한다. 
덩굴의 나눠지는 지점을 "[]"로 정의 내리면 덩굴의 구조를 꺾쇠괄호로 표시할 수 있다. 
또한 덩굴의 깊이는 25를 넘지 않는다.

원숭이들은 덩굴의 균형을 유지하면서 나무꼭대기에 도달할 수 있는 최소 원숭이 수를 알고 싶다. 
나무 꼭대기에 도달하기 위해서 최소 한 마리 원숭이가 필요하다.

첫째 줄에 테스트 케이스의 개수 N(1 ≤ N ≤ 1000)이 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있고, 덩굴의 구조를 꺾쇠괄호로 표현한 문자열이 주어진다. 
문자열의 길이는 0보다 크거나 같고, 150보다 작거나 같다.

각 테스트 케이스마다 덩굴의 균형을 유지하면서 나무꼭대기에 도달할 수 있는 최소 원숭이 수를 출력한다.

3
[]

[[][[]]]

2
1
8
 */

import java.io.*;

public class N2716 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        for(int i = 0; i < N; i++) {
            String str = read.readLine();

            if(str == null) {
                build.append(1).append("\n");
                continue;
            }

            int maxLevel = 0, level = 0;
            for(int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                if(letter == '[') {
                    level++;
                    maxLevel = Math.max(maxLevel, level);
                } else {
                    level--;
                }

                // System.out.println(letter + " " + level);
            }

            build.append((int) Math.pow(2, maxLevel)).append("\n");
        }

        System.out.println(build);
    }
}