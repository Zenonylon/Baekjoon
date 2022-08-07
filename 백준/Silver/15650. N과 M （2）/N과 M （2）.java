// n과 m(2) silver3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static  int[] arr;

    static void dfs(int num, int depth) {

        if (depth == m) {
			for (int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
            return;
		}
        
		for (int i = num; i <= n; i++) {
 
			arr[depth] = i;
			dfs(i + 1, depth + 1);
 
		}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);
    }
}
