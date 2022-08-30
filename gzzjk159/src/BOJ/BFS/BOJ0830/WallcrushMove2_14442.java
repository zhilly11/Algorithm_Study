package BOJ.BFS.BOJ0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class WallcrushMove2_14442 {
    static int n,m,k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        map = new int[n][m];
        visited = new boolean[n][m][k+1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }
        bfs();
    }
    public static void bfs(){
        Queue<info> q = new LinkedList<>();
        q.offer(new info(0,0,1,0));
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            info temp = q.poll();
            if(temp.x==n-1 && temp.y==m-1){
                System.out.println(temp.dis);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int breakwall = temp.wall;
                int count = temp.dis;
                if(nx >=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny]==1){
                        if(breakwall<k && !visited[nx][ny][breakwall+1]){
                            visited[nx][ny][breakwall+1] = true;
                            q.offer(new info(nx,ny,count+1,breakwall+1));
                        }
                    }
                    else{
                        if(!visited[nx][ny][breakwall]){
                            visited[nx][ny][breakwall] = true;
                            q.offer(new info(nx,ny,count+1,breakwall));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static class info{
        int x;
        int y;
        int dis;
        int wall;
        public info(int x, int y, int dis, int wall){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.wall = wall;
        }
    }
}
