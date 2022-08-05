import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // TestCase 갯수

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 원이 일치할 때
            if(x1==x2 && y1==y2 && r1==r2) 
                System.out.println(-1);

            // 두 점에서 만나는 경우
            else if((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) > (r1+r2)*(r1+r2) || (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) < (r1-r2)*(r1-r2)) 
                System.out.println(0);

            // 외접하거나 내접할 때
            else if ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) == (r1+r2)*(r1+r2) || (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2) == (r1-r2)*(r1-r2))
                System.out.println(1);

            // 그 외
            else
                System.out.println(2);
     
        }
    } 
}