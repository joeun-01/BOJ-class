package BOJ;

/*
2019년 1학기가 시작되고 많은 사람을 만나며 밥과 술에 탕진을 해버린 영기는 2학기에 탕진할 돈을 마련하기 위해 중앙대 근처의 고급 레스토랑, "정식당"에서 알바를 하게 되었다.
정식당의 사장 정우는 새로 들어온 알바생 영기를 위해 정식당만의 특별한 음식 주문법을 알려주려고 한다.

정식당에는 다양한 메뉴들이 있지만 크게 3가지로 나눌 수 있는데 A개의 "일반메뉴", B개의 "특별메뉴", C개의 "서비스메뉴"로 나뉘어져 있다. 
일반메뉴는 자유롭게 주문할 수 있으나 특별메뉴와 서비스메뉴는 주문할 때 다음의 제약이 있다.

- 특별메뉴는 일반메뉴에서 총 20,000원 이상을 주문해야 주문할 수 있다.
- 서비스메뉴는 일반메뉴와 특별메뉴에서 총 50,000원 이상을 주문해야 주문할 수 있다.
- 서비스메뉴는 단 하나만 주문할 수 있다.
다양한 메뉴와 특별한 메뉴 주문법에 영기는 알바를 하면서 혼돈이 오기 시작했다. 
받아서는 안될 주문을 받기도 하며 사장님에게 된통 혼나기도 하며 심지어는 자기 발에 걸려 넘어지기까지 했다.

가게를 찾아온 손님들이 주문하는 것이 옳은 주문인지 아닌지 헷갈려하는 영기는 우리에게 도움을 요청했다. 
영기가 주문을 잘 받아올 수 있도록 우리가 도와주자.

첫째 줄에 50,000 이하의 양의 정수 A, B, C가 공백을 두고 주어진다.

두번째 줄부터 A줄에 걸쳐 일반메뉴의 이름과 가격이 공백을 두고 주어진다. 
그 다음 B줄에 걸쳐 특별메뉴의 이름과 가격이 공백을 두고 주어진다. 그 다음 C줄에 걸쳐 서비스메뉴의 이름이 주어진다.

그 다음 줄에서 손님이 주문하는 음식의 수를 나타내는 150,000 이하의 자연수 N이 주어진다.

그 다음 N줄에 걸쳐 손님이 주문하는 음식의 이름들이 주어진다. 
같은 음식을 여러번 주문할 수도 있으며 메뉴에 있는 음식만 주문한다.

일반메뉴와 스페셜메뉴의 가격은 1,000,000 이하의 양의 정수이며 메뉴의 이름은 20자 이하의 알파벳 소문자로만 이루어져 있으며 일반메뉴, 특별메뉴, 그리고 서비스메뉴들의 이름은 모두 다르다

영기가 받은 주문이 옳은 주문이면 "Okay"를, 그렇지 않은 주문이라면 "No"를 출력하자. 따옴표는 출력하지 않는다.

3 2 3
noodle 10000
tteokbokki 5000
sundae 7000
cutlet 12000
friedrice 8000
dumpling
potatochips
fishcake
6
noodle
noodle
cutlet
friedrice
cutlet
potatochips

Okay
 */

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class N17479 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stoi = new StringTokenizer(read.readLine());
        int A = Integer.parseInt(stoi.nextToken());
        int B = Integer.parseInt(stoi.nextToken());
        int C = Integer.parseInt(stoi.nextToken());

        HashMap<String, Integer> generalFoods = new HashMap<>();
        for(int i = 0; i < A; i++) {
            StringTokenizer menu = new StringTokenizer(read.readLine());
            String food = menu.nextToken();
            int price = Integer.parseInt(menu.nextToken()); 

            generalFoods.put(food, price);
        }

        HashMap<String, Integer> specialFoods = new HashMap<>();
        for(int i = 0; i < B; i++) {
            StringTokenizer menu = new StringTokenizer(read.readLine());
            String specialFood = menu.nextToken();
            int price = Integer.parseInt(menu.nextToken()); 

            specialFoods.put(specialFood, price);
        }

        HashSet<String> serviceFoods = new HashSet<>();
        for(int i = 0; i < C; i++) {
            String serviceFood = read.readLine();

            serviceFoods.add(serviceFood);
        }

        int N = Integer.parseInt(read.readLine());

        long generalPrice = 0, specialPrice = 0;
        boolean service = false, good = true;
        for(int i = 0; i < N; i++) {
            String order = read.readLine();
            if(generalFoods.containsKey(order)) {
                generalPrice += generalFoods.get(order);
            } else if(specialFoods.containsKey(order)) {
                specialPrice += specialFoods.get(order);
            } else if(serviceFoods.contains(order)) {
                if(service) good = false;
                else service = true;
            }
        }

        if(!good) {
            System.out.println("No");
            System.exit(0);
        }

        if(service && (generalPrice + specialPrice < 50000)) good = false;
        if(specialPrice > 0 && generalPrice < 20000) good = false;

        if(good) System.out.println("Okay");
        else System.out.println("No");
    }
}

// 3 2 3
// noodle 10000
// tteokbokki 5000
// sundae 7000
// cutlet 12000
// friedrice 8000
// dumpling
// potatochips
// fishcake
// 7
// cutlet
// noodle
// noodle
// friedrice
// cutlet
// potatochips
// fishcake

