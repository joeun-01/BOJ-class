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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int f_year = Integer.parseInt(st.nextToken());
		int f_month = Integer.parseInt(st.nextToken());
		int f_day = Integer.parseInt(st.nextToken());

		int dday = 0;
		// gg 체크
		if (is_gg(year, month, day, f_year, f_month, f_day)) {
			bw.write("gg");
		} else {
			dday= check_days(f_year,f_month-1,f_day) - check_days(year,month-1,day);
			bw.write("D-" + dday);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static int check_days(int year,int month,int day) {
		int[] m_day = {31,28,31,30,31,30,31,31,30,31,30,31};
		int days = 0;
		
		for(int i=0;i<year; i++) {
			days+=365;
			if(check_leap(i)==true) {
				days+=1;
			}
		}
		
		for(int i=0;i<month; i++) {
			days+=m_day[i];
			if(i==1&&check_leap(year)==true) {
				days+=1;
			}
		}
		
		days+=day;
		
		return days;
	}
	// gg체크
	public static boolean is_gg(int year, int month, int day, int f_year, int f_month, int f_day) {

		if (f_year - year > 1000) {
			return true;
		} else if (f_year - year == 1000) {
			if (f_month > month) {
				return true;
			} else if (f_month == month) {
				if (f_day >= day) {
					return true;
				}
			}
		}
		return false;
	}


	// 윤년 체크
	public static boolean check_leap(int year) {
		if (year % 4 == 0) {
            if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}