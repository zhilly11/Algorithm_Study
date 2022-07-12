package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Picture_1926 {
    static int n;
    static int m;
    static int[][] pic;
    static boolean[][] check;

    static int max = 0;
    static int cnt = 0;


    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        pic = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                pic[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(pic[i][j]==1 && !check[i][j]){
                    max = Math.max(max, bfs(i,j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
    }

    public static int bfs(int x, int y){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y));
        check[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            pos now = q.poll();
            int cx = now.x;
            int cy = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if( nx<0 || ny<0 || nx>n-1 || ny>m-1 ){ continue; }
                if(check[nx][ny]) { continue; }
                if(pic[nx][ny]==1){
                    size++;
                    check[nx][ny] = true;
                    q.add(new pos(nx,ny));
                }
            }
        }
        return size;
    }

    public static class pos {
        int x;
        int y;

        public pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
