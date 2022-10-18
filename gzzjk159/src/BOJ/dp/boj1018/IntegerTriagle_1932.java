package BOJ.dp.boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerTriagle_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                dp[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (i==0) {     // 0행은 위가 없으므로 건너뛴다.
                continue;
            }
            for (int j = 0; j < i+1; j++) {
                if (j==0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j==i) {
                    dp[i][j] += dp[i-1][j-1];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        int answer = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            if(dp[n-1][i]> answer) {
                answer = dp[n-1][i];
            }
        }
        System.out.println(answer);
    }
}