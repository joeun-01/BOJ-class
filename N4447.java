package BOJ;

/*
비키니시티에는 초능력을 가진 수퍼 히어로들로 바글바글하다. 
스폰지밥과 패트릭은 주어진 문자열로 좋은놈과 나쁜놈을 골라내려 한다.

스폰지밥: 우와, 문자열에서 강한 힘이 느껴지는데! 근데 좋은 놈인지 나쁜 놈인지 알 길이 없네.
패트릭: 아니, 쉬운 것 같은데? 그냥 이름에서 'g'의 개수와 'b'의 개수만 세면 돼. 'g'가 더 많으면 좋은 놈. 'b'가 더 많으면 나쁜 놈. 위대하신 히어로 중의 히어로 'Algorithm Crunching Man' 을 떠올려 봐. 'g'가 2개 있고 'b'는 없지.
스폰지밥: 오, 그렇구만. 그럼 'Green Lantern' 은 좋은 놈이고 'Boba Fett' 은 나쁜 놈이네?
패트릭: 크~ 정답! 근데 'Boba Fett'이 누구야?
스폰지밥: 됐고, 'Superman'은 어떨까?
패트릭: ...그 분은 'g'랑 'b'가 같으니 중립이네.
스폰지밥: 아~ 'g'랑 'b'가 없어도 같다고 보는구나. 역시 넌 천재! 이번엔 그럼 'Batman'은 어때? 난 좋은거 같던데.
패트릭: 너 다크나이트 본 적 없지?
스폰지밥: 아 알았어 그럼 'Green Goblin'은? 무서운 악당이던데.
패트릭: 그건 'Green Goblin'에 대한 실례야. 그는 그의 과거로부터 고통받고 있다구. 사람이 말이야 내면을 봐야지. 말 안해도 알지?
스폰지밥: 하아..패트릭.. 너 좀 대단한 듯. 근데 잠깐만, 너 설마 게살버거 제조법을 훔치려 했던 'Plankton' 을 중립이라 말하고 싶은 건 아니겠지?
패트릭: 어차피 성공한 적도 없잖아.
스폰지밥: 흠, 그렇긴 해. 볼수록 착하고 사실 친구가 필요한 것 뿐 이었어. 중립 맞네.
패트릭: 좋아. 이제 하나하나 이름들을 살펴 볼까?
스폰지밥: 야 패트릭, 우리가 이걸 귀찮게 하루종일 세고 앉아있어야 겠냐? (눈치를 준다.)
패트릭: (...아!)  여태껏 우리 얘기를 엿들은 인간에게 시켜보자. 일을 잘 끝내면 게살버거 하나 사주지.
스폰지밥: 역시 패트릭! 우리 우정 변치 말자!

스폰지밥과 패트릭을 도와 히어로들이 착한지 나쁜지를 알아보자. 

첫 줄에 테스트케이스 n(n > 0)이 주어진다.
그 다음 줄부터 n개에 걸쳐 이름들이 주어지며 적어도 1개의 문자를 포함하고 25자를 넘지 않는다.
이름은 대소문자와 공백만 주어진다. 
공백은 여러 개의 단어를 가진 이름을 구분짓기 위해 사용된다.

각 줄마다 히어로의 이름과 하나의 공백을 사이로 "is" 를 출력한다.
그리고 이름의 'g'와 'b'의 개수에 따라 “GOOD”, “A BADDY”, “NEUTRAL”  중에 적절한 것을 골라 출력한다.

8
Algorithm Crunching Man
Green Lantern
Boba Fett
Superman
Batman
Green Goblin
Barney
Spider Pig

Algorithm Crunching Man is GOOD
Green Lantern is GOOD
Boba Fett is A BADDY
Superman is NEUTRAL
Batman is A BADDY
Green Goblin is GOOD
Barney is A BADDY
Spider Pig is GOOD
 */

import java.io.*;

public class N4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder build = new StringBuilder();

        int N = Integer.parseInt(read.readLine());

        for(int i = 0; i < N; i++) {
            String name = read.readLine();

            int g = 0, b = 0;
            for(int j = 0; j < name.length(); j++) {
                char letter = name.charAt(j);
                if(letter == 'G' || letter == 'g') {
                    g++;
                } else if(letter == 'B' || letter == 'b') {
                    b++;
                }
            }

            if(g == b) build.append(name + " is " + "NEUTRAL\n");
            else if(g < b) build.append(name + " is " + "A BADDY\n");
            else build.append(name + " is " + "GOOD\n");
        }

        System.out.println(build);
    }   
}