package BOJ.BFS.BOJ0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ChessKnightMove_7562 {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] map;
        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            String[] now = br.readLine().split(" ");
            String[] goal = br.readLine().split(" ");
            bfs(map, Integer.parseInt(now[0]), Integer.parseInt(now[1]),l);
            System.out.println( map[Integer.parseInt(goal[0])][Integer.parseInt(goal[1])]-1 );
        }
    }
    public static void bfs(int[][] map, int x,int y,int l){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        map[x][y] = 1;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= l || ny >= l) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
