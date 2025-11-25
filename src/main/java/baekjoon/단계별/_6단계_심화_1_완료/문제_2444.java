package baekjoon.단계별._6단계_심화_1_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_2444 {
    // [2023-12-10 JC]
    static int i;
    static String s, result;
    static int n,m;
    static String[] sArr = new String[200];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        n = Integer.parseInt(br.readLine());
    }
    public static void when() {
        // 1번째 풀이
        for(int i=1; i<=n; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(2*i - 1));
            sb.append(" ".repeat(n - i));
            sb.append("\n");
            sArr[i] = sb.toString();
        }
        int cnt = 0 , cnt2 = 0;
        StringBuffer sb2 = new StringBuffer();
        while (true) {
            if(2*n - 1 == cnt2++) break;

            if(cnt2 == n) {
                sb2.append(sArr[n]);
                cnt = n;
            } else if(cnt2 < n){
                sb2.append(sArr[++cnt]);
            } else {
                sb2.append(sArr[--cnt]);
            }
        }
        result = sb2.toString().substring(0, sb2.toString().length()-1);

        // 2번째 풀이
//        StringBuffer sb = new StringBuffer();
//        for(int i=1; i<=2*n-1; i++) {
//            sb.append(" ".repeat(Math.abs(n - i)));
//            if(i <= n) {
//                sb.append("*".repeat(2 * i - 1));
//            } else {
//                sb.append("*".repeat(2*(i - 2*(i-n))-1));
//            }
//            sb.append("\n");
//        }
//        result = sb.toString();
    }
    public static void then() {
        System.out.print(result);
    }
}