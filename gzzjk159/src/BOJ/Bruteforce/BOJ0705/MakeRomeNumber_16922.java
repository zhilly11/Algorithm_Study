package BOJ.Bruteforce.BOJ0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeRomeNumber_16922 {
    static boolean[] check = new boolean[1001];
    static int n;
    static int[] romeNum;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        romeNum = new int[]{1, 5, 10, 50};
        comb(0,0,0);
        System.out.println(answer);
    }
    public static void comb(int cnt, int start, int sum){
        if(cnt == n){
            if(!check[sum]){
                check[sum] = true;
                answer++;
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            comb(cnt+1,i, sum+romeNum[i]);
        }
    }
}
