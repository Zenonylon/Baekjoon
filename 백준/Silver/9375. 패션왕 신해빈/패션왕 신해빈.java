// 패션왕 신해빈 silver3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		for (int i = 0; i < T; i++) {
			
			HashMap<String, Integer> cloth = new HashMap<String, Integer>();	// 종류, 개수
			
			int N = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				st.nextToken();	// 옷 이름은 필요 없으므로 버린다.
				
				String kind = st.nextToken();	// 옷 종류 
				
				if (cloth.containsKey(kind)) {
					cloth.put(kind, cloth.get(kind) + 1);
				} 

				else {
					cloth.put(kind, 1);
				}
			}
 
			int cnt = 1;
 
			for (int val : cloth.values()) {
				cnt *= (val + 1);
			}
			
			sb.append(cnt - 1).append('\n');   // 알몸 상태 제외.
 
		}
		System.out.println(sb);
    }
}
