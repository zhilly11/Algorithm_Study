package BOJ.dfs.boj0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorWeakness_10026 {
    static int n;
    static int cnt = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    rgb(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt+" ");
        cnt = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='G'){
                    map[i][j]='R';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    rgb(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static void rgb(int x, int y){
        char color = map[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx<0 || ny<0 || nx >= n || ny >= n) { continue; }
            if (map[nx][ny]==color && !visited[nx][ny]) {
                rgb(nx, ny);
            }
        }
    }
}
