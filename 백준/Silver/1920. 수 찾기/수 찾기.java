// 수찾기 silver4 
// Collections.sort()의 시간복잡도: 평균, 최악 -> O(nlog(n))
// Arrays.sort()의 시간복잡도: 평균 -> O(nlog(n)), 최악 -> O(n^2)

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    static int[] intArray;

    static int binarySearch(int key, int low, int high) {
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			if(key == intArray[mid]) {
				return mid;
			} else if(key < intArray[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1; // 탐색 실패 
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        intArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            intArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArray);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken()), 0, intArray.length - 1) == -1) sb.append("0" + "\n");
            else sb.append("1" + "\n");
        }

        System.out.println(sb);
    }
}