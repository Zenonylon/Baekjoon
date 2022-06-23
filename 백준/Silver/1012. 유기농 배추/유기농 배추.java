// 유기농 배추 silver2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    static int N, M, K;
    static int[][] graph;
    static boolean[][] visit;
    static int cnt; // 필요한 지렁이 수
    static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };


    static void dfs(int x, int y) {
		visit[y][x] = true;

        for(int i=0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cy][cx] && graph[cy][cx] == 1) {
					dfs(cx, cy);
				}
			}
        }
	}

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 갯수

        for(int i=0; i<T; i++) {
        
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());   // 가로 길이
            N = Integer.parseInt(st.nextToken());   // 세로 길이
            K = Integer.parseInt(st.nextToken());   // 배추 위치의 갯수

            graph = new int[N][M];
            visit = new boolean[N][M];
            cnt = 0;

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            for(int y=0; y<N; y++) {
                for(int x=0; x<M; x++) {   
                    if (graph[y][x] == 1 && !visit[y][x]) {
						dfs(x, y);
						cnt++;
					}

                }
            }

            System.out.println(cnt);
        }
    }   
}
