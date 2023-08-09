package BOJ;

/*
캠프에 오게 된 송유진은 캠프가 너무 지루해서 오늘로부터 캠프가 끝날 때 까지 며칠이나 남았는지 알아보고 싶었다. 그런데 캠프는 비상식적으로 길지도 몰라서 (윤년을 포함할지도 모른다) 손으로 하나하나 세기에는 힘들어 보였다.

더욱 정확한 계산을 위해, 유진이는 윤년이 정해지는 기준을 찾아보았고, 그것은 다음과 같았다.

서력기원 연수가 4로 나누어떨어지는 해는 우선 윤년으로 한다. (2004년, 2008년, …)
100으로 나누어떨어지는 해는 평년으로 한다. (2100년, 2200년, …)
400으로 나누어떨어지는 해는 다시 윤년으로 한다. (1600년, 2000년, …)
그런데 캠프가 너무 길 경우, 사춘기인 유진이는 캠프에 무단으로 빠질지도 모른다.

첫째 줄에 오늘의 날짜가 주어지고, 두 번째 줄에 D-Day인 날의 날짜가 주어진다. 날짜는 연도, 월, 일순으로 주어지며, 공백으로 구분한다. 입력 범위는 1년 1월 1일부터 9999년 12월 31일 까지 이다. 오늘의 날짜는 항상 D-Day보다 앞에 있다.

오늘부터 D-Day까지 x일이 남았다면, "D-"를 출력하고 그 뒤에 공백 없이 x를 출력한다. 만약 캠프가 천년 이상 지속된다면 (오늘이 y년 m월 d일이고, D-Day가 y+1000년 m월 d일과 같거나 늦다면) 대신 "gg"를 출력한다. 오늘이 2월 29일인 경우는 주어지지 않는다.

2008 12 27
2009 1 22

D-26
(윤년이 2월 29일 포함)
 */

import java.io.*;
import java.util.StringTokenizer;

public class N1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer now = new StringTokenizer(read.readLine());
        int nYear = Integer.parseInt(now.nextToken());
        int nMonth = Integer.parseInt(now.nextToken());
        int nDay = Integer.parseInt(now.nextToken());

        StringTokenizer camp = new StringTokenizer(read.readLine());
        int cYear = Integer.parseInt(camp.nextToken());
        int cMonth = Integer.parseInt(camp.nextToken());
        int cDay = Integer.parseInt(camp.nextToken());

        // 1000년 이상 차이나는 경우
        if(cYear - nYear > 1000) {
            System.out.println("gg");
            System.exit(0);
        } else if(cYear - nYear == 1000) {
            if(cMonth - nMonth > 0) {
                System.out.println("gg");
                System.exit(0);
            } else if(cMonth - nMonth == 0 && cDay - nDay >= 0) {
                System.out.println("gg");
                System.exit(0);
            }
        }

        int day = 0;

        // 년도 계산
        while(cYear - nYear > 1) {
            if(nYear % 400 == 0) day += 366;
            else if(nYear % 100 == 0) day += 365;
            else if(nYear % 4 == 0) day += 366;
            else day += 365;

            nYear++;
        }

        while(true) {
            // 1, 3, 5, 7, 8, 10, 12
            // 2
            // 4, 6, 9, 11
            if((cYear == nYear && cMonth - nMonth <= 1) || (cYear - nYear == 1 && cMonth == 1 && nMonth == 12)) break;  // 날을 계산하기 위해 남겨둠
            
            if(nMonth == 2) {
                if(nYear % 400 == 0) day += 29;
                else if(nYear % 100 == 0) day += 28;
                else if(nYear % 4 == 0) day += 29;
                else day += 28;
            } else if(nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11) {
                day += 30;
            } else {
                day += 31;
            }

            nMonth++;

            if(nMonth == 13) {
                nMonth = 1;
                nYear++;
            }
        }

        if((cMonth - nMonth == 1) || (cMonth == 1 && nMonth == 12)) {
            if(nMonth == 2) {
                if(nYear % 400 == 0) day += (29 - nDay);
                else if(nYear % 100 == 0) day += (28 - nDay);
                else if(nYear % 4 == 0) day += (29 - nDay);
                else day += (28 - nDay);
            } else if(nMonth == 4 || nMonth == 6 || nMonth == 9 || nMonth == 11) {
                day += (30 - nDay);
            } else {
                day += (31 - nDay);
            }

            day += cDay;
        } else if(cMonth - nMonth == 0) {
            day += (cDay - nDay);
        }

        System.out.println("D-" + day);
    }
}