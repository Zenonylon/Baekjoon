// 수 이어 쓰기 1 silver4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int total = 0;

        int cnt = String.valueOf(n).length();

        String std = "0";
        String std2 = "9";

        for(int i=0; i<cnt-1; i++) std = std.concat("9");
        for(int i=0; i<cnt-2; i++) std2 = std2.concat("0");

        while(cnt != 0) {
            if(cnt == String.valueOf(n).length()) total += cnt * (n - Integer.parseInt(std));

            else {
                total += cnt * Integer.parseInt(std2);
                if(std2 != "9") std2 = std2.substring(0, std2.length()-1);
            }

            cnt--;
        }

        System.out.println(total);
    }
}
