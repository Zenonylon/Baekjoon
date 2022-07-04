import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static char[][] square;
    
    public static void makeStar(int n, int x, int y) {
        if(n==1) {
            square[x][y] = '*';
            return;
        }
        
        int unit = n/3;
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==1 && j==1)
                    continue;
                else
                    makeStar(unit, x+(unit*i), y+(unit*j));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();    // 3의 거듭제곱수만 입력 가능
        
        square = new char[N][N];
        
        for(int i=0; i<N; i++) {
            Arrays.fill(square[i], ' ');
        }
        makeStar(N, 0, 0);
        for(int i=0; i<N; i++) {
            System.out.println(square[i]);
        }
    }
}