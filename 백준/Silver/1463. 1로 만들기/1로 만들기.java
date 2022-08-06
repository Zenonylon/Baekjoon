// 1로 만들기 silver3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] memo;
    static ArrayList<Integer> comparison = new ArrayList<Integer>();

    static void func(int num){
        for(int i=4; i<=num; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                comparison.add(memo[i/3]);
                comparison.add(memo[i/2]);
                comparison.add(memo[i-1]);
                Collections.sort(comparison);
                
                memo[i] = comparison.get(0) + 1;

                comparison.clear();
            }
            else if (i % 3 == 0) {
                comparison.add(memo[i/3]);
                comparison.add(memo[i-1]);
                Collections.sort(comparison);

                memo[i] = comparison.get(0) + 1;

                comparison.clear();
            }
            else if (i % 2 == 0) {
                comparison.add(memo[i/2]);
                comparison.add(memo[i-1]);
                Collections.sort(comparison);

                memo[i] = comparison.get(0) + 1;

                comparison.clear();
            }
            else {
                memo[i] = 1 + memo[i-1];
            } 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        
        if(input == 1) System.out.println(0);

        else if(input == 2) System.out.println(1);

        else if(input == 3) System.out.println(1);

        else {
            memo = new int[input+1];
            memo[1] = 0;
            memo[2] = 1;
            memo[3] = 1;
            
            func(input);

            System.out.println(memo[input]);
        }
    }

}
