package BOJ.BFS.BOJ0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_7576 {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<pos> q = new LinkedList<>();
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 1){
                    q.add(new pos(i,j));
                }
            }
        }
        bfs();

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]==0){
                    flag = true;
                    System.out.println(-1);
                    break;
                }
                if(max<map[i][j]){
                    max = map[i][j];
                }
            }
            if(flag){ break; }
        }
        if(!flag){
            System.out.println(max-1);
        }
    }
    public static void bfs(){
        while(!q.isEmpty()){
            pos now = q.poll();
            int cx = now.x;
            int cy = now.y;
            check[cx][cy] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if( nx<0 || ny<0 || nx>n-1 || ny>m-1 ){ continue; }
                if(check[nx][ny]){ continue; }
                if(map[nx][ny] == 0){
                    map[nx][ny] = map[cx][cy]+1;
                    check[nx][ny] = true;
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
