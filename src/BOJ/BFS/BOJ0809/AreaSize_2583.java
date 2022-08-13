package BOJ.BFS.BOJ0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class AreaSize_2583 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int m,n,k;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        map = new int[m][n];
        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int lx = Integer.parseInt(input[0]);
            int ly = Integer.parseInt(input[1]);
            int rx = Integer.parseInt(input[2]);
            int ry = Integer.parseInt(input[3]);
            for (int y = ly; y< ry; y++) {
                for (int x = lx; x < rx; x++) {
                    map[y][x] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0 && !visited[i][j]){
                    bfs(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
        Collections.sort(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public static void bfs(int x, int y){
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx<0 || ny<0 || nx>m-1||ny>n-1){
                    continue;
                }
                if(map[nx][ny]==0&&!visited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        list.add(count);
    }
}
