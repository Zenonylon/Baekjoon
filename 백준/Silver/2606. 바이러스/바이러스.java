// 바이러스 silver3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int vertices;    // 컴퓨터 수
    static int edges;   // 간선 수
    static int[][] graph;   // 네트워크
    static boolean[] visited;  // 방문한 컴퓨터 
    static int cnt = 0; // 바이러스에 걸린 컴퓨터 수

    static void dfs(int vertex) {
        for(int i=1; i<vertices+1; i++) {
            if(graph[vertex][i] == 1 && visited[i] == false) {
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertices = Integer.parseInt(br.readLine());
        edges = Integer.parseInt(br.readLine());
        
        graph = new int[vertices+1][vertices+1];
        visited = new boolean[vertices+1]; 

        for(int i=0; i<edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited[1] = true;
        dfs(1);

        System.out.println(cnt);

    }
}