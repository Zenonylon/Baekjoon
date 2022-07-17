// 참외밭 silver3
// 본인은 좌표값을 저장하는 방식으로 풂.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] ewsn = new int[5];
        Arrays.fill(ewsn, 0);

        int x = 0;
        int y = 0;

        // 시작점 (0,0) 저장
        ArrayList<Integer> arrX = new ArrayList<Integer>();
        arrX.add(x);
        ArrayList<Integer> arrY = new ArrayList<Integer>();
        arrY.add(y);

        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 중복값은 허용X
            switch(Integer.parseInt(st.nextToken())) {
                case 1: 
                    ewsn[1]++;
                    x += Integer.parseInt(st.nextToken());
                    if(!arrX.contains(x)) arrX.add(x);
                    break;
                
                case 2:
                    ewsn[2]++;
                    x -= Integer.parseInt(st.nextToken());
                    if(!arrX.contains(x)) arrX.add(x);
                    break;
                
                case 3:
                    ewsn[3]++;
                    y -= Integer.parseInt(st.nextToken());
                    if(!arrY.contains(y)) arrY.add(y);
                    break;
                
                case 4:
                    ewsn[4]++;
                    y += Integer.parseInt(st.nextToken());
                    if(!arrY.contains(y)) arrY.add(y);
                    break;
            }
        }

        // 각각 정렬
        Collections.sort(arrX); 
        Collections.sort(arrY);

        int S = (arrX.get(2) - arrX.get(0)) * (arrY.get(2) - arrY.get(0));
        
        if(ewsn[2] == 1 && ewsn[3] == 1) {
            S -= (arrX.get(2) - arrX.get(1)) * (arrY.get(1) - arrY.get(0));
        }

        else if(ewsn[1] == 1 && ewsn[3] == 1) {
            S -= (arrX.get(2) - arrX.get(1)) * (arrY.get(2) - arrY.get(1));
        }

        else if(ewsn[2] == 1 && ewsn[4] == 1) {
            S -= (arrX.get(1) - arrX.get(0)) * (arrY.get(1) - arrY.get(0));
        }

        else if(ewsn[1] == 1 && ewsn[4] == 1) {
            S -= (arrX.get(1) - arrX.get(0)) * (arrY.get(2) - arrY.get(1));
        }

        System.out.println(S * K);
    }
}
