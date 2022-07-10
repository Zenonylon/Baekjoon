// IOIOI silver1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());    // P1 = IOI, P2 = IOIOI ....
        int m = Integer.parseInt(br.readLine());    // str의 길이

        String str = br.readLine();
        int cnt = 0;
        int[] dp = new int[m];

        Arrays.fill(dp, 0);

        for(int i=2; i<m; i++) {
            String tmp = str.substring(i-2, i+1);
            if(tmp.equals("IOI")) {
                dp[i] = dp[i-2] + 1;
            }

            if(dp[i] >= n) cnt++;
        }
        System.out.println(cnt);
    }
}