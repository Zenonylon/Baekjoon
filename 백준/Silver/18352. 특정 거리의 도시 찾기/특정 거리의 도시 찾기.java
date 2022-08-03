// 특정 거리의 도시 찾기 silver2
// 다익스트라, bfs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {

    static int n, m, k, x;  // 도시 개수, 도로 개수, 요구하는 출발도시와의 거리, 출발 도시 번호
    static LinkedList<Integer>[] graph; // 인접 리스트
    static int[] dist;

    static void djk() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        dist[x] = 0;
        pq.offer(x);

        while (!pq.isEmpty()) {

			int n = pq.poll();

			for (int m : graph[n]) {

				if (dist[m] > dist[n] + 1) {
					dist[m] = dist[n] + 1;
					pq.offer(m);
				}
			}

		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n+1];
        for(int i=0; i<=n; i++)
            graph[i] = new LinkedList<Integer>();

        dist = new int[n+1];
        for (int i = 0; i <= n; i++)
			dist[i] = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        djk();
    
        // dist배열의 요소 중에서 k와 같으면 넣는다.
        ArrayList<Integer> answer = new ArrayList<>();  
        for(int i=0; i<=n; i++) {
            if(dist[i] == k) answer.add(i);
        }
        
        if (answer.size() == 0) System.out.println(-1);
        else {
            for(int i=0; i<answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

    }
}
