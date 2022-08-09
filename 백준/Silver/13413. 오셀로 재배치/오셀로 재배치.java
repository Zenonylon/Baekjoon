// 오셀로 재배치 silver4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int r_white = 0;
            int r_black = 0;
            int len = Integer.parseInt(br.readLine());

            String arr = br.readLine();
            String des = br.readLine();
            
            for(int j=0; j<len; j++) {
                if(arr.charAt(j) != des.charAt(j)) {
                    if(arr.charAt(j) == 'W') r_black++;
                    else r_white++;
                } 
            }

            if(r_black >= r_white) System.out.println(r_black); 
            else System.out.println(r_white);

        }
        
    }
}
