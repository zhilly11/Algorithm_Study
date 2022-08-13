package Programmers.DFSBFS;

public class Network {
    static int answer = 0;
    static boolean[] check;
    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!check[i]){
                dfs(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
    public void dfs(int n, int[][] computers,int idx){
        check[idx] = true;
        for (int i = 0; i < n; i++) {
            if(idx!=i && !check[i] &&computers[idx][i]==1){
                dfs(n,computers,i);
            }
        }
    }
    public static void main(String[] args) {
        Network s = new Network();
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}