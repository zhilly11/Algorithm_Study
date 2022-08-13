package BOJ.BFS.BOJ0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ApartmentNumber_2667 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Integer> apart = new ArrayList<>();
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==1&&!visited[i][j]){
                    bfs(i,j);
                    result++;
                }
            }
        }
        System.out.println(result);
        Collections.sort(apart);
        for (Integer i : apart) {
            System.out.println(i);
        }
    }
    public static void bfs(int x, int y){
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            map[now[0]][now[1]]=0;
            for (int i = 0; i < 4; i++) {
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx<0 || ny<0 || nx>n-1||ny>n-1){
                    continue;
                }
                if(map[nx][ny]==1&&!visited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        apart.add(count);
    }
}
