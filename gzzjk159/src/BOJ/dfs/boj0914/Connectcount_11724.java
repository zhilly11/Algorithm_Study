package BOJ.dfs.boj0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Connectcount_11724 {
    static int n,m;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        // 계산을 편하게 해주기 위해 +1해서 선언
        visited = new boolean[n+1];
        graph = new int[n+1][n+1];

        // 그래프 간선 이어주기
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        // 정답 개수를 세기위한 answer 선언 후 0으로 초기화
        int answer = 0;

        // 정점을 돌면서 방문하지 않으면 방문하고 이어진 정점 다 돌면 answer증가
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    static void dfs(int point){
        visited[point] = true;
        for (int i = 1; i <= n; i++) {
            if(!visited[i] && graph[point][i]==1){
                dfs(i);
            }
        }
    }
}