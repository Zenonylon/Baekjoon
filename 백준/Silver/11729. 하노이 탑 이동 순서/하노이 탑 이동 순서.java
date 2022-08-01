// 하노이탑 이동순서 silver1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    
    static void hanoi(int n, int start, int mid, int end) {
        if (n==1) {
            sb.append(start + " " + end + "\n");
            cnt++;
        }

        else {
            // n-1개의 원판을 start에서 mid로 먼저 옮긴다.
            hanoi(n-1, start, end, mid);
            // 가장 아래에 있던 n번째 원판을 start에서 end로 옮긴다.
            sb.append(start + " " + end + "\n");
            cnt++;
            // mid에 있는 n-1개의 원판을 end로 옮겨준다.
            hanoi(n-1, mid, start, end);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);
        System.out.println(cnt);
        System.out.print(sb);
    }
}
