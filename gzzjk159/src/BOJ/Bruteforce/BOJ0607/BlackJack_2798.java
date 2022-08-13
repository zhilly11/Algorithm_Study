package BOJ.Bruteforce.BOJ0607;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
아이디어
3중 포문으로 카드 인덱스를 지정해서 카드를 하나씩 골라서 더하고
다 더했을때 m보다 작거나 같으면 원래 있던 값과 비교해서 가장 큰값을 넣는다
*/
public class BlackJack_2798 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] card = new int[n];
        int answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int sum = card[i]+card[j]+card[k];
                    if (sum<m+1){
                        answer = Math.max(answer,sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
