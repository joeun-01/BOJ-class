package BOJ;

/*
동혁이는 새로운 이미지 문자 인식 프로그램을 만들었다. 이 프로그램은 종이에 쓰여 있는 글자를 스캔한 뒤, 텍스트 파일로 저장한다. 동혁이는 밤을 새며 열심히 프로그램을 만들었지만, 프로그램의 신뢰도는 100%가 아니며, 어떤 글자는 인식하지 못했다. 결국 동혁이는 100%가 아니라는 점에서 실망하였고, 대전으로 도망가게 되었다.

대전으로 도망가버린 동혁이를 대신해서, 동혁이가 만든 이미지 문자 인식 프로그램의 인식률을 계산하는 프로그램을 작성하시오.

인식률은 인식한 문자의 수를 R, 전체 문자의 수를 A라고 했을 때, R/A이다. 줄바꿈 문자는 문자로 세지 않는다.

입력은 N개의 테스트 케이스로 구성되어 있다. 첫째 줄에 테스트 케이스의 개수 N이 주어진다. 각 테스트 케이스는 적어도 한 줄이고, 인식하지 못한 문자는 '#'로 표시한다. 각 테스트 케이스의 다음에는 빈 줄이 한 칸씩 있다. 각 줄은 100글자를 넘지 않고, 줄의 수도 200줄을 넘지 않는다.

각 테스트 케이스에 대해서 인식률을 계산한 뒤 다음과 같이 출력한다. 각 줄은 "Efficiency ratio is X%."와 같은 형태로 출력해야 한다. X는 인식률을 퍼센트로 표시한 것이고, 소수점 두자리 이상인 경우에는 둘째 자리에서 반올림해서 출력한다. 단, 반올림 결과가 정수이면 정수 부분만 출력한다.

3
Pr#nt ex##tly one##ine for#eac# te#t c#se.

None.

The i#put consists of
N test ca#es. The number
of th#m (N) is given on
the first #ine
of the#input#file.

Efficiency ratio is 78.6%.
Efficiency ratio is 100%.
Efficiency ratio is 94%.
 */

import java.io.*;

public class N3448 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int T = Integer.parseInt(read.readLine());

        int totalLength = 0, none = 0;
        while(T > 0) {
            String str = read.readLine();

            if(str.length() == 0) {
                int suc = totalLength - none;
                double ratio = ((double) suc / totalLength) * 100;
                
                if(isInteger(ratio)) {
                    int result = (int) ratio;
                    build.append("Efficiency ratio is " + result + "%.\n");               
                } else {
                    double result = Math.round(ratio * 10) / 10.0;
                    build.append("Efficiency ratio is " + result + "%.\n");
                }

                T--; 

                totalLength = 0;
                none = 0;
            } else {
                int length = str.length();

                totalLength += length;

                for(int i = 0; i < length; i++) {
                    if(str.charAt(i) == '#') none++;
                }
            }
        }

        System.out.println(build);
    }

    public static boolean isInteger(double num) {
	    return num % 1 == 0.0;
    }   
}

