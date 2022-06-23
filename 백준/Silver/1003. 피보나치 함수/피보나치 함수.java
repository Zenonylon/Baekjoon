// 피보나치 함수 silver3

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {

    static int[][] dp = new int[41][2];

    static void fibo(int n) {
        dp[n][0] = dp[n-1][0] + dp[n-2][0];
        dp[n][1] = dp[n-1][1] + dp[n-2][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<41; i++) {
            fibo(i);
        }

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());  

            bw.write(dp[n][0] + " " + dp[n][1] + '\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
