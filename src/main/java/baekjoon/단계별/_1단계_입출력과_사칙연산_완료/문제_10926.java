package baekjoon.단계별._1단계_입출력과_사칙연산_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_10926 {
    // [2023-12-09 JC]
    static String result = "";
    static String s = "";
    public static void main(String[] args) throws IOException {
        given();// 테스트 실행을 준비하는 단계
        when(); // 테스트를 진행하는 단계
        then(); // 테스트 결과를 검증하는 단계
    }

    public static void given() throws IOException {
        InputStream is = System.in;						// 바이트
        InputStreamReader isr = new InputStreamReader(is);// 캐릭터
        BufferedReader br = new BufferedReader(isr);    // 스트링
        s = br.readLine();
    }
    public static void when() throws IOException {
        result = s.concat("??!");
    }
    public static void then() throws IOException {
        System.out.println(result);
    }
}
