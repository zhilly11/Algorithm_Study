package BOJ.dp.boj1101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leave2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n+2];
        int[] p = new int[n+2];

        String[] input;
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            p[i] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[n+2];
        int max = 0;
        for (int i = 1; i < n+2; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            if (i + t[i] < n+2) {
                dp[i + t[i]] = Math.max(dp[i+t[i]], max + p[i]);
            }
        }
        System.out.println(max);
    }
}
