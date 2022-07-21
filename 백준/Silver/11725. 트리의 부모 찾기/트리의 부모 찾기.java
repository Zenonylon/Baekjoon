import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    
    static int n;
    static LinkedList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;
    static StringTokenizer st;

    private static void dfs(int v){
        if(visited[v]){
            return;
        }

        visited[v] = true;
        for (int vv: tree[v]) {
            if(!visited[vv]){
                parents[vv] = v;
                dfs(vv);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new LinkedList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++) {
            tree[i] = new LinkedList<Integer>();
        }

        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i=1; i <=n ; i++) {
            if(!visited[i]){
                dfs(i);
            }
        }
        for (int i=2; i<=n ; i++) {
            System.out.println(parents[i]);
        }

    }
}
