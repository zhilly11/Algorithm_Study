package BOJ.dp.boj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leave_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+15];
        int[] t = new int[n+15];
        int[] p = new int[n+15];

        String[] input;
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        for (int i = n; i > 0; i--) {
            if (i + t[i] > n + 1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], p[i] + dp[i+t[i]]);
            }
        }
        System.out.println(dp[1]);
    }
    // 수정 필요
}