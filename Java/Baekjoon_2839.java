// 설탕배달 bronze1

import java.util.*;
import java.io.*;

public class Baekjoon_2839 {
    public static void mian(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(br.readLine());

        ArrayList<Integer> ArrayOfSum = new ArrayList<Integer>();     // 3*a + 5*b = weight를 만족하는 (a,b)의 합의 리스트 

        for(int i=0; i*3 <= weight; i++)
        {
            for (int j=0; i*3+j*5 <= weight; j++)
            {
                if(i*3 + j*5 == weight)
                    ArrayOfSum.add(Integer.valueOf(i+j));
            }
        }

        if(ArrayOfSum.isEmpty())
            System.out.println(-1);
        else
        {
            Collections.sort(ArrayOfSum);    
            System.out.println(ArrayOfSum.get(0));
        }

        br.close();
    }
}
