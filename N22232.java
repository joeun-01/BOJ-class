package BOJ;

/*
가희는 jo_test 폴더에 들어와 있습니다. 
가희는 jo_test에 있는 파일 N개를 아래 기준에 따라 정렬하려고 합니다.

1. 파일명 (FILENAME) 사전순으로
2/ 파일명 (FILENAME)이 같다면 가희가 설치한 OS에서 인식하는 확장자가 붙은 것이 먼저 나오게
3. 1과 2로도 순서를 결정할 수 없다면, 파일 확장자 (EXTENSION) 사전 순으로
파일 N개를 문제에서 설명하는 정렬 기준에 따라 정렬해 주세요. 
사전순의 기준은 아스키 코드 순입니다.

첫 번째 줄에 jo_test 폴더에 있는 파일 개수 N과 가희가 설치한 OS에서 인식하는 파일 확장자의 개수 M이 공백으로 구분되어 주어집니다.
2번째 줄부터 N+1번째 줄까지 FILENAME.EXTENSION 형식의 문자열이 주어집니다. 여기서 .은 온점을 의미합니다.

FILENAME은 소문자와 숫자로만, EXTENSION은 소문자로만 이루어져 있습니다.
그 다음 줄 부터 가희가 설치한 OS에서 인식하는 파일 확장자 (EXTENSION) M개가 주어집니다.

기준에 따라 정렬된 결과를 출력해 주세요.

5 3
abc.jpeg
abc.jpg
foo.yolo
bar.cpp
bar.maltise
jpg
cpp
maltise

abc.jpg
abc.jpeg
bar.cpp
bar.maltise
foo.yolo
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N22232 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int N = Integer.parseInt(stoi.nextToken());
        int M = Integer.parseInt(stoi.nextToken());

        String[] list = new String[N];
        for(int i = 0; i < N; i++) {
            list[i] = read.readLine();
        }

        HashSet<String> expend = new HashSet<>();
        for(int i = 0; i < M; i++) {
            expend.add(read.readLine());
        }

        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringTokenizer first = new StringTokenizer(o1, ".");
                String firstName = first.nextToken();
                String firstExpend = first.nextToken();

                StringTokenizer second = new StringTokenizer(o2, ".");
                String secondName = second.nextToken();
                String secondExpend = second.nextToken();

                // 이름이 같을 때 확장자를 비교
                if(firstName.equals(secondName)) {
                    // 확장자가 모두 인식이 가능하면 확장자 사전순 정렬
                    if(expend.contains(firstExpend) && expend.contains(secondExpend)) {
                        return firstExpend.compareTo(secondExpend);
                    } else if(expend.contains(firstExpend)) {
                        return -1;
                    } else if(expend.contains(secondExpend)) {
                        return 1;
                    }
                }

                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < N; i++) {
            build.append(list[i]).append("\n");
        }

        System.out.println(build);
    }
}