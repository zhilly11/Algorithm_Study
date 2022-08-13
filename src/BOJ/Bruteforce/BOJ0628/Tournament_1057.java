package BOJ.Bruteforce.BOJ0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tournament_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int kim = Integer.parseInt(input[1]);
        int lim = Integer.parseInt(input[2]);
        int answer = 0;

        while(kim!=lim){
            kim = kim/2 + kim%2;
            lim = lim/2 + lim%2;
            answer++;
        }
        System.out.println(answer);
    }
}
