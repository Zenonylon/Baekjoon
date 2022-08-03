// 미로 탐색 silver1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Dot {  // 좌표
        int y;
        int x;
        int day;
 
        public Dot(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
    
    static int col; // 열
    static int row; // 행
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1}; 

    static void bfs() {
        Queue<Dot> queue = new LinkedList<>();
        int day = 0;
        map[0][0] = 0;
        queue.add(new Dot(0, 0, 1));

        while(!queue.isEmpty()) {
            Dot dot = queue.poll();
            day = dot.day;

            if(dot.x == row-1 && dot.y == col-1) {
                System.out.println(day);
                break;
            }
 
            for(int i=0; i<4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
 
                if(0 <= nx && nx < row && 0 <= ny && ny < col) {
                    if(map[ny][nx] == 1) {
                        map[ny][nx] = 0;
                        queue.add(new Dot(ny, nx, day+1));
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];

        for(int i=0; i<col; i++) {
            String s = br.readLine();
            for(int j=0; j<row; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

    }
}
