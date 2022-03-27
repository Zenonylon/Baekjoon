//소수 찾기 silver4

import java.io.*;
import java.util.*;

public class Baekjoon_1978 {
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;            
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens() && cnt < T ){
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) result++;
            cnt++;
        }

        System.out.println(result);

        br.close();
    }
}   
