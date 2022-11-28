package BOJ;
/*
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. 
+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 
어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 
수빈이가 지금 보고 있는 채널은 100번이다.

첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  
둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 
고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.

5457
3
6 7 8

6
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException; 

public class N1107 {
    static ArrayList<Integer> button = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();
        
        int channel = Integer.parseInt(read.readLine());
        int num = Integer.parseInt(read.readLine());

        if(num > 0) {
            StringTokenizer token = new StringTokenizer(read.readLine());

            for(int i = 0; i < num; i++) {
                button.add(Integer.parseInt(token.nextToken()));
            }
        }
        
        if(channel == 100) build.append(0);  // 100은 이동할 필요가 없음
        else {
            String channelStr = Integer.toString(channel);

            if(Math.abs(channel - 100) <= channelStr.length()) {
                build.append(Math.abs(channel - 100));
            } else {
                boolean pos = true;

                for(int i = 0; i < channelStr.length(); i++) {
                    // 고장난 버튼이 없으면 그냥 누르면 됨
                    int number = Integer.parseInt(channelStr.substring(i, i + 1));
                    
                    if(button.contains(number)) {
                        pos = false;
                        break;
                    }
                }   

                if(pos) build.append(channelStr.length());
                else {
                    // 고장난 버튼이 있는 경우 모든 경우의 수를 확인
                    int min = Math.abs(channel - 100);  // +, - 버튼만 사용해서 이동하는 경우
                    for(int i = 0; i <= 1000000; i++) {
                        int possible = number(i);

                        if(possible != 0) {  // 숫자가 가능한 경우
                            int press = Math.abs(channel - i);  // +, - 버튼을 누르는 경우

                            // 버튼만 사용하는 경우와 숫자를 누르고 +, -로 조정하는 경우를 비교
                            // 그 다음부터는 그냥 후자로 min 값 비교
                            min = Math.min(min, possible + press);
                        }                        
                    }
                    
                    build.append(min);
                }
            }
        }

        System.out.println(build);
    }   

    public static int number(int channel) {
        int length = 0;

        while(true) {
            if(channel == 0) {
                // 0인 경우는 2가지 경우의 수만 계산하면 됨
                if(button.contains(0)) return 0;
                else return 1;
            } else {
                while(true) {
                    // 뒤에부터 해당 자릿수의 숫자가 고장났는지 확인
                    if(button.contains(channel % 10)) return 0;
                    
                    // 고장나지 않았으면 length++, 해당 자릿수 제외
                    length++;
                    if(channel < 10) return length;  // 다 검사했으면 break

                    channel = channel / 10;
                }
            }
        }
    }
}
