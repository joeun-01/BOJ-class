package BOJ;

/*
동규는 세수를 하다가 정렬이 하고 싶어졌다.
정수 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어졌다.
정수 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.

정수 세 개가 주어진다. 
이 수는 1보다 크거나 같고, 1,000,000보다 작거나 같다. 
이 수는 모두 다르다.

제일 작은 수, 그 다음 수, 제일 큰 수를 차례대로 출력한다.

3 1 2

1 2 3
 */

import java.io.*;
import java.util.*;

public class N2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int a = Integer.parseInt(stoi.nextToken());
        int b = Integer.parseInt(stoi.nextToken());
        int c = Integer.parseInt(stoi.nextToken());

        int min = Math.min(a, Math.min(b, c));
        if(min == a) {
            build.append(a).append(" ");
            build.append(Math.min(b, c)).append(" ");
            build.append(Math.max(b, c));
        } else if(min == b) {
            build.append(b).append(" ");
            build.append(Math.min(a, c)).append(" ");
            build.append(Math.max(a, c));
        } else if(min == c) {
            build.append(c).append(" ");
            build.append(Math.min(a, b)).append(" ");
            build.append(Math.max(a, b));
        }

        System.out.println(build);
    }
}