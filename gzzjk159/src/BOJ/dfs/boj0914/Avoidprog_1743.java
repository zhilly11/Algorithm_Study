package BOJ.dfs.boj0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Avoidprog_1743 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1 ,-1};
    static int n,m;
    static int cnt ,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0])-1;
            int c = Integer.parseInt(input[1])-1;
            map[r][c] = 1;
        }

        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if(!visited[i][j] && map[i][j]==1){
                    cnt=0;
                    dfs(i, j);
                    answer = Math.max(cnt, answer);
                }
            }
        }
        System.out.println(answer);
    }
    static void dfs(int x, int y){
        cnt++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny]==1){
                dfs(nx, ny);
            }
        }
    }
}