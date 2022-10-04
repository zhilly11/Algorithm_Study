package BOJ.dp.boj1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBroad_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] house = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            house[i][0] = Integer.parseInt(input[0]);
            house[i][1] = Integer.parseInt(input[1]);
            house[i][2] = Integer.parseInt(input[2]);
        }

        for (int i = 1; i < n; i++) {
            house[i][0] += Math.min(house[i-1][1], house[i-1][2]);
            house[i][1] += Math.min(house[i-1][0], house[i-1][2]);
            house[i][2] += Math.min(house[i-1][0], house[i-1][1]);
        }

        int answer = Math.min(Math.min(house[n-1][0], house[n-1][1]), house[n-1][2]);
        System.out.println(answer);
    }
}
