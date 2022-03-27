// 셀프 넘버 silver5

public class Baekjoon_4673 {
    static int nonSelfNumber(int num)        // selfnumber가 아닌 수들의 리스트를 반환하는 함수.
    {
        int nonselfnumber = num;

        while(num != 0)
        {
            nonselfnumber += num%10;
            num /= 10;
        }
        
        return nonselfnumber;
    }

    public static void main(String[] args) {
        
        boolean[] nonselfnumber_array = new boolean[10001];

        for(int i=1; i<10001; i++)
        {
            int n = nonSelfNumber(i);

            if (n < 10001) 
                nonselfnumber_array[n] = true;
        }

        for(int i=1; i<10001; i++)
        {
            if (nonselfnumber_array[i] == true)  // i가 selfnumber가 아닌 경우 패스
                continue;

            System.out.println(i);
        }

    }
}