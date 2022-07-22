// dfs와 bfs silver2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    static int n; // 정점 갯수
    static int m; // 간선 갯수
    static int start; // 시작 정점
    static int[][] edges;
    static boolean[] visited;
    static StringTokenizer st;

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        
        for(int i = 1; i <= n; i++) {
          if(edges[start][i] == 1 && visited[i] == false) {
            dfs(i);
          }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");
        
        while(!queue.isEmpty()) {
          int temp = queue.poll();
          
          for(int i = 1; i <= n; i++) {
            if(edges[temp][i] == 1 && visited[i] == false) {
              queue.offer(i);
              visited[i] = true;
              System.out.print(i + " ");
            }
          }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        edges = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges[a][b] = 1;
            edges[b][a] = 1;
        }

        dfs(start);

        Arrays.fill(visited, false);
        System.out.println();

        bfs(start);

    }
}
