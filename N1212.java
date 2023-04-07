package BOJ;

/*
8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.

첫째 줄에 8진수가 주어진다. 
주어지는 수의 길이는 333,334을 넘지 않는다.

첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 
수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다.

314

11001100
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder build = new StringBuilder();

		String s = read.readLine();
		String[] b = {"000","001","010","011","100","101","110","111"};
				
		for(int i=0;i<s.length();i++) {
			int a =  s.charAt(i)-'0';

			build.append(b[a]);
		}
		
		if(s.equals("0")) System.out.println(s);
		else{
			while(build.charAt(0) == '0') build = new StringBuilder(build.substring(1));
			System.out.println(build);
		}
    }
}