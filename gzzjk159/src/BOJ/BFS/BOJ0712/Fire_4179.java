package BOJ.BFS.BOJ0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Fire_4179 {
    static int r,c;
    static char[][] map;
    static Queue<int[]> fireq,personq;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        r = Integer.parseInt(temp[0]);
        c = Integer.parseInt(temp[1]);

        map = new char[r][c];
        fireq = new LinkedList<>();
        personq = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'J'){
                    personq.add(new int[] {i,j,0});
                }
                else if(map[i][j] == 'F'){
                    fireq.add(new int[] {i,j});
                }
            }
        }
        int res = -1;
        out: while(true) {
            int fSize = fireq.size();
            for(int i=0; i<fSize; i++) {
                int[] p = fireq.poll();
                fire(p[0], p[1]);
            }

            int pSize = personq.size();
            for(int i=0; i<pSize; i++) {
                int[] p = personq.poll();
                res = escape(p[0], p[1], p[2]);
                if(res != -1) break out;
            }
            if(personq.isEmpty()) break;
        }

        if(res == -1) {
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println(res);
        }
    }
    public static int escape(int x, int y, int time){
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 ||  nx>r-1 || ny>c-1) {
                return time+1;
            }

            if(map[nx][ny] == '.') {
                map[nx][ny] = 'J';
                personq.add(new int[] {nx, ny, time+1});
            }
        }
        return -1;
    }
    public static void fire(int x, int y){
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx > r-1 || ny > c-1) continue;

            if(map[nx][ny] == '.' || map[nx][ny] == 'J') {
                map[nx][ny] = 'F';
                fireq.add(new int[] {nx, ny});
            }
        }
    }
}
