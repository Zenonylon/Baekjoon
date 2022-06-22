import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] Coordinate = new int[N][2];

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Coordinate[i][0] = Integer.parseInt(st.nextToken());
            Coordinate[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Coordinate, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1],o2[1]);
            } else{
                return Integer.compare(o1[0],o2[0]);
            }
        });
        
        for(int i=0; i<N; i++)
        {
            System.out.println(Coordinate[i][0] + " " + Coordinate[i][1]);
        }
        
    }
}