package BOJ;

/*
대한민국 공군의 표어는 "대한민국을 지키는 가장 높은 힘"이다. 
하지만, 복무 일수가 1년 9개월로 현역 복무 병사들 중 가장 길다는 이유로 공군 병사들은 자조적으로 "대한민국을 지키는 가장 긴 힘"이라는 농담을 주고받곤 한다.

오늘도 "대한민국을 지키는 가장 긴 힘"이라는 농담을 주고받던 도훈이네 부대 병사들은 전역의 염원을 담은 전역일 페이퍼를 만들기로 결심했다. 
전역일 페이퍼란, 긴 종이에 병사들의 남은 복무 일수를 띄어쓰기 없이 한 줄로 나열하는 것이다. 
가령, 남은 복무 일수가 각각 124일, 631일, 2일 남은 병사들이 순서대로 전역일 페이퍼를 작성하면, 종이에는 1,246,312라는 수가 적히는 것이다. 
공군의 최대 복무 일수는 641일이기 때문에, 전역일 페이퍼에 본인의 남은 전역일을 작성한 사람들은 모두 1 이상 641 이하의 수만을 작성하였으며, 수 앞에 불필요한 0을 붙이지 않았다고 한다.

이렇게 만든 전역일 페이퍼를 보던 도훈이는, 문득 해당 전역일 페이퍼에 본인의 남은 복무 일수를 작성한 병사의 수가 몇 명인지 알고 싶어졌다. 
다만, 전역일 페이퍼에 적힌 수만 보고서는 정확한 인원수를 알 수 없었기에, 각 병사가 가능한 남은 복무 일수인 1 이상 641 이하의 수만을 작성했다는 사실을 토대로 전역일 페이퍼를 작성한 병사 수의 최솟값을 구하기로 했다. 
도훈이를 위해 전역일 페이퍼를 작성한 병사 수의 최솟값을 구해주자!

첫 번째 줄에 전역일 페이퍼에 적힌 수의 자릿수 N이 주어진다.
두 번째 줄에 전역일 페이퍼에 적힌 수를 나타내는 길이 N의 정수 S가 주어진다.
주어진 수 S가 전역일 페이퍼에 적힌 수가 될 수 있음이 보장된다.

첫 번째 줄에 전역일 페이퍼를 작성한 병사 수의 최솟값을 출력한다.

3
123

1
 */

import java.io.*;

public class N31263 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        String S = read.readLine();

        int index = N, cnt = 0;
        while(index > 0) {
            // 인덱스 범위 조정
            if(index - 3 < 0) {
                cnt++;
                break;
            }

            String numberStr = S.substring(index - 3, index);

            int zeroCnt = 0;
            if(numberStr.charAt(0) == '0' && numberStr.charAt(1) == '0') zeroCnt = 2;
            else if(numberStr.charAt(0) == '0') zeroCnt = 1;

            numberStr = numberStr.substring(zeroCnt, 3);
            int number = Integer.parseInt(numberStr);

            // System.out.println(number);

            if(number > 641) {
                cnt++;
                index = index - 2 + zeroCnt;
            } else {
                cnt++;
                index = index - 3 + zeroCnt;
            }
        }

        System.out.println(cnt);
    }
}