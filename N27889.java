package BOJ;

/*
GEC에는 여러 학교가 있다. 각 학교의 약칭과 정식 명칭은 다음과 같다.

NLCS: North London Collegiate School
BHA: Branksome Hall Asia
KIS: Korea International School
SJA: St. Johnsbury Academy
학교 이름을 좋아하는 규빈이는, 학교 이름을 짧게 부르는 것을 싫어하기 때문에, 각 학교의 약칭이 주어졌을 때 정식 명칭을 출력하는 프로그램을 만들기로 하였다.

각 학교의 약칭이 주어졌을 때, 정식 명칭을 출력하는 프로그램을 작성하시오.GEC에는 여러 학교가 있다. 
각 학교의 약칭과 정식 명칭은 다음과 같다.

NLCS: North London Collegiate School
BHA: Branksome Hall Asia
KIS: Korea International School
SJA: St. Johnsbury Academy
학교 이름을 좋아하는 규빈이는, 학교 이름을 짧게 부르는 것을 싫어하기 때문에, 각 학교의 약칭이 주어졌을 때 정식 명칭을 출력하는 프로그램을 만들기로 하였다.

각 학교의 약칭이 주어졌을 때, 정식 명칭을 출력하는 프로그램을 작성하시오.

첫 번째 줄에 학교의 약칭 중 하나가 주어진다.

첫 번째 줄에 입력된 학교의 정식 명칭을 출력한다.

NLCS

North London Collegiate School
 */

import java.io.*;
import java.util.HashMap;

public class N27889 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> map = new HashMap<>();
        map.put("NLCS", "North London Collegiate School");
        map.put("BHA", "Branksome Hall Asia");
        map.put("KIS", "Korea International School");
        map.put("SJA", "St. Johnsbury Academy");
        
        String name = read.readLine();
        System.out.println(map.get(name));
    }
}