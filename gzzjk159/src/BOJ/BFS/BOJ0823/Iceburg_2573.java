package BOJ.BFS.BOJ0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Iceburg_2573 {
    static int[][] map;
    static int n,m;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int result = 0;
        int count;
        while((count=icecount())<2){
            if(count==0){
                result = 0;
                break;
            }
            melt();
            result++;
        }
        System.out.println(result);
    }
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }
    public static int icecount(){
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]!=0&&!visited[i][j]){
                    dfs(i,j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void melt(){
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]!=0){
                    q.offer(new int[]{i,j});
                    visited[i][j] =true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0||ny<0||nx>=n|| ny>=m){
                    continue;
                }
                if(!visited[nx][ny]&&map[nx][ny]==0){
                    cnt++;
                }
            }
            if(map[now[0]][now[1]]-cnt<0){
                map[now[0]][now[1]] = 0;
            }
            else{
                map[now[0]][now[1]] -= cnt;
            }
        }
    }
}
