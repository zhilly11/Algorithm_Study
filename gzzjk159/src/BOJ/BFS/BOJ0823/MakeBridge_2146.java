package BOJ.BFS.BOJ0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MakeBridge_2146 {
    static int[][] map;
    static boolean[][] isVisited;
    static int N;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static int landNum = 2; //섬 번호이름
    static int answer = Integer.MAX_VALUE; //답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==1){
                    makeLand(i,j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]>1){
                    isVisited = new boolean[N][N];
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
    }
    private static void makeLand(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        isVisited[r][c] = true;
        map[r][c] = landNum;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !isVisited[r2][c2] && map[r2][c2] == 1) {
                    isVisited[r2][c2] = true;
                    map[r2][c2] = landNum;
                    queue.offer(new Point(r2, c2, 0));
                }
            }
        }
        landNum++;
    }
    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(r, c, 0));
        int currentLandNum = map[r][c];// 현재 섬 번호
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !isVisited[r2][c2] && map[r2][c2] != currentLandNum) { //방문안하고 바다 혹은 다른 섬인 경우
                    isVisited[r2][c2] = true;
                    if (map[r2][c2] == 0) { //바다
                        queue.offer(new Point(r2, c2, point.cnt + 1));
                    } else { //다른 섬
                        answer = Math.min(answer, point.cnt);
                    }
                }
            }
        }
    }
    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
