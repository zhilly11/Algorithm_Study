package BOJ.Bruteforce.BOJ0607;
import java.io.*;
import java.util.*;

public class DrawArrow_15970 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int pos,color;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pos = Integer.parseInt(input[0]);
            color = Integer.parseInt(input[1]);

            if(map.containsKey(color)){
                map.get(color).add(pos);
            }
            else{
                map.put(color, new ArrayList<>());
                map.get(color).add(pos);
            }
        }

        int answer = 0;

        Set<Integer> keys = map.keySet();

        for (int key : keys) {
            ArrayList<Integer> arr = map.get(key);
            arr.sort(null);
            int dis = 0;
            int l,r;
            for (int i = 0; i < arr.size(); i++) {
                if(i==0){
                    dis = arr.get(i+1)-arr.get(i);
                }
                else if(i== arr.size()-1){
                    dis = arr.get(i)-arr.get(i-1);
                }
                else{
                    l = arr.get(i)- arr.get(i-1);
                    r = arr.get(i+1)-arr.get(i);
                    dis = Math.min(l,r);
                }
                answer += dis;
            }
        }
        System.out.println(answer);
    }
}
