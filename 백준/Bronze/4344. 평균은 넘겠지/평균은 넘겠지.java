import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int n, total, count;
		double avg;
		int scores[] = new int[1000];
        StringTokenizer st;
		
		for (int i = 0; i < c; ++i) {
            st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			total = 0;
			count = 0;
			for (int j = 0; j < n; ++j) {
				scores[j] = Integer.parseInt(st.nextToken());
				total += scores[j];
			}
			avg = (double)total / n;
			
			for (int j = 0; j < n; ++j) {
				if (scores[j] > avg) {
					count++;
				}
			}
			System.out.printf("%.3f", 100.0 * count / n);
			System.out.println("%");
		}
	}
}