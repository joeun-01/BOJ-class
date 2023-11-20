package BOJ;

/*
3개의 시간조절용 버튼 A B C가 달린 전자레인지가 있다. 
각 버튼마다 일정한 시간이 지정되어 있어 해당 버튼을 한번 누를 때마다 그 시간이 동작시간에 더해진다. 
버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.

냉동음식마다 전자레인지로 요리해야할 시간 T가 초단위로 표시되어 있다. 
우리는 A, B, C 3개의 버튼을 적절히 눌러서 그 시간의 합이 정확히 T초가 되도록 해야 한다. 
단 버튼 A, B, C를 누른 횟수의 합은 항상 최소가 되어야 한다. 
이것을 최소버튼 조작이라고 한다.

만일 요리시간이 100초라고 하면(T=100) B를 1번, C는 4번 누르면 된다. 
이와 다르게 C를 10번 눌러도 100초가 되지만 이 경우 10번은 최소 횟수가 아니기 때문이 답이 될 수 없다. 
이 경우 B 1번, C 4번, 총 5번이 최소버튼 조작이다. 
그리고 T=234와 같이 3개의 버튼으로 시간을 정확히 맞출 수 없는 경우도 있다.

여러분은 주어진 요리시간 T초를 맞추기 위한 최소버튼 조작 방법을 구하는 프로그램을 작성해야 한다.

첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.

여러분은 T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다. 
각각의 횟수 사이에는 빈 칸을 둔다. 
해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다. 
만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.

100

0 1 4
 */

import java.io.*;

public class N10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());

        if(T % 10 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        int button = 0;

        button = T / 300;
        T %= 300;
        build.append(button + " ");

        button = T / 60;
        T %= 60;
        build.append(button + " ");

        button = (int) Math.round((double) T / 10);
        build.append(button);

        System.out.println(build);
    }
}
