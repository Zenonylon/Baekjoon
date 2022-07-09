// 카드2 silver4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<= n; i++) {
			queue.add(i);
		}
		
		int cnt = 0;
		while(queue.size() != 1) {
			if(cnt % 2 == 0) {
				queue.remove();
				cnt++;
			}
			else {
				queue.add(queue.peek());
				queue.remove();
				cnt++;
			}
		}
		
		System.out.println(queue.peek());
		
	}

}
