// 1. List를 toArray 메서드에 파라메터로 넘어가는 배열 객체의 size만큼의 배열로 전환한다.
// 2. 단, 해당 List size가 인자로 넘어가는 배열 객체의 size보다 클때, 해당 List의 size로 배열이 만들어진다.
// 3. 반대로 해당 List size가 인자로 넘어가는 배열객체의 size보다 작을때는, 인자로 넘어가는 배열객체의 size로 배열이 만들어진다.
import java.io.*;
import java.util.*;

public class Baekjoon_1764 {
    public static void main(String[] args) throws IOException {
       /*
        Scanner sc = new Scanner(System.in);

        int cnt = 0;  // 듣지도 보지도 못한 사람

        int n, m;
        n = sc.nextInt();
		m = sc.nextInt();
        sc.nextLine();

        String[] NotHear = new String[n];
        String[] NotSee = new String[m];
        String[] Both = new String[cnt];
        List<String> list = new ArrayList<>(Arrays.asList(Both));

        for(int i=0; i<n; i++) {
            NotHear[i] = sc.nextLine();
        }

        for(int j=0; j<m; j++) {
            NotSee[j] = sc.nextLine();
        }

        for(int i=0; i<n ; i++) {
            for(int j = 0; j<m; j++) {
                if(NotHear[i].equals(NotSee[j])) {
                    cnt++;
                    list.add(NotHear[i]);    
        
                }
            }
        }

        String[] newArr = list.toArray(new String[0]); 

        Arrays.sort(newArr);

        System.out.println(cnt);
        for(int k=0; k<cnt; k++) {
            System.out.println(newArr[k]);
        } 
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt( st.nextToken() );
        int m = Integer.parseInt( st.nextToken() );
        int cnt = 0;

        HashSet<String> NotHear = new HashSet<>();
        ArrayList<String> Both = new ArrayList<>();

        for(int i =0; i < n; i++) {
            String NotHearStr = br.readLine();
            NotHear.add(NotHearStr);
        }

        for (int i = 0; i < m; i++) { // 보지도 못할 문자열이 듣지도 못했던 HashSet에 들어있는지 확인
			String NotSeeStr = br.readLine();
			if (NotHear.contains(NotSeeStr)) {
				cnt++;
				Both.add(NotSeeStr);
			}
		}

        Collections.sort(Both);

        System.out.println(cnt);       // 왜 bw.write(cnt); or bw.write(Both.size());는 안되는가????
        for(int i=0; i < Both.size(); i++) {
            bw.write(Both.get(i));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
