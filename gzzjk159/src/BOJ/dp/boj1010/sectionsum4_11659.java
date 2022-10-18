package BOJ.dp.boj1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sectionsum4_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(input[i]);
        }
        dp[1] = arr[1];
        for (int i = 1; i < n; i++) {
            dp[i+1] = arr[i+1]+dp[i];
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0])-1;
            int b = Integer.parseInt(input[1]);

            System.out.println(dp[b]-dp[a]);
        }
    }
}