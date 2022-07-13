// 문자열 집합 silver3
// HashMap containsKey()의 시간복잡도는 O(1)

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<n; i++) {
			map.put(br.readLine(), 1);
		}
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			if(map.containsKey(br.readLine())) cnt++;
		}
		
		System.out.println(cnt);
	}

}