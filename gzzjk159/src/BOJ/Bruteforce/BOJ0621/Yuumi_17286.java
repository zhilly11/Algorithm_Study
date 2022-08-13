package BOJ.Bruteforce.BOJ0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
아이디어
점을 순환하는 방법은 6가지 이다.
1. 유미 -> 1 -> 2 -> 3
2. 유미 -> 1 -> 3 -> 2
3. 유미 -> 2 -> 1 -> 3
4. 유미 -> 2 -> 3 -> 1
5. 유미 -> 3 -> 1 -> 2
6. 유미 -> 3 -> 2 -> 1
이렇게 6번을 완전 탐색하면서 돌면된다.
*/
public class Yuumi_17286 {
    static double[][] pos = new double[4][2];
    static boolean[] check = new boolean[4];
    static int [] arr = new int[4];
    static double answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                pos[i][j] = Double.parseDouble(input[j]);
            }
        }
        check[0] = true;
        arr[0] = 0;
        dfs(1,0);
        System.out.println((int)answer);
    }
    public static void dfs(int idx, int cnt){
        if(cnt == 3){
            double sum = 0;
            for (int i = 0; i<3; i++) {
                sum += Math.sqrt(Math.pow(pos[arr[i]][0]-pos[arr[i+1]][0],2)+Math.pow(pos[arr[i]][1]-pos[arr[i+1]][1],2));
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if(!check[i]){
                check[i] = true;
                arr[idx] = i;
                dfs(idx+1, cnt+1);
                check[i] = false;
            }
        }
    }
}