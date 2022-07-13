// 연결 요소의 개수 silver2
// dfs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class GraphMatrix {
    int vertex;   // 정점의 갯수
    int[][] graph;
    boolean[] visited;

    GraphMatrix(int vertex) {
        this.vertex = vertex;
		this.graph = new int[1001][1001];
		this.visited = new boolean[1001];
		Arrays.fill(visited, false); // visited를 false로 초기화
	}

    void add(int v1, int v2) {
        // 무방향 그래프이므로
		this.graph[v1][v2] = 1;
		this.graph[v2][v1] = 1;
	}

    void dfs(int index) {
        if(this.visited[index] == false) {
            this.visited[index] = true;
		    for(int i=1; i<=this.vertex; i++) {
			    if(this.graph[index][i] == 1 && this.visited[i] == false) dfs(i);
		    }
        }
	}
}

public class Main {

    static int n;   // 정점의 개수
    static int m;   // 간선의 개수
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        GraphMatrix g = new GraphMatrix(n);

    
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            g.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=n; i++) {
            if(g.visited[i] == false) {
                g.dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
