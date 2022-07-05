package BOJ.Bruteforce.BOJ0628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DNA_1969 {
    static int N, M;
    static String[] DNA;
    static int hd;

    public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] sarr = br.readLine().split(" ");
            N = Integer.parseInt(sarr[0]);
            M = Integer.parseInt(sarr[1]);

            DNA = new String[N];

            for (int i = 0; i < N; i++) {
                DNA[i] = br.readLine();
            }

            StringBuffer buf = new StringBuffer();

            for (int i = 0; i < M; i++) {
                int[] cnt = new int[4]; // A C G T
                for (int j = 0; j < N; j++) {
                    char ch = DNA[j].charAt(i);

                    switch (ch) {
                        case 'A' :
                            cnt[0]++;
                            break;
                        case 'C' :
                            cnt[1]++;
                            break;
                        case 'G' :
                            cnt[2]++;
                            break;
                        case 'T' :
                            cnt[3]++;
                            break;
                    }
                }

                int idx = 0;
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (cnt[k] > max || (cnt[k] == max && k < idx)) {
                        max = cnt[k];
                        idx = k;
                    }
                }

                switch (idx) {
                    case 0 :
                        buf.append('A');
                        break;
                    case 1 :
                        buf.append('C');
                        break;
                    case 2 :
                        buf.append('G');
                        break;
                    case 3 :
                        buf.append('T');
                        break;
                }
                hd += N - max;
            }
        System.out.println(buf);
        System.out.println(hd);
    }
}
