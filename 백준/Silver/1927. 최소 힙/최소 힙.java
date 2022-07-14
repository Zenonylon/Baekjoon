// 최소 힙 silver2

// 우선순위 큐 이용
/* 
----------- Priority Queue remove ----------

  첫번째 값을 반환하고 제거 비어있다면 null
  priorityQueueLowest.poll();

  첫번째 값 제거 비어있다면 예외 발생
  priorityQueueLowest.remove(); 

  첫번째 값을 반환만 하고 제거 하지는 않는다.
  큐가 비어있다면 null을 반환
  priorityQueueLowest.peek();

  첫번째 값을 반환만 하고 제거 하지는 않는다.
  큐가 비어있다면 예외 발생
  priorityQueueLowest.element();

  초기화
  priorityQueueLowest.clear();      
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pql = new PriorityQueue<Integer>();

        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pql.isEmpty()) System.out.println(0);
                
                else System.out.println(pql.poll());
            }

            else pql.add(input);
            
        }
    }
}
