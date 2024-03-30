package BOJ;

/*
KSA의 1학년 학생들은 매일 아침 졸업을 하기 위해 아침 태권도를 해야 한다.

태권도장은 2차원 좌표평면으로 표현할 수 있고, 이때 사범님은 원점에 앉아있다. 
N명의 1학년 학생들은 1번부터 N번까지의 번호로 구분되며, i번 학생의 위치는 (Xi, Yi)이다. 
태권도 사범님은 i번 학생이 다른 학생에게 가려지지 않는 경우에만 볼 수 있다. 
즉, 원점과 (Xi, Yi)를 이어 선분을 만들었을 때, 선분 위에 위치한 다른 학생이 아무도 없을 때 사범님은 i번 학생을 볼 수 있다.

1학년 학생들은 너무 공부를 많이 하여 매우 졸리기 때문에, 사범님에게 보이는 학생들만 태권도를 열심히 한다. 
학생들의 위치 정보가 주어졌을 때, 태권도를 열심히 하는 학생들은 몇 명인지 구하시오.

첫 번째 줄에 정수 N이 주어진다.
 
i + 1번째 줄에 두 정수 Xi, Yi가 공백으로 구분되어 주어진다. (1 <= i <= N) 

태권도를 열심히 하는 학생들은 몇 명인지 출력한다.

7
1 2
2 4
-2 2
-4 4
-1 0
-3 0
2 -1

4
 */

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class N29197 {
    public static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Coordinate) {
                Coordinate coordinate = (Coordinate) o;

                if(coordinate.x == this.x && coordinate.y == this.y) return true;
                else return false;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(read.readLine());
        
        HashSet<Coordinate> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer coor = new StringTokenizer(read.readLine());

            int x = Integer.parseInt(coor.nextToken());
            int y = Integer.parseInt(coor.nextToken());

            if(x == 0) {
                set.add(new Coordinate(x, y > 0 ? 1 : -1));
                continue;
            } else if(y == 0) {
                set.add(new Coordinate(x > 0 ? 1 : -1, y));
                continue;
            }

            int gcd = gcd(Math.max(x, y), Math.min(x, y));
            set.add(new Coordinate(x / gcd, y / gcd));
        }

        System.out.println(set.size());
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}