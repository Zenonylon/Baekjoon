import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new LinkedList<Integer>();
        
        for(int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                stack.removeFirst();
            }

            else {
                stack.addFirst(input);
            }
        }

        int sum = 0;

        while(!stack.isEmpty()) {
            sum += stack.poll();
        }

        System.out.println(sum);
    }
}
