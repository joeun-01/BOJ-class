package BOJ;

/*
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

첫째 줄에 N이 주어진다.
둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109

5
2 4 -10 4 -9

2 3 0 3 1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.IOException;

public class N18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int data = Integer.parseInt(read.readLine());
        StringTokenizer input = new StringTokenizer(read.readLine());

        int[] nums = new int[data];
        TreeMap<Integer, Integer> sort = new TreeMap<>();

        for(int i = 0; i < data; i++) {
            nums[i] = Integer.parseInt(input.nextToken());
            sort.put(nums[i], 0);
        }

        int count = 0;
        for(Integer key : sort.keySet()) {
            sort.put(key, count);
            count++;
        }

        for(int i = 0; i < data; i++) {
            build.append(sort.get(nums[i]) + " ");
        }

        System.out.println(build);
    }
}
