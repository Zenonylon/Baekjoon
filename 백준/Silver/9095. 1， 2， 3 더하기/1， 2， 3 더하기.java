import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

    static int solution(int x) {
        if(x == 1)  return 1;
        if(x == 2)  return 2;
        if(x == 3)  return 4;

        return solution(x-1) + solution(x-2) + solution(x-3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    // 테스트케이스 수

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            int result = solution(num);
            System.out.println(result);
        }
    }
}
