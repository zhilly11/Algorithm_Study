package Programmers.DFSBFS;
import java.util.*;

public class WordChange {
    boolean[] visited;
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public void dfs(String begin, String target, String[] words, int depth){
        if(Objects.equals(begin, target)){
            answer = depth;
        }
        for (int i = 0; i < words.length; i++) {
            if(Wordcheck(begin,words[i])==1 && !visited[i]){
                visited[i] = true;
                dfs(words[i], target, words,depth+1);
                visited[i] = false;
            }
        }
    }

    public int Wordcheck(String one, String two){
        int cnt = 0;
        for (int i = 0; i < one.length(); i++) {
            if(one.charAt(i)!=two.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        WordChange wc = new WordChange();
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";
        String[] words2 = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(wc.solution(begin,target,words2));
    }
}
