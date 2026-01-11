import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int dist1 = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
                int dist2 = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);

                if (dist1 > r*r && dist2 < r*r) cnt++;
                else if (dist1 < r*r && dist2 > r*r) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}