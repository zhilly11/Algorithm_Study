package BOJ.BFS.BOJ0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato_7569 {
    static int m,n,h;
    static int[][][] tomato;
    //좌 우 상 하 위 아래
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);
        tomato = new int[n][m][h];
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    tomato[i][j][k] = Integer.parseInt(input[j]);
                }
            }
        }
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(tomato[i][j][k]==1){
                        q.add(new int[]{i,j,k});
                    }
                }
            }
        }
        bfs();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < h; k++) {
                    if(tomato[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    if(max<tomato[i][j][k]){
                        max = tomato[i][j][k];
                    }
                }
            }
        }
        System.out.println(max-1);
    }
    public static void bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int nz = now[2] + dz[i];
                if(nx<0 || ny<0 || nz<0 || nx>n-1 || ny>m-1 ||nz>h-1){
                    continue;
                }
                if(tomato[nx][ny][nz]==0){
                    tomato[nx][ny][nz] = tomato[now[0]][now[1]][now[2]]+1;
                    q.add(new int[]{nx,ny,nz});
                }
            }
        }
    }
}
