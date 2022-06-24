import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{

    static long[] memo = new long[101];

    static void memoization() {
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
        
        for(int i=6; i<101; i++) {
            memo[i] = memo[i-5] + memo[i-1];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        memoization();

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(memo[n]);
        }

    }
}
