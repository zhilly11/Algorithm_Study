package BOJ.Bruteforce.BOJ0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Countdivisor_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int count = 0;
        boolean flag = true;
        for (int i = 1; i < n+1; i++) {
            if (n%i ==0){
                count++;
            }
            if (count==k){
                System.out.println(i);
                flag = false;
                break;
            }
        }
        if (flag) System.out.println(0);
    }
}
