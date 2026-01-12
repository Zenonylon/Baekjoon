import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> arr = new ArrayList<>();
            int c = a % 10;                 
            int base = a % 10;

            while (true) {
                if (arr.contains(c)) break; 
                arr.add(c);
                c = (c * base) % 10;
            }

            int idx = (b - 1) % arr.size(); 
            int ans = arr.get(idx);

            System.out.println(ans == 0 ? 10 : ans);
        }
    }
}