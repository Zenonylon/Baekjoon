import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int z, x, y;
        Point(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[h][n][m];
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Point> q = new LinkedList<>();

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (box[z][x][y] == 1) {
                        q.add(new Point(z, x, y));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 6; d++) {
                int nz = cur.z + dz[d];
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nz < 0 || nx < 0 || ny < 0 ||
                        nz >= h || nx >= n || ny >= m) continue;

                if (box[nz][nx][ny] == 0) {
                    box[nz][nx][ny] = box[cur.z][cur.x][cur.y] + 1;
                    q.add(new Point(nz, nx, ny));
                }
            }
        }

        int answer = 0;
        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (box[z][x][y] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[z][x][y]);
                }
            }
        }
        System.out.println(answer - 1);

    }
}
