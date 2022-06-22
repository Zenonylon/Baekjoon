import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] queue;
    public static int size = 0;
    public static int front, back = 0;

    public static void push(int item) {
		queue[back] = item;
		size++;
        back = (back + 1) % queue.length;
	}
	
	public static int pop() {
		if(size == 0) {
			return -1;
		}
		else {
			int res = queue[front];
			queue[front] = -1;
			size--;
            front = (front + 1) % queue.length;
			return res;
		}
	}
	
	public static int size() {
		return size;
	}
	
	public static int empty() {
		return (size == 0) ? 1 : 0;
	}
	
	public static int front() {
		return queue[front];
	}

    public static int back() {
		return queue[(back + queue.length - 1) % queue.length];
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];
        for(int i=0; i<queue.length; i++)
            queue[i] = -1; 

        while (N > 0) 
        {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
			switch (st.nextToken()) {
			
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop":
                bw.write(pop()+"\n");  
				break;
				
			case "size":
                bw.write(size()+"\n");
				break;
				
			case "empty":
                bw.write(empty()+"\n");
				break;
				
			case "front":
                bw.write(front()+"\n");
				break;
            
            case "back":
                bw.write(back()+"\n");
				break;
		    }
        
            N--;
		}
        br.close();
        bw.flush();
        bw.close();
    }
}
