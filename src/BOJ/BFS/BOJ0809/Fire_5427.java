package BOJ.BFS.BOJ0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Fire_5427 {
    static int r,c;
    static char[][] map;
    static Queue<int[]> fireq,personq;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] temp = br.readLine().split(" ");
            r = Integer.parseInt(temp[0]);
            c = Integer.parseInt(temp[1]);

            map = new char[c][r];
            fireq = new LinkedList<>();
            personq = new LinkedList<>();

            for (int j = 0; j < c; j++) {
                String input = br.readLine();
                for (int k = 0; k < r; k++) {
                    map[j][k] = input.charAt(k);
                    if(map[j][k] == '@'){
                        personq.add(new int[] {j,k,0});
                    }
                    else if(map[j][k] == '*'){
                        fireq.add(new int[] {j,k});
                    }
                }
            }
            int res = -1;
            out: while(true) {
                int fSize = fireq.size();
                for(int j=0; j<fSize; j++) {
                    int[] p = fireq.poll();
                    fire(p[0], p[1]);
                }

                int pSize = personq.size();
                for(int j=0; j<pSize; j++) {
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

    }
    public static int escape(int x, int y, int time){
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 ||  nx>c-1 || ny>r-1) {
                return time+1;
            }

            if(map[nx][ny] == '.') {
                map[nx][ny] = '@';
                personq.add(new int[] {nx, ny, time+1});
            }
        }
        return -1;
    }
    public static void fire(int x, int y){
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx > c-1 || ny > r-1) continue;

            if(map[nx][ny] == '.' || map[nx][ny] == '@') {
                map[nx][ny] = '*';
                fireq.add(new int[] {nx, ny});
            }
        }
    }
}
