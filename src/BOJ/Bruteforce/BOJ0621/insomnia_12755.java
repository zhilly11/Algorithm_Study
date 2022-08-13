package BOJ.Bruteforce.BOJ0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
아이디어

첫번째 아이디어
n을 받고 n까지 문자열을 이어 붙힌 뒤 n번째 자리 출력
장점 -> 직관적으로 문자열을 생각하기 쉽다.
단점 -> 스트링이 너무 길어진다.

두번째 아이디어(채택)
미리 100,000,000짜리 배열을 만들어서 숫자 저장
장점 -> 간단하게 인덱스로 출력 할 수 있다.
단점 -> 배열에 숫자를 넣기 힘들다.

*/

public class insomnia_12755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < n+1; i++) {
//            sb.append(i);
//        }
        int cnt = 1;
        while(sb.length()<100000000){
            sb.append(cnt);
            cnt++;
        }
        System.out.println(sb.charAt(n-1));
    }
}
