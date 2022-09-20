package BOJ.dfs.boj0920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Area_2583 {
    static int m;
    static int n;
    static int k;
    static int cnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int lx = Integer.parseInt(input[0]);
            int ly = Integer.parseInt(input[1]);
            int rx = Integer.parseInt(input[2]);
            int ry = Integer.parseInt(input[3]);

            for (int j = ly; j < ry; j++) {
                for (int l = lx; l < rx; l++) {
                    map[j][l] = 1;
                }
            }
        }
        int result = 0;
        ArrayList<Integer> area = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    result++;
                    area.add(cnt);
                    cnt=0;
                }
            }
        }
        Collections.sort(area);

        System.out.println(result);
        for (int num : area) {
            System.out.print(num+" ");
        }
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx >= m || ny >= n){ continue; }
            if(map[nx][ny]==0 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}
