// 회의실 배정 silver1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

@FunctionalInterface
interface ItemComparator {
	 int compare(int lhs, int rhs);
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());	// 시작시간 
			time[i][1] = Integer.parseInt(st.nextToken());	// 종료시간 
		}

        Arrays.sort(time, 
        (int[] t1, int[] t2) -> (t1[1] == t2[1]) ? t1[0] - t2[0] : t1[1] - t2[1]
        );

        int cnt = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < n; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
    }
}
