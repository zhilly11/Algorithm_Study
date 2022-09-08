package BOJ.BFS.BOJ0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideandSeek4_13913 {
    static int n;
    static int k;
    static int[] check = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        bfs(n,k);
        System.out.println(check[k]-1);

        Stack<Integer> s =  new Stack<>();
        int idx = k;
        while(idx!=n){
            s.push(idx);
            idx = parent[idx];
        }
        s.push(idx);

        while(!s.empty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void bfs(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        check[start] = 1;
        q.add(start);
        int next;
        while(!q.isEmpty()){
            int now =q.poll();
            for (int i = 0; i < 3; i++) {
                if(i==0){
                    next = now+1;
                }
                else if(i==1){
                    next = now-1;
                }
                else{
                    next = now*2;
                }
                if(next>=0&&next<check.length&&check[next]==0){
                    check[next] = check[now]+1;
                    parent[next] = now;
                    q.add(next);
                }
                if(check[end]!=0){
                    return;
                }
            }
        }
    }
}
