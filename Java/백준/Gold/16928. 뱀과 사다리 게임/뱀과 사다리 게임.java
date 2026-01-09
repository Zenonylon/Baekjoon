import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] jump = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            jump[start] = end;
        }

        int[] dist = new int[101];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int d = 1; d <= 6; d++) {
                int nx = now + d;
                if (nx > 100) continue;

                if (jump[nx] != 0) nx = jump[nx];

                if (dist[nx] == -1) {
                    dist[nx] = dist[now] + 1;
                    if (nx == 100) {
                        System.out.println(dist[100]);
                        return;
                    }
                    q.add(nx);
                }
            }
        }
    }
}