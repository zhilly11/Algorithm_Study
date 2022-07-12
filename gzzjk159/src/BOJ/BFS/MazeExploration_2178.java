package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MazeExploration_2178 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        check = new boolean[n][m];
        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }
    public static void bfs(int x, int y){
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(x,y));
        check[x][y] = true;
        while(!q.isEmpty()){
            pos now= q.poll();
            int cx = now.x;
            int cy = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if( nx<0 || ny<0 || nx>n-1 || ny>m-1 ){ continue; }
                if(check[nx][ny]){ continue; }
                if(map[nx][ny]==1){
                    check[nx][ny] = true;
                    map[nx][ny]= map[cx][cy]+1;
                    q.add(new pos(nx,ny));
                }
            }
        }
    }
    public static class pos{
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
