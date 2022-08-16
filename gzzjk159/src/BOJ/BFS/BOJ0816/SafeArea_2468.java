package BOJ.BFS.BOJ0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SafeArea_2468 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,1,-1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        n = Integer.parseInt(str);
        map = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(max<map[i][j]){
                    max = map[i][j];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < max; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k]&&(map[j][k]>i)){
                        bfs(j,k,i);
                        count++;
                    }
                }
            }
            result = Math.max(count,result);
        }
        System.out.println(result);
    }
    public static void bfs(int x, int y, int num) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx<0||ny<0||nx>n-1||ny>n-1){
                    continue;
                }
                if(!visited[nx][ny]&&(map[nx][ny]>num)){
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
