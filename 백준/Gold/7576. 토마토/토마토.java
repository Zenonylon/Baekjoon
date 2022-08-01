// 토마토 gold5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    static class Space {    // 상자 속 공간
        int x;
        int y;
        int day;
 
        public Space(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int n;   // 세로 길이
    static int m;   // 가로 길이
    static int[][] box;   // 토마토 보관 상자
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void bfs() {
        Queue<Space> queue = new LinkedList<Space>();
        int day = 0;

        // queue에 토마토 좌표 넣기
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(box[i][j] == 1) 
                    queue.offer(new Space(j, i, 0));
            }
        }

        while(!queue.isEmpty()) {
            Space space = queue.poll();
            day = space.day;
 
            for(int i=0; i<4; i++) {
                int nx = space.x + dx[i];
                int ny = space.y + dy[i];
 
                if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if(box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        queue.add(new Space(nx, ny, day+1));
                    }
                }
            }
        }
 
        // 토마토가 다 익었는지 확인
        if(checkTomato())
            System.out.println(day);
        else
            System.out.println(-1);
    }

    static boolean checkTomato() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }
 
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        box = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

    }
    
}
