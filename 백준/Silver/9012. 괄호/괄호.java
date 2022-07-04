import java.io.*;
import java.util.*;

class ParentheseChecker {
    Stack<Character> pc = new Stack<>();

    String validate(String expression) {
        pc.clear();

        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '(')
                pc.add('(');
            else if (pc.empty()) {
                return "NO";
            }
            
            else {
                pc.pop();
            }  
        }
        if(pc.isEmpty())
            return "YES";
        else
            return "NO";
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ParentheseChecker pc = new ParentheseChecker();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            System.out.println(pc.validate(s));
        }
    }
}