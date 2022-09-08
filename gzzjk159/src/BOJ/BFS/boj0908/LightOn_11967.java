package BOJ.BFS.boj0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LightOn_11967 {
    static int n;
    static ArrayList<point>[][] switchs;
    static boolean[][] visited;
    static boolean[][] isLight;
    static boolean[][] isMove;
    static int cnt = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        visited = new boolean[n][n];
        isLight = new boolean[n][n];
        isMove = new boolean[n][n];

        switchs = new ArrayList[n][n]; // x,y스위치로 켤 수 있는 a,b방에 대한 인접 리스트 만들기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switchs[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int x = Integer.parseInt(temp[0])-1; // (0, 0) 시작을 위해 -1
            int y = Integer.parseInt(temp[1])-1;
            int a = Integer.parseInt(temp[2])-1;
            int b = Integer.parseInt(temp[3])-1;

            switchs[x][y].add(new point(a, b));
        }

        bfs();

        System.out.println(cnt);
    }
    public static void bfs() {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(0, 0));
        visited[0][0] = isLight[0][0] = true;

        while(!queue.isEmpty()) {
            point now = queue.poll();
            int cx = now.x;
            int cy = now.y;

            // 현재 위치에서 이동할 수 있는 상하좌우 4방향 방 체크하기
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                isMove[nx][ny] = true;
            }

            // 현재 스위치가 켤 수 있는 모든 불들을 켜 봄
            for(int i = 0; i < switchs[cx][cy].size(); i++) {
                point p = switchs[cx][cy].get(i);

                if(!isLight[p.x][p.y]) { // 불이 꺼져있다면 불을 켬
                    isLight[p.x][p.y] = true;
                    cnt++;
                }

                // 이동할 수 있는 방이라면 큐에 추가
                if(isMove[p.x][p.y] && !visited[p.x][p.y]) {
                    visited[p.x][p.y] = true;
                    queue.add(new point(p.x, p.y));
                }
            }

            // 본격적으로 현재 위치에서 이동할 수 있는 방으로 이동
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 넘어가는 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= n){ continue; }
                // 이미 방문한 방, 이동할 수 없는 방, 불이 꺼진 방의 경우
                if(visited[nx][ny] || !isMove[nx][ny] || !isLight[nx][ny]){ continue; }
                visited[nx][ny] = true;
                queue.add(new point(nx, ny));
            }
        }
    }
    static class point{
        int x,y;
        point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
