/*
연두는 프로그래밍 대회에 나갈 팀 이름을 정하려고 한다. 
미신을 믿는 연두는 이환이에게 공식을 하나 받아왔고, 이 공식을 이용해 우승할 확률이 가장 높은 팀 이름을 찾으려고 한다.

이환이가 만든 공식은 사용하려면 먼저 다음 4가지 변수의 값을 계산해야 한다.

- L = 연두의 이름과 팀 이름에서 등장하는 L의 개수
- O = 연두의 이름과 팀 이름에서 등장하는 O의 개수
- V = 연두의 이름과 팀 이름에서 등장하는 V의 개수
- E = 연두의 이름과 팀 이름에서 등장하는 E의 개수
그 다음, 위에서 구한 변수를 다음 식에 입력하면 팀 이름의 우승할 확률을 구할 수 있다.

((L+O) × (L+V) × (L+E) × (O+V) × (O+E) × (V+E)) mod 100

연두의 영어 이름과 팀 이름 후보 N개가 주어졌을 때, 우승할 확률이 가장 높은 팀 이름을 구해보자. 
확률이 가장 높은 팀이 여러가지인 경우 사전 순으로 가장 앞서는 팀 이름이 우승할 확률이 가장 높은 것이다.

첫째 줄에 연두의 영어 이름이 주어진다. 
둘째 줄에는 팀 이름 후보의 개수 N이 주어진다. 
셋째 줄부터 N개의 줄에 팀 이름이 한 줄에 하나씩 주어진다.

연두의 영어 이름과 팀 이름은 길이는 1보다 크거나 같고, 20보다 작거나 같으며, 알파벳 대문자로만 이루어져 있다. 
N은 50보다 작거나 같은 자연수이다.

첫째 줄에 우승할 확률이 가장 높은 팀 이름을 출력한다.

LOVE
3
JACOB
FRANK
DANO

FRANK
 */

import java.io.*;

public class N1296 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String name = read.readLine();
        int N = Integer.parseInt(read.readLine());

        int[] nums = new int[4];
        for(int i = 0; i < name.length(); i++) {
            switch (name.charAt(i)) {
                case 'L':
                    nums[0]++;
                    break;

                case 'O':
                    nums[1]++;
                    break;

                case 'V':
                    nums[2]++;
                    break;

                case 'E':
                    nums[3]++;
                    break;

                default:
                    break;
            } 
        }

        int maxRatio = 0;
        String maxName = "ZZZZZZZZZZZZZZZZZZZZZZZZZ";
        for(int i = 0; i < N; i++) {
            String teamName = read.readLine();
            int[] teamNums = new int[4];

            for(int j = 0; j < teamName.length(); j++) {
                switch (teamName.charAt(j)) {
                    case 'L':
                        teamNums[0]++;
                        break;
    
                    case 'O':
                        teamNums[1]++;
                        break;
    
                    case 'V':
                        teamNums[2]++;
                        break;
    
                    case 'E':
                        teamNums[3]++;
                        break;
    
                    default:
                        break;
                } 
            }

            int ratio = (((nums[0] + teamNums[0]) + (nums[1] + teamNums[1])) * ((nums[0] + teamNums[0]) + (nums[2] + teamNums[2])) * ((nums[0] + teamNums[0]) + (nums[3] + teamNums[3]))
                            * ((nums[1] + teamNums[1]) + (nums[2] + teamNums[2])) * ((nums[1] + teamNums[1]) + (nums[3] + teamNums[3]))
                            * ((nums[2] + teamNums[2]) + (nums[3] + teamNums[3]))) 
                            % 100;

            if(ratio == maxRatio) {
                if(teamName.compareTo(maxName) < 0) maxName = teamName;
            } else if(ratio > maxRatio) {
                maxRatio = ratio;
                maxName = teamName;
            }
        }

        System.out.println(maxName);
    }
}