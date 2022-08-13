package BOJ.Bruteforce.BOJ0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedrawChessboard_1018 {
    static boolean[][] chess;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        chess = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                chess[i][j] = temp.charAt(j) == 'W';
            }
        }
        int row = n - 7;
        int col = m - 7;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }
    public static void find(int x, int y){
        int end_x = x+8;
        int end_y = y+8;

        int count = 0;
        boolean TF = chess[x][y];
        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if(chess[i][j] != TF){
                    count++;
                }
                TF = (!TF);
            }
            TF = (!TF);
        }
        count = Math.min(count, 64-count);
        min = Math.min(min,count);
    }
}
