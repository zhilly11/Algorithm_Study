package BOJ.Bruteforce.BOJ0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leave_14501 {
    static int[][] consult;
    static int n;
    static int benefit=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        consult = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            consult[i][0] = Integer.parseInt(input[0]);
            consult[i][1] = Integer.parseInt(input[1]);
        }

        dfs(0,0);
        System.out.println(benefit);
    }
    public static void dfs(int start, int sum){
        if(start>=n){
            benefit = Math.max(benefit,sum);
            return;
        }
        if(start+consult[start][0]<=n){
            dfs(start+consult[start][0], sum+consult[start][1]);
        }
        else{
            dfs(start+consult[start][0],sum);
        }
        dfs(start+1,sum);
    }
}
