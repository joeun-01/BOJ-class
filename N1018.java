package BOJ;
// 아아
import java.util.Scanner;

public class N1018 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int row = input.nextInt();
            int col = input.nextInt();
            input.nextLine();

            char[][] chess = new char[row][col];
            
            int i, j;
            for(i = 0; i < row; i++) {
                String line = input.nextLine();
                chess[i] = line.toCharArray();
            }

            // 가능한 행렬 시작점의 최대 인덱스
            int ro = row - 8;
            int co = col - 8;

            int min = 100, check = 0;

            for(i = 0; i <= ro; i ++) {  
                for(j = 0; j <= co; j++) {  
                    // 가장 맨 왼쪽 위의 체스가 흰색이라고 가정하고 8 x 8 만큼 검사
                    check = 0;

                    for(int a = i; a < i + 8; a++) {
                        for(int b = j; b < j + 8; b++) {
                            // 짝수 행인 경우 짝수 열이 같아야하고 홀수 행인 경우 홀수 열이 같아야 함
                            
                            if((a % 2 == i % 2) && (b % 2 == j % 2)) {  // 맨 왼쪽 위와 색이 같아야 함
                                if(chess[a][b] == 'B') check++;  // 색이 다르기 때문에 다시 칠해야 함
                            } else if((a % 2 != i % 2) && (b % 2 != j % 2)) {  
                                if(chess[a][b] == 'B') check++;  
                            } else {  // 색이 달라야 함
                                if(chess[a][b] == 'W') check++;  
                            }
                        }
                    } 

                    if(check < min) min = check;
                    
                    // 가장 맨 왼쪽 위의 체스가 검은색이라고 가정하고 8 x 8 만큼 검사
                    check = 0;

                    for(int a = i; a < i + 8; a++) {
                        for(int b = j; b < j + 8; b++) {
                            // 짝수 행인 경우 짝수 열이 같아야하고 홀수 행인 경우 홀수 열이 같아야 함
                            
                            if((a % 2 == i % 2) && (b % 2 == j % 2)) {  // 맨 왼쪽 위와 색이 같아야 함
                                if(chess[a][b] == 'W') check++;  // 색이 다르기 때문에 다시 칠해야 함
                            } else if((a % 2 != i % 2) && (b % 2 != j % 2)) {  
                                if(chess[a][b] == 'W') check++;  
                            } else {  // 색이 달라야 함
                                if(chess[a][b] == 'B') check++;  
                            }
                        }
                    }
                
                    if(check < min) min = check;
                }
            }

            System.out.println(min);
        } finally {
            input.close();
        }
    }
}