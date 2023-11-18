package BOJ;

/*
정수 A, B 가 주어진다. 
세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.

표준 입력에 다음과 같은 형태로 입력이 주어진다.
A
B

세로 길이가 A cm, 가로 길이가 B cm인 직사각형의 넓이를 cm2 단위로 구하고, 단위 (cm2)를 생략하여 출력한다.

1 ≦ A ≦ 100.
1 ≦ B ≦ 100.
A, B 는 정수이다.

2
3

6
 */

import java.io.*;

public class N27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(read.readLine());
        int B = Integer.parseInt(read.readLine());

        System.out.println(A * B);
    }
}
