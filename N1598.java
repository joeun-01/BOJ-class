package BOJ;

/*
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 
그 녀석은 원주 부근을 돌아다니다가 코레스코 콘도에서 아주 재밌는 놀이를 발견했다. 
그 놀이의 이름은 바로 “꼬리를 무는 숫자 나열”. 이제부터 원숭이가 그토록 좋아하던 그 놀이를 파헤쳐보자.

놀이의 방법은 간단하다. 
일단 4줄짜리 표에 왼쪽부터 수를 아래로 1부터 순서대로 적어나간다. 
다음에 그 예가 잘 나타나있다.

이제 원숭이는 두 개의 자연수를 아무거나 생각한다. 
그리고 숫자판에서 두 개의 자연수 사이의 직각거리를 구하면 된다. 
여기서 직각거리는 동서방향거리와 남북방향거리의 합을 뜻한다.

예를 들어 저 숫자판에서 11과 33을 생각했다고 하자. 
그렇다면 11과 33사이의 직각거리는 8이 된다.(동서방향거리 : 6, 남북방향거리 : 2) 
다음 그림에 잘 나타나있다.

하지만 원숭이는 지금 혼란스럽다. 
동물원에서 탈출한지 얼마 되지 않아서 계산을 할 수 없는 경지에 이르렀다. 
여러분이 불쌍한 원숭이를 좀 도와줘야겠다. 
원숭이가 생각한 두 자연수 사이의 직각거리를 구하는 프로그램을 작성하시오.

첫째 줄에 원숭이가 생각한 두 개의 자연수가 주어진다. 
각 수는 10,000,000 이하이다.

첫째 줄에 원숭이가 생각한 두 개의 자연수 사이의 직각거리를 출력한다.

11 33

8
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class N1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int n = Integer.parseInt(stoi.nextToken());
        int m = Integer.parseInt(stoi.nextToken());

        int nr = n % 4;
        if(nr == 0) nr = 4;

        int nc = n / 4;
        if(nr != 4) nc++;

        int mr = m % 4;
        if(mr == 0) mr = 4;

        int mc = m / 4;
        if(mr != 4) mc++;

        int result = Math.abs(nr - mr) + Math.abs(nc - mc);
        System.out.println(result);
    }
}
