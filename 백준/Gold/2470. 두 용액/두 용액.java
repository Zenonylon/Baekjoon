// 두 용액 gold5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main{
    public static void quickSort(int[] data) {
		quickSort(data, 0, data.length-1);
	}
	
	public static void quickSort(int[] data, int start, int end) {
		int part2 = partition(data, start, end);
		if(start < part2 - 1)
			quickSort(data, start, part2 - 1);
		if(part2 < end)
			quickSort(data, part2, end);
	}
	
	public static int partition(int[] data, int start, int end) {
		int pivot = data[(start+end) / 2];
		while(start <= end) {
			while(data[start] < pivot) start++;
			while(data[end] > pivot) end--;
			if( start <= end ) {
				swap(data, start, end);
				start++; end--;
			}
		}	
		return start;
		
	}
		
	public static void swap(int[] data, int s1, int s2) {
		int tmp = data[s1];
		data[s1] = data[s2];
		data[s2] = tmp;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] solution = new int[n];    // 용액 농도 배열

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<n; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(solution);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = n - 1;
        int sum;
        int[] answer = new int[2];  

        while(start < end) {
            sum = solution[start] + solution[end];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);    // min = sum 했다가 틀렸던 것 같음(절댓값 아니어서). 
                answer[0] = solution[start];
                answer[1] = solution[end];
            }

            if(sum >= 0) end--;
            else start++;
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
