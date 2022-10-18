package BOJ.dp.boj1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SequenceSum_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }
        int answer = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > answer) {
                answer = dp[i];
            }
        }
        System.out.println(answer);
    }
}