package BOJ;

/*
하버드 대학교의 언어학자 조지 킹슬리 지프(George Kingsley Zpif, 1902–1950)는 어떤 책에서 k번째로 많이 나온 단어의 출현 빈도는 1/k에 비례한다는 것을 발견했다.

어떤 영어 책의 본문이 주어졌을 때, n번 등장하는 단어를 모두 찾는 프로그램을 작성하시오. 
단어는 문자의 연속이다. 
단어는 문자가 아닌 것으로 구분되어 있다. 
대소문자는 구분하지 않는다. 
단어는 영어 단어 사전에 나오는 단어만 주어진다.

입력은 여러 개의 테스트 케이스로 이루어져 있다. 
각 테스트 케이스의 첫째 줄에는 n이 주어진다. 
그 다음 줄부터 "EndOfText"가 니오는 바로 전 줄까지가 책의 본문 내용이다. 
본문은 10000 단어를 넘지 않는다. 
"EndOfText"는 테스트 케이스를 구분하기 위한 단어이고, 본문에는 등장하지 않는다.

각 테스트 케이스에 대해서, n번 등장하는 단어를 사전순으로 한 줄에 하나씩 알파벳 소문자로 출력한다. 
만약, 그러한 단어가 없을 때는 "There is no such word."를 출력한다.
각 테스트 케이스의 사이에는 빈 줄을 출력해서 테스트 케이스를 구분해야 한다.

2

In practice, the difference between theory and practice is always
greater than the difference between theory and practice in theory.
	- Anonymous

Man will occasionally stumble over the truth, but most of the
time he will pick himself up and continue on.
        - W. S. L. Churchill
EndOfText
1
the the it it ate ate the Bean bean
EndOfText

between
difference
in
will

There is no such word.
 */

import java.io.*;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N4374 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<>();
        int N = 0;

        String str;
        while((str = read.readLine()) != null) {
            if(map.size() == 0) {
                N = Integer.parseInt(str);
                continue;
            }

            Pattern p = Pattern.compile("\\b\\w+\\b");	
            Matcher m = p.matcher(str);

            while (m.find()) {
                String word = m.group();

                if(word.equals("EndOfText")) {
                    int cnt = 0;
                    for(String key : map.keySet()) {
                        if(map.get(key) == N) {
                            build.append(key).append("\n");
                            cnt++;
                        }
                    }

                    if(cnt == 0) build.append("There is no such word.").append("\n");
                    // System.out.println(N + "\n" + map);
                    map.clear();
                    
                    continue;
                }

                String lower = word.toLowerCase();
                map.put(lower, map.getOrDefault(lower, 0) + 1);
            }
        }

        System.out.println(build);
    }
}