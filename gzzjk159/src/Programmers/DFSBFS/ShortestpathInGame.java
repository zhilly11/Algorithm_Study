package Programmers.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestpathInGame {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        bfs(maps,0,0, n, m);
        return maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1];
    }

    public void bfs(int[][] maps,int x,int y,int n,int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m){ continue; }
                if(maps[nx][ny]==1){
                    maps[nx][ny] = maps[cx][cy]+1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        ShortestpathInGame sp = new ShortestpathInGame();
        int[][] arr = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] arr2 = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(sp.solution(arr2));
    }
}
