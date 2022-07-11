import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        int day = (l - d) / (u - d);
        if((l - d) % (u - d) != 0) day++;
        
        System.out.println(day);
    }
}