package BOJ.BFS.BOJ0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RGcolorweakness_10026 {
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int n;
    static char[][] rgb;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rgb = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char[] c = input.toCharArray();
            System.arraycopy(c, 0, rgb[i], 0, n);
        }

        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited1[i][j]){
                    bfs(i,j);
                    answer1++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited2[i][j]){
                    cwbfs(i,j);
                    answer2++;
                }
            }
        }
        System.out.println(answer1+" "+answer2);
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        char same = rgb[x][y];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = now[0] + dx[i];
                int nexty = now[1] + dy[i];
                if(nextx<0 || nexty<0 || nextx>=n || nexty>=n){
                    continue;
                }
                if(!visited1[nextx][nexty]&&rgb[nextx][nexty]==same){
                    visited1[nextx][nexty] = true;
                    q.add(new int[]{nextx,nexty});
                }
            }
        }
    }
    public static void cwbfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        char same = rgb[x][y];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = now[0] + dx[i];
                int nexty = now[1] + dy[i];
                if(nextx<0 || nexty<0 || nextx>=n || nexty>=n){
                    continue;
                }
                if(!visited2[nextx][nexty]){
                    if(same == 'B'&& rgb[nextx][nexty]==same){
                        visited2[nextx][nexty] = true;
                        q.add(new int[]{nextx,nexty});
                    }else if(same!='B'&&(rgb[nextx][nexty]=='R'||rgb[nextx][nexty]=='G')){
                        visited2[nextx][nexty] = true;
                        q.add(new int[]{nextx, nexty});
                    }
                }
            }
        }
    }
}
