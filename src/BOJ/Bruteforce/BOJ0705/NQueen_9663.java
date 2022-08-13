package BOJ.Bruteforce.BOJ0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {
    static int[] board;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        position(0);
        System.out.println(answer);
    }
    //퀸이 놓여있을 때 겹치는지 확인하는 함수
    public static boolean posible(int col){
        for (int i = 0; i < col; i++) {
            if(board[col]==board[i]){
                return false;
            }
            else if(Math.abs(col - i)== Math.abs(board[col]-board[i])){
                return false;
            }
        }
        return true;
    }
    // 퀸을 배치하는 함수
    public static void position(int depth){
        if(depth == n){
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if(posible(depth)){
                position(depth+1);
            }
        }
    }
}
