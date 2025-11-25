package baekjoon.알고리즘.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 문제_1343 {
    // [2024-03-05 JC]
    static StringBuffer sb = new StringBuffer();
    static int i;
    static String s, result;
    static int n,m;
    static int[] alphabet = new int[26];
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
    public static void when() {
        String res = "";
        res = s.replaceAll("XXXX", "AAAA");
        res = res.replaceAll("XX", "BB");
        if(res.indexOf("X") > 0) {
            res = "-1";
        }
        sb.append(res);
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}