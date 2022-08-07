import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] arr;
	static boolean[] visit;
	
	static void bt(int k) {
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visit[i]) {
				arr[k] = i;
				visit[i] = true;
				bt(k+1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		visit = new boolean[n+1];
		
		bt(0);
	}
}