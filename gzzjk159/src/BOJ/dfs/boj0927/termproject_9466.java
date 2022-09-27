package BOJ.dfs.boj0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class termproject_9466 {
    static int n;
    static int[] arr;
    static int count = 0;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            count = 0;

            String[] input = br.readLine().split(" ");
            for (int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(input[j-1]);
            }

            for (int j = 1; j < n+1; j++) {
                dfs(j);
            }

            System.out.println(n - count);
        }
    }
    static void dfs(int now){
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for (int i = next; i != now; i= arr[i]) {
                    count++;
                }
            }
        }
        finished[now] = true;
    }
}
