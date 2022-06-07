package BOJ.Greedy.BOJ0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineUP_7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[n+1];
        int max = 0;

        String[] child = br.readLine().split(" ");

        for (int i = 0; i < n ; i++) {
            int k = Integer.parseInt(child[i]);
            line[k] = line[k-1] +1;
            max = Math.max(line[k], line[k-1]+1);
        }

        System.out.println(n-max);
    }
}
