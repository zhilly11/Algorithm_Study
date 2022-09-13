package BOJ.dfs.boj0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Organic_Cbbage_1012 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] map;
        boolean[][] visited;
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);

            map = new int[n][m];
            visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[1]);
                int y = Integer.parseInt(input[0]);
                // 입력 받고 map[x][y] = 1로 만들어서 배추 있다고 표시
                map[x][y] = 1;
            }

            int answer = 0;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(!visited[j][l] && map[j][l]==1){
                        dfs(map, visited, j, l, n, m);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static void dfs(int[][] map, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m){
                continue;
            }
            if(!visited[nx][ny] && map[nx][ny]==1){
                dfs(map, visited, nx, ny, n, m);
            }
        }
    }
}