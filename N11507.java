package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
최근에 진솔이는 로봇 공학을 하기 시작했다. 
그래서 포커 카드가 완전한 세트인지 확인하는 로봇을 만들기로 결심했다.

그는 프로그램을 작성하는 일을 분담했다. 
그 프로그램은 카드의 모양(스페이드(♠), 하트(♡), 다이아몬드(♢), 클럽(♣))을 인식하는 것이다. 
문제를 간단하게 하기 위해서 모든 카드는 하나의 모양과 하나의 숫자를 가진다고 가정한다.

여기서 그 모양은 실제 그림 대신 문자로 대체한다. 
P,K,H,T에 해당한다. 
그리고 숫자는 1~13에 해당하는 정수이다. 
로봇은 각각의 카드를 TXY의 형태로 '카드 이름'을 정하는데 T는 모양에 해당하고 XY는 숫자에 해당한다. 
만약 만약 숫자가 1자리 숫자이면 X=0에 해당한다. ex) 01.

만약에 모양이 P이고 숫자가 9이면 P09이다.
완벽한 카드 한 세트는 52개로 이루어져 있다. (4 (모양)x 13(숫자))
로봇은 모든 카드의 '카드이름'을 읽고 문자열 S로 결합한다.

이제 진솔이가 프로그래밍 하는 것을 도와주자.  
문자열을 읽어 얼마나 많은 카드를 잃어버렸는지 세면 된다.

만약에 2개의 같은 카드가 존재한다면 GRESKA이라고 출력하면 된다.

오직 1줄만 문자열 S(1 ≤ |S| ≤ 1000)가 들어온다. 
이것은 현재 가지고 있는 카드 이름에 해당한다.

만약 똑같은 카드가 존재한다면 GRESKA을 출력한다.
그렇지 않으면 4개의 정수를 공백 문자로 구분하여 출력한다. 
각각 P, K, H, T에 해당한다.

P01K02H03H04

12 12 11 13
 */

public class N11507 {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String input = read.readLine();
        int length = input.length();

        HashSet<String> setP = new HashSet<>();
        HashSet<String> setK = new HashSet<>();
        HashSet<String> setH = new HashSet<>();
        HashSet<String> setT = new HashSet<>();

        for(int i = 0; i < length; i += 3){
            String card = input.substring(i, i + 3);
            char shape = card.charAt(0);

            switch(shape) {
                case 'P' :
                    if(!setP.add(card)) {
                        System.out.println("GRESKA");
                        System.exit(0);
                    }
                    break;

                case 'K' :
                    if(!setK.add(card)) {
                        System.out.println("GRESKA");
                        System.exit(0);
                    }
                    break;
                
                case 'H' :
                    if(!setH.add(card)) {
                        System.out.println("GRESKA");
                        System.exit(0);
                    }
                    break;
                
                case 'T' :
                    if(!setT.add(card)) {
                        System.out.println("GRESKA");
                        System.exit(0);
                    }
                    break;
                
                default :
                    break;
            }
        }

        System.out.print((13 - setP.size()) + " ");
        System.out.print((13 - setK.size()) + " ");
        System.out.print((13 - setH.size()) + " ");
        System.out.print((13 - setT.size()));
    }
}