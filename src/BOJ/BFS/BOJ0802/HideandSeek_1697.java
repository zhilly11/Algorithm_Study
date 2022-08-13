package BOJ.BFS.BOJ0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideandSeek_1697 {
    static int[] visited = new int[100001];

    public static void bfs(int n,int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;
        int next;
        while(!q.isEmpty()){
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                if(i==0){
                    next = now - 1;
                }
                else if(i==1){
                    next = now + 1;
                }
                else{
                    next = now * 2;
                }
                if(next==k){
                    System.out.println(visited[now]);
                    return;
                }
                if(next>=0 && next<visited.length && visited[next]==0) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if(n==k){
            System.out.println(0);
        }
        else{
            bfs(n,k);
        }
    }
}
