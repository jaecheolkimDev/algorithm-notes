package baekjoon.단계별._5단계_문자열_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_11718 {
    // [2024-01-05 JC]
    static int tot = 0;
    static String[] tString = new String[100] , tResult = new String[100];
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링

        while(true) {
            String s = br.readLine();
            if("".equals(s)) break;

            tString[tot++] = s;
        }
    }
    public static void when() {
        if (tot >= 0) System.arraycopy(tString, 0, tResult, 0, tot);
    }
    public static void then() {
        for(int i=0; i<tot; i++) {
            System.out.println(tResult[i]);
        }
        System.out.println("tot : " + tot);
    }
}
