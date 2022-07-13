import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static int n;
	static int[][] graph;
	static boolean[][] visited;	 
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Integer> house;	// 단지에 속한 집의 수 세는 용도(dfs 호출 횟수 세는 용도)
	static ArrayList<Integer> cnt = new ArrayList<Integer>();
	
	static void dfs(int x, int y) {
		visited[y][x] = true;
		house.add(x);
		
        for(int i=0; i<4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < n && cy < n) {
				if (!visited[cy][cx] && graph[cy][cx] == 1) {
					dfs(cx, cy);
				}
			}
         }
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		visited = new boolean[n][n];
		
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				graph[i][j] = (int)(s.charAt(j)-'0');
			}
		}
		
		house = new ArrayList<Integer>();
		
		for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {   
                if (graph[y][x] == 1 && !visited[y][x]) {
					dfs(x, y);
					cnt.add(house.size());
					house.clear();
				  }
              }
        }
		
		Collections.sort(cnt);
		
		System.out.println(cnt.size());
		
		for(int i=0; i<cnt.size(); i++) {
			System.out.println(cnt.get(i));
		}
	}

}