package BOJ.Bruteforce.BOJ0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
dp 메모이제이션이랑 완전 탐색을 섞은 문제
아래는 dp를 이용해서 풀었다.
*/
public class SequenceMaxMultiple_2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] dp = new double[n+1];
        double[] num = new double[n+1];
        double answer;
        for (int i = 1; i < n; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }
        answer = num[1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(num[i],num[i]*dp[i-1]);
            answer = Math.max(answer,dp[i]);
        }
        System.out.printf("%.3f",answer);
    }
}
