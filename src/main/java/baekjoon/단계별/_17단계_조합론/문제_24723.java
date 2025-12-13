package baekjoon.단계별._17단계_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_24723 {
    // [2025-12-03 JC]
    static StringBuffer sb = new StringBuffer();
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
        sb.append((int)Math.pow(2, n));
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}