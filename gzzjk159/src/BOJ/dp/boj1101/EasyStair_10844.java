package BOJ.dp.boj1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStair_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];

        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 10; j++) {
                if (j==0) {
                    dp[i][j] = dp[i-1][1] % 1_000_000_000;
                } else if (j==9) {
                    dp[i][j] = dp[i-1][8] % 1_000_000_000;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000;
                }
            }
        }
        long answer = 0;
        for (int j = 0; j < 10; j++) {
            answer += dp[n][j];
        }
        System.out.println(answer % 1_000_000_000);
    }
}
