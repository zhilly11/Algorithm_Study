package Programmers.DFSBFS;

public class TargetNumber {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target,int start, int sum){
        if(start==numbers.length){
            if(sum==target){ answer++; }
            return;
        }
        dfs(numbers, target, start+1, sum+numbers[start]);
        dfs(numbers, target, start+1, sum-numbers[start]);
    }

    public static void main(String[] args) {
        TargetNumber sol = new TargetNumber();
        int[] numbers = new int[]{1,1,1,1,1};
        int[] numbers2 = new int[]{4,1,2,1};
        int target = 3;
        int target2 = 4;
        System.out.println(sol.solution(numbers, target));
        System.out.println(sol.solution(numbers2, target2));
    }
}
