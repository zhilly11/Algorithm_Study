package BOJ.dp.boj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeone2_12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];
        int[] before = new int[n+2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1]+1;
            before[i] = i-1;
            if (i%2 == 0 && dp[i/2]+1 < dp[i]) {
                dp[i] = dp[i/2]+1;
                before[i] = i/2;
            }
            if (i%3 == 0 && dp[i/3]+1 < dp[i]) {
                dp[i] = dp[i/3]+1;
                before[i] = i/3;
            }
        }
        System.out.println(dp[n]);
        int index = n;
        for (int i = 0; i <= dp[n]; i++) {
            System.out.print(index + " ");
            index = before[index];
        }
    }
}