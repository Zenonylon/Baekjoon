// 수열의 합 silver2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        while(true) {
            double a = (double) (n - (l*l - l)/2) / l;   // 공차가 1인 수열의 합 공식에서 첫째항 구하기

            if(a < 0 || l > 100) {
                System.out.print(-1);
                break;
            }

            else {
                if(a == (int) a) {
                    for(int i=0; i<l; i++) {
                        System.out.print((int) a + " ");
                        a++;
                    }
                    break;
                }

                else {
                    l++;
                }
            }
        }
    }
}
