package BOJ.dp.boj1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class upstair_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[2]+stair[1];
        dp[3] = Math.max(stair[1]+stair[3],stair[2]+stair[3]);
        for (int i = 4; i < n+1; i++) {
            dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
        }
        System.out.println(dp[n]);
    }
}
