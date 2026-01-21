import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());    // 친구관계 수
            parent = new int[2 * n];
            size   = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            HashMap<String, Integer> map = new HashMap<>();
            int idx = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) map.put(a, idx++);
                if (!map.containsKey(b)) map.put(b, idx++);

                int pa = map.get(a);
                int pb = map.get(b);
                union(pa, pb);

                int root = find(pa);
                sb.append(size[root]).append("\n");
            }
        }
        System.out.print(sb);
    }
}