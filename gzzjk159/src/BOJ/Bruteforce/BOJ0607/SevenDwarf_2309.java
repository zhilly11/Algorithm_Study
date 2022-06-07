package BOJ.Bruteforce.BOJ0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarf_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(dwarf);
        int sum = Arrays.stream(dwarf).sum();

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if ((sum-dwarf[i]-dwarf[j])==100){
                    d1 = i;
                    d2 = j;
                    break;
                }
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k==d1 || k==d2){
                continue;
            }
            System.out.println(dwarf[k]);
        }

    }
}
