package BOJ.dfs.boj0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SafeArea_2468 {
    static int n;
    static int[][] area;
    static int max = 0;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(input[j]);
                if( max < area[i][j]){
                    max = area[i][j];
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < max; i++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && (area[j][k] > i)){
                        dfs(j,k,i);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int rain) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>n-1 || ny>n-1){
                continue;
            }
            if(!visited[nx][ny] && area[nx][ny] > rain){
                dfs(nx, ny, rain);
            }
        }
    }
}