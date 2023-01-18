package BOJ;

/*
서울의 오늘 날짜를 출력하는 프로그램을 작성하시오.

서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.

2015-01-24
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class N10699 {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        
        TimeZone time = TimeZone.getTimeZone("Asia/Seoul");
        format.setTimeZone(time);

        System.out.println(format.format(now));
    }
}
