package BOJ.dfs.boj0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ApartmentNumber_2667 {
    static int n;
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        int result = 0;
        ArrayList<Integer> apart = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1 && !visited[i][j]) {
                    dfs(i, j);
                    result++;
                    apart.add(cnt);
                    cnt=0;
                }
            }
        }
        Collections.sort(apart);

        System.out.println(result);
        for (int num : apart) {
            System.out.println(num);
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx >= n || ny >= n){ continue; }
            if(map[nx][ny]==1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}
