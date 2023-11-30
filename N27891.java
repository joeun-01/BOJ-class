package BOJ;

/*
GEC에는 여러 학교가 있다. 
각 학교의 약칭과 정식 명칭은 다음과 같다.

NLCS: North London Collegiate School
BHA: Branksome Hall Asia
KIS: Korea International School
SJA: St. Johnsbury Academy
학교 이름을 싫어하는 동호는, 학교들의 이름을 암호화해 버렸다!

동호가 이름을 암호화하는 방법은 다음과 같다. 
이 문제에서 암호화되는 이름은 정식 명칭임에 유의한다.

이름에 있는 모든 공백과 문장 부호를 제거한다.
이름의 모든 대문자를 소문자로 바꾼다.
이름의 첫 10글자를 제외한 모든 글자를 지운다.
 
0에서 25까지의 정수 N을 하나 고른 후, 이름의 모든 글자를 N칸 앞으로 이동시킨다.
문자를 앞으로 N칸 이동시킨다는 것은 a를 b로, b를 c로, ..., y를 z로, z를 a로 바꾸는 것을 N번 반복하는 것이다.

당신은 동호가 암호화한 이름이 원래 어떤 학교의 것이었는지 알고 싶으나, 동호가 고른 정수 N을 알지 못한다.

암호화된 이름이 주어졌을 때, 그 이름이 원래 어떤 학교의 이름이었는지 알아내는 프로그램을 작성하시오.

첫 번째 줄에 암호화된 학교의 이름이 주어진다. 
모든 입력은 위에서 서술된 과정에 따라 생성되었다.

첫 번째 줄에 암호화된 학교의 이름이 NLCS의 것이라면 NLCS, BHA의 것이라면 BHA, KIS의 것이라면 KIS, SJA의 것이라면 SJA를 출력한다.

csboltpnfi

BHA
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N27891 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String str = read.readLine();

        /*
            NLCS: North London Collegiate School
            BHA: Branksome Hall Asia
            KIS: Korea International School
            SJA: St. Johnsbury Academy
         */

        String[] list = {"nor", "bra", "kor", "stj"};
        String[] college = {"NLCS", "BHA", "KIS", "SJA"};
        
        for(int i = 0; i < 4; i++) {
            int d1 = (str.charAt(0) - 'a' - (list[i].charAt(0) - 'a') + 26) % 26;
            int d2 = (str.charAt(1) - 'a' - (list[i].charAt(1) - 'a') + 26) % 26;
            int d3 = (str.charAt(2) - 'a' - (list[i].charAt(2) - 'a') + 26) % 26;

            if(d1 == d2 && d2 == d3) {
                System.out.println(college[i]);
                break;
            }
        }
    }
}