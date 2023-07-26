package BOJ;

/*
다솜이는 은진이의 옆집에 새로 이사왔다. 
다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.

다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 
한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 
다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)

첫째 줄에 다솜이의 방 번호 N이 주어진다. 
N은 1,000,000보다 작거나 같은 자연수이다.

첫째 줄에 필요한 세트의 개수를 출력한다.

9999

2
 */

import java.io.*;
import java.util.HashMap;

public class N1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String N = read.readLine();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N.length(); i++) {
            int number = Integer.parseInt(N.substring(i, i + 1));
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int max = 0, six = 0, nine = 0;
        for(int key : map.keySet()) {
            // System.out.println(key + " " + map.get(key));
            if(key == 6 || key == 9) {
                if(key == 6) six = map.get(key);
                else if(key == 9) nine = map.get(key);
            } else {
                max = Math.max(max, map.get(key));
            }
        }

        max = Math.max(max, (int) Math.ceil((six + nine) / 2d));
        System.out.println(max);
    }
}
