package BOJ.BFS.BOJ0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class OrganicNapaCabbage_1012 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int k = Integer.parseInt(input[2]);
            int[][] cab  = new int[n][m];
            boolean[][] check = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                cab[y][x] = 1;
            }
            int answer = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if(cab[j][l]==1&&!check[j][l]){
                        bfs(j,l, cab, check);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static void bfs(int x, int y, int[][] cab, boolean[][] check){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        check[x][y] = true;
        int ox = cab.length;
        int oy = cab[0].length;
        while(!q.isEmpty()){
            int[] next = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = next[0] + dx[i];
                int ny = next[1] + dy[i];
                if(nx<0 || ny<0 || nx>=ox || ny>=oy){
                    continue;
                }
                if(!check[nx][ny]&&cab[nx][ny]==1){
                    check[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}
