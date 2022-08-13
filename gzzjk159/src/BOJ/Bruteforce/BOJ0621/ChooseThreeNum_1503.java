package BOJ.Bruteforce.BOJ0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
아이디어
x,y,z는 중복이 안된다는 말이 없다. 그렇기 때문에 삼중 포문으로 하나씩 늘리면서 최솟값을 찾으면 된다.
다만 x,y,z는 s를 제외한 자연수 즉 1000을 넘을 수 있기 때문에 이 점을 주의해서 풀어야한다.
*/
public class ChooseThreeNum_1503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        boolean[] check = new boolean[1002];
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x,y,z;
        int answer = Integer.MAX_VALUE;

        if(m!=0){
            input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                check[Integer.parseInt(input[i])] = true;
            }
        }

        for (int i = 1; i < 1002; i++) {
            if(check[i]){
                continue;
            }
            x = i;
            for (int j = i; j < 1002; j++) {
                if(check[j]){
                    continue;
                }
                y = j;
                for (int k = j; k < 1002; k++) {
                    if(check[k]){
                        continue;
                    }
                    z = k;
                    answer = Math.min(answer, Math.abs(n-x*y*z));
                    if(n+1<x*y*z){
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
