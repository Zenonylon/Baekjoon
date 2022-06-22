import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();   // queue로 입력받은 값을 저장한다.
        for(int i=0; i<n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        Deque<Integer> stack = new LinkedList<Integer>();
        
        
        ArrayList<Character> pushpop = new ArrayList<Character>();

        int j = 1;

        while(!queue.isEmpty()) {
            // queue의 front와 stack의 peek값이 다르면 stack에 j를 push
            if(!(queue.peek().equals(stack.peekFirst()))) {
                if(j > n) {     // j가 n을 넘었다는 것은 입력된 수열을 표현하는 것이 불가능하다는 의미.
                    System.out.println("NO");
                    break;
                }
                stack.addFirst(j);
                pushpop.add('+');
                j++;
            }


            // queue의 front와 stack의 peek값이 같으면 두 곳에서 값을 꺼낸다.
            else {
                stack.removeFirst();
                queue.remove();
                pushpop.add('-');
            }
        }

        if(queue.isEmpty()) {   // queue가 비어있다는 건 성공했다는 의미.
            for(int i=0; i<pushpop.size(); i++) {
                System.out.println(pushpop.get(i));
            }
        }

    }
}