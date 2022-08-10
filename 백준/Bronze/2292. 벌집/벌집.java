import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int n = 1;
		
		if (A == 1) {
			System.out.print(n);
		}
		
		else {
			while (true) {
				if (A <= n*(12+(n-1)*6)/2 + 1)  //등차수열의 합 공식 참조 (첫째항=7, 공차=6, 항의 개수=n)
                {
					break;
				}
				
				else {
					n++;
				}
			}
			System.out.print(n+1);

		   }
		}
		
}
