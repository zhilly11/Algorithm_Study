package BOJ.BFS.BOJ0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HideandSeek3_13549 {
    static int min = Integer.MAX_VALUE;
    static int n, k;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x] = true;
            if (node.x == k) min = Math.min(min, node.time);

            if (node.x * 2 <= max && !visited[node.x * 2]) q.offer(new Node(node.x * 2, node.time));
            if (node.x + 1 <= max && !visited[node.x + 1]) q.offer(new Node(node.x + 1, node.time + 1));
            if (node.x - 1 >= 0 && !visited[node.x - 1]) q.offer(new Node(node.x - 1, node.time + 1));
        }
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;

        }
    }
}