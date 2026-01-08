import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] nx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] ny = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int l = Integer.parseInt(br.readLine());    // 체스판 한 변의 길이
            boolean[][] visited = new boolean[l][l];
            int[][] cnt = new int[l][l];

            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            Point start = new Point(sx, sy);

            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            Point end = new Point(ex, ey);

            if (start.x == end.x && start.y == end.y) {
                sb.append(0).append("\n");
                continue;
            }

            Queue<Point> q = new LinkedList<>();
            visited[start.y][start.x] = true;
            q.add(start);

            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 0; i < 8; i++) {
                    int next_x = p.x + nx[i];
                    int next_y = p.y + ny[i];

                    if (next_x < 0 || next_x >= l || next_y < 0 || next_y >= l) continue;
                    if (visited[next_y][next_x]) continue;

                    Point next = new Point(next_x, next_y);

                    visited[next_y][next_x] = true;
                    cnt[next_y][next_x] = cnt[p.y][p.x] + 1;

                    if (next.x == end.x && next.y == end.y) {
                        sb.append(cnt[next_y][next_x]).append("\n");
                        break;
                    }

                    q.add(next);
                }
            }
        }
        System.out.print(sb);
    }
}
