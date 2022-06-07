package BOJ.Bruteforce.BOJ0607;
import java.io.*;
import java.util.ArrayList;

/*
* */
public class WordDevide_1251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String temp;
        ArrayList<String> str = new ArrayList<>();
        for (int i = 1; i < input.length()-1; i++) {
            for (int j = i+1; j < input.length(); j++) {
                String first = reverse(input.substring(0,i));
                String second = reverse(input.substring(i,j));
                String third = reverse(input.substring(j));

                temp = first+second+third;
                str.add(temp);

            }
        }
        str.sort(null);
        System.out.println(str.get(0));
    }
    public static String reverse(String origin){
        StringBuilder sb = new StringBuilder(origin);
        return sb.reverse().toString();
    }
}
