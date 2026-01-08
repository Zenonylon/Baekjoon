import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;

    static void bfs(int r) {
        Queue<Integer> q = new LinkedList<>();
        visited[r] = true;
        q.add(r);
        order[r] = cnt++;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int next : graph.get(v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = cnt++;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점의 수
        int m = Integer.parseInt(st.nextToken());   // 간선의 수
        int r = Integer.parseInt(st.nextToken());   // 시작 정점

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        order = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 내림차순 방문을 위해 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.print(sb);

    }
}