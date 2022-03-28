// 좌표 정렬하기 silver5

import java.io.*;
import java.util.*;

public class Baekjoon_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            X.add(Integer.parseInt(st.nextToken()));
            Y.add(Integer.parseInt(st.nextToken()));
        }

        for (int startIndex = 0; startIndex < N-1; startIndex++)
        {
            int smallestIndex = startIndex;

            for (int currentIndex = startIndex + 1; currentIndex < N ; currentIndex++)
            {
                if (X.get(smallestIndex) > X.get(currentIndex))
                {
                    smallestIndex = currentIndex;
                }

            }

            Collections.swap(X, smallestIndex, startIndex);    // 서로 위치 바꾸기
            Collections.swap(Y, smallestIndex, startIndex); 
           
        }

        for (int startIndex = 0; startIndex < N-1; startIndex++)
        {
            int smallestIndex = startIndex;

            for (int currentIndex = startIndex + 1; currentIndex < N ; currentIndex++)
            {
                if (X.get(smallestIndex) == X.get(currentIndex))
                {
                    if (Y.get(smallestIndex) > Y.get(currentIndex))
                    {
                        smallestIndex = currentIndex;
                    }
                }
            }

            Collections.swap(Y, smallestIndex, startIndex); 
           
        }
        
        
        for(int i=0; i<N; i++)
        {
            System.out.println(X.get(i) + " " + Y.get(i));
        }
        
    }
}
