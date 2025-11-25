package baekjoon.단계별._14단계_집합과_맵_완료;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 문제_11478 {
    // [2024-03-13 JC]
    static StringBuffer sb = new StringBuffer();
    static int i;
    static String s, result;
    static int n,m;
    static int[] alphabet = new int[26];
    static Set<String> set1 = new HashSet<>();
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
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<=s.length(); j++) {
//                System.out.println(s.substring(i, j));
                set1.add(s.substring(i, j));
            }
        }

        sb.append(set1.size());
    }
    public static void then() {
        System.out.print(sb.toString());
    }
}