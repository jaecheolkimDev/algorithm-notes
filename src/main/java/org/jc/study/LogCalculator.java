package org.jc.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LogCalculator {
    // [2024-02-25 JC]
    static StringBuffer sb = new StringBuffer();
    static int base, argument;
    static double exponent;
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        System.out.print("밑을 입력하세요. : ");
        String s1 = br.readLine();
        base = Integer.parseInt(s1);
        System.out.print("진수를 입력하세요. : ");
        String s2 = br.readLine();
        argument = Integer.parseInt(s2);
    }

    public static void when() {
        exponent = Math.log(argument)/Math.log(base);
        sb.append(exponent);
    }

    public static void then() {
        System.out.println(sb.toString());
    }
}
