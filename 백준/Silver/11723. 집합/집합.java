import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {

    public static LinkedList<String> set;

    public static void add(String x) {
        if(!set.contains(x)) 
            set.add(x);
    }

    public static void remove(String x) {
        if(set.contains(x)) 
            set.remove(x);
    }

    public static String check(String x) {
        if(set.contains(x)) {
            return "1";
        }

        else {
            return "0";
        }
    }

    public static void toggle(String x) {
        if(!set.contains(x)) 
            set.add(x);

        else {
            set.remove(x);
        }
    }

    public static void all() {
        set.clear();
        for(int i=1; i<21; i++) {
            set.add(Integer.toString(i));
        }
    }

    public static void empty() {
        set.clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        set = new LinkedList<String>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch(st.nextToken()) {
                case "add":
                    add(st.nextToken());
                    break;

                case "remove":
                    remove(st.nextToken());
                    break;
                
                case "check":
                    bw.write(check(st.nextToken()) + '\n');
                    break;
                
                case "toggle":
                    toggle(st.nextToken());
                    break;
                
                case "all":
                    all();
                    break;
                
                case "empty":
                    empty();
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
